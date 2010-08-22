var MyUser = Ext.data.Record.create([{
	name : 'id',
	mapping : 'id',
	type : 'int'
}, {
	name : 'username',
	mapping : 'username',
	type : 'string'
}, {
	name : 'createTime',
	mapping : 'createTime',
	type : 'date',
	format: 'Y-m-d'
}]);

var cm_myuser = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), {
	header : '用户名',
	width : 90,
	sortable : true,
	dataIndex : 'username',
	editor : new Ext.form.TextField({
		allowBlank : false,
		maxLength : 50
	})
}, {
	header : '创建时间',
	id: 'createTime',
	dataIndex : 'createTime',
	renderer: function(value) {return Ext.util.Format.date(value, 'Y-m-d');},
	menuDisabled : true
	
}]);

cm_myuser.defaultSortable = false;

var window_add_myuser = new Ext.Window({
	title : '添加用户',
	width : 350,
	height : 440,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	listeners : {
		'hide' : function() {
			this.setTitle('添加用户');
			this.findById('myuser.username').ownerCt.form.reset();
		}
	},
	items : [new Ext.FormPanel({
		labelWidth : 70,
		labelAlign : 'right',
		url : 'saveUser.action',
		border : false,
		baseCls : 'x-plain',
		bodyStyle : 'padding:5px 5px 0',
		anchor : '100%',
		defaults : {
			width : 233,
			msgTarget : 'side' // 验证信息显示右边
		},
		defaultType : 'textfield',
		items : [{
			fieldLabel : '用户名称',
			id : 'myuser.username',
			name : 'myuser.username',
			allowBlank : false,
			maxLength : 50
		}, {
			fieldLabel : '创建时间',
			name : 'myuser.createTime',
			maxLength : 70
		}],
		buttonAlign : 'right',
		minButtonWidth : 60,
		buttons : [{
			text : '添加',
			handler : function(btn) {
				var frm = this.ownerCt.form;
				if (frm.isValid()) {
					btn.disable();
					var cnfield = frm.findField('myuser.username'); // 获得公司名称输入框
					frm.submit({
						waitTitle : '请稍候',
						waitMsg : '正在提交表单数据,请稍候...',
						success : function(form, action) {
							var store = grid_myuser.getStore();
							if (store.data.length <= 20) {
								var myuser = new MyUser({
									id : action.result.id,
									username : cnfield.getValue(),
									createTime : form.findField('myuser.createTime').getValue()
								
								});
								store.insert(0, [myuser]);
								if (store.data.length > 20) {
									store.remove(store.getAt(store.data.length - 1));
								}
							}
							window_add_myuser.setTitle('[ ' + cnfield.getValue() + ' ]   添加成功!!');
							cnfield.reset();
							btn.enable();
						},
						failure : function() {
							Ext.Msg.show({
								title : '错误提示',
								msg : '"' + cnfield.getValue() + '" ' + '名称可能已经存在!',
								buttons : Ext.Msg.OK,
								fn : function() {
									cnfield.focus(true);
									btn.enable();
								},
								icon : Ext.Msg.ERROR
							});
						}
					});
				}
			}
		}, {
			text : '重置',
			handler : function() {
				this.ownerCt.form.reset();
			}
		}, {
			text : '取消',
			handler : function() {
				this.ownerCt.ownerCt.hide();
			}
		}]
	})]
});

var btn_add_myuser = new Ext.Button({
	text : '添加用户',
	iconCls : 'icon-add',
	handler : function() {
		window_add_myuser.show();
	}
});

var btn_del_myuser = new Ext.Button({
	text : '删除用户',
	iconCls : 'icon-del',
	handler : function() {
		var record = grid_myuser.getSelectionModel().getSelected();
		if (record) {
			Ext.Msg.confirm('确认删除', '你确定删除该条记录?', function(btn) {
				if (btn == 'yes') {
					Ext.Ajax.request({
						url : 'deleteUser.action',
						params : {
							id : record.data.id
						},
						success : function() {
							grid_myuser.getStore().remove(record);
						},
						failure : function() {
							Ext.Msg.show({
								title : '错误提示',
								msg : '删除时发生错误!',
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.ERROR
							});
						}
					});
				}
			});
		} else {
			Ext.Msg.alert('提示', '请选择要删除的记录！');
		}
	}
});

var btn_reset_password = new Ext.Button({
	text: '重置密码',
	iconCls: 'icon-edit',
	handler: function() {
		var record = grid_myuser.getSelectionModel().getSelected();
		if (record) {
			Ext.Msg.confirm('确认重置密码', '你确定要重置该用户的密码吗？', function(btn) {
				if (btn== 'yes') {
					Ext.Ajax.request({
						url : 'resetPassword.action',
						params: {
							id : record.data.id
						},
						success : function() {
							Ext.Msg.alert('操作成功', '重置用户密码成功!')
						},
						failure: function() {
							Ext.Msg.show({
								title: '错误提示',
								msg: '重置密码时发生错误',
								buttons: Ext.Msg.OK,
								icon: Ext.Msg.ERROR
							});
						}
					});
				}
			})
		} else {
			Ext.Msg.alert('提示', '请选择要操作的用户');
		}
	}
});

var text_search_myuser = new Ext.form.TextField({
	name : 'textSearchMyUser',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchMyUser();
			}
		}
	}
});

// grid的查找方法
var searchMyUser = function() {
	// 传参数一定要用这种方式,否则翻页的时候不会根据这些参数查询
	ds_myuser.baseParams.conditions = text_search_myuser.getValue();
	ds_myuser.load({
		params : {
			start : 0,
			limit : 20
		}
	});
}

var btn_search_myuser = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : searchMyUser
});

var ds_myuser = new Ext.data.Store({
	proxy : new Ext.data.HttpProxy({
		url : 'findAllUser.action'
	}),
	reader : new Ext.data.JsonReader({
		totalProperty : 'totalProperty',
		root : 'root'
	}, [{
		name : 'id',
		type : 'int'
	}, {
		name : 'username',
		type : 'string'
	}, {
		name : 'createTime',
		type : 'string'
	}])
});
ds_myuser.load({
	params: {start: 0, limit: 0}
});
var grid_myuser = new Ext.grid.EditorGridPanel({
	title : '用户管理',
	iconCls : 'icon-grid',
	loadMask : {msg : '数据加载中...'},
	region : 'center',
	cm : cm_myuser,
	ds : ds_myuser,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	enableColumnMove : false,
	trackMouseOver : false,
	frame : true,
	autoExpandColumn : 'createTime',
	clicksToEdit : 1,
	tbar : [btn_add_myuser, '-', btn_reset_password, '-', btn_del_myuser, '-', text_search_myuser, btn_search_myuser],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_myuser,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条  共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'afteredit' : function(e) {
			Ext.Ajax.request({
				url : 'updateUser.action',
				params : {
					fieldName : e.field,
					fieldValue : e.value,
					id : e.record.data.id
				},
				success : function() {
					// alert("数据修改成功！");
				},
				failure : function() {
					Ext.Msg.show({
						title : '错误提示',
						msg : '修改数据发生错误,操作将被回滚!',
						fn : function() {
							e.record.set(e.field, e.originalValue);
						},
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.ERROR
					});
				}
			});
		}
	}
});

var p_myuser = {
	id : 'myuser-panel',
	border : false,
	layout : 'border',
	items : [grid_myuser]
};