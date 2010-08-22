// --------------权限相关--------------
var Permission = Ext.data.Record.create([{
	name : 'id',
	mapping : 'id',
	type : 'int'
}, {
	name : 'permName',
	mapping : 'permName',
	type : 'string'
}, {
	name : 'url',
	mapping : 'url',
	type : 'string'
}]);


var cm_perm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), {
	header : '权限名称',
	width : 90,
	dataIndex : 'permName',
	sortable : true,
	editor : new Ext.form.TextField({
		allowBlank : false,
		maxLength : 50
	})
}, {
	header : '地址',
	id : 'url',
	dataIndex : 'url',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 200
	})
}]);

cm_perm.defaultSortable = false;

var window_add_perm = new Ext.Window({
	title : '添加权限',
	width : 350,
	height : 440,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	listeners : {
		'hide' : function() {
			this.setTitle('添加权限');
			this.findById('perm.permName').ownerCt.form.reset();
		}
	},
	items : [new Ext.FormPanel({
		labelWidth : 70,
		labelAlign : 'right',
		url : 'savePermission.action',
		border : false,
		baseCls : 'x-plain',
		bodyStyle : 'padding:5px 5px 0',
		anchor : '100%',
		defaults : {
			width : 233,
			msgTarget : 'side'
		},
		defaultType : 'textfield',
		items : [{
			fieldLabel : '权限名称',
			id : 'perm.permName',
			name : 'perm.permName',
			allowBlank : false,
			maxLength : 50
		}, {
			fieldLabel : '地址',
			name : 'perm.url',
			maxLength : 200
		}],
		buttonAlign : 'right',
		minButtonWidth : 60,
		buttons : [{
			text : '添加',
			handler : function(btn) {
				var frm = this.ownerCt.form;
				if (frm.isValid()) {
					btn.disable();
					var dnfield = frm.findField('perm.permName');
					frm.submit({
						waitTitle : '请稍候',
						waitMsg : '正在提交表单数据,请稍候...',
						success : function(form, action) {
							var store = grid_perm.getStore();
							if (store.data.length <= 20) {
								var perm = new Permission({
									id : action.result.id,
									permName : dnfield.getValue(),
									url : form.findField('perm.url').getValue()
								});
								store.insert(0, [perm]);
								if (store.data.length > 20) {
									store.remove(store.getAt(store.data.length - 1));
								}
							}
							window_add_perm.setTitle('权限[ ' + dnfield.getValue() + ' ]   添加成功!!');
							frm.reset();
							btn.enable();
						},
						failure : function(form, action) {
							Ext.Msg.show({
								title : '错误提示',
								msg : '"' + dnfield.getValue() + '" ' + '名称可能已经存在!',
								buttons : Ext.Msg.OK,
								fn : function() {
									dnfield.focus(true);
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

var btn_add_perm = new Ext.Button({
	text : '添加权限',
	iconCls : 'icon-add',
	handler : function() {
		window_add_perm.show();
	}
});

var btn_del_perm = new Ext.Button({
	text : '删除权限',
	iconCls : 'icon-del',
	handler : function() {
		var record = grid_perm.getSelectionModel().getSelected();
		if (record) {
			Ext.Msg.confirm('确认删除', '你确定删除该条记录?', function(btn) {
				if (btn == 'yes') {
					Ext.Ajax.request({
						url : 'deletePermission.action',
						params : {
							id : record.data.id
						},
						success : function() {
							grid_perm.getStore().remove(record);
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
		}
	}
});

var searchPermission = function() {
	ds_perm.baseParams.conditions = text_search_perm.getValue();
	ds_perm.load({
		params : {
			start : 0,
			limit : 20
		}
	});
}

var btn_search_perm = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : searchPermission
});

var text_search_perm = new Ext.form.TextField({
	name : 'textSearchPermission',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchPermission();
			}
		}
	}
});

var ds_perm = new Ext.data.Store({
	proxy : new Ext.data.HttpProxy({
		url : 'findAllPermission.action'
	}),
	reader : new Ext.data.JsonReader({
		totalProperty : 'totalProperty',
		root : 'root'
	}, [{
		name : 'id',
		type : 'int'
	}, {
		name : 'permName',
		type : 'string'
	}, {
		name : 'url',
		type : 'string'
	}])
});

ds_perm.load({
	params: {start: 0, limit: 0}
});
var grid_perm = new Ext.grid.EditorGridPanel({
	title : '权限管理',
	iconCls : 'icon-plugin',
	region : 'center',
	loadMask : {
		msg : '数据加载中...'
	},
	cm : cm_perm,
	ds : ds_perm,
	sm : new Ext.grid.RowSelectionModel({
		singleSelect : true
	}),
	enableColumnMove : false,
	trackMouseOver : false,
	stripeRows: true,
	frame : true,
	autoExpandColumn : 'url',
	clicksToEdit : 1,
	tbar : [btn_add_perm, '-', btn_del_perm, '-', 
			text_search_perm, btn_search_perm],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_perm,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条  共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'afteredit' : function(e) {
			Ext.Ajax.request({
				url : 'updatePermission.action',
				params : {
					fieldName : e.field,
					fieldValue : e.value,
					id : e.record.data.id
				},
				success : function() {
					alert("数据修改成功！");
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

var p_perm = {
	id : 'perm-panel',
	border : false,
	layout : 'border',
	items : [grid_perm]
}
