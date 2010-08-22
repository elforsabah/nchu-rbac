// --------------角色相关--------------
var Role = Ext.data.Record.create([{
	name : 'id',
	mapping : 'id',
	type : 'int'
}, {
	name : 'roleName',
	mapping : 'roleName',
	type : 'string'
}, {
	name: 'createTime',
	mapping: 'createTime',
	type: 'date', 
}]);


var window_add_role = new Ext.Window({
	title : '添加角色',
	width : 350,
	height : 440,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	listeners : {
		'hide' : function() {
			this.setTitle('添加角色');
			this.findById('role.roleName').ownerCt.form.reset();
		}
	},
	items : [new Ext.FormPanel({
		labelWidth : 70,
		labelAlign : 'right',
		url : 'saveRole.action',
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
			fieldLabel : '角色名称',
			id : 'role.roleName',
			name : 'role.roleName',
			allowBlank : false,
			maxLength : 50
		}],
		buttonAlign : 'right',
		minButtonWidth : 60,
		buttons : [{
			text : '添加',
			handler : function(btn) {
				var frm = this.ownerCt.form;
				if (frm.isValid()) {
					btn.disable();
					var dnfield = frm.findField('role.roleName');
					frm.submit({
						waitTitle : '请稍候',
						waitMsg : '正在提交表单数据,请稍候...',
						success : function(form, action) {
							var store = grid_role.getStore();
							if (store.data.length <= 20) {
								var role = new Role({
									id : action.result.id,
									roleName : dnfield.getValue()
								});
								store.insert(0, [role]);
								if (store.data.length > 20) {
									store.remove(store.getAt(store.data.length - 1));
								}
							}
							window_add_role.setTitle('角色[ ' + dnfield.getValue() + ' ]   添加成功!!');
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

var btn_add_role = new Ext.Button({
	text : '添加角色',
	iconCls : 'icon-add',
	handler : function() {
		window_add_role.show();
	}
});

var btn_del_role = new Ext.Button({
	text : '删除角色',
	iconCls : 'icon-del',
	handler : function() {
		var record = grid_role.getSelectionModel().getSelected();
		if (record) {
			Ext.Msg.confirm('确认删除', '你确定删除该条记录?', function(btn) {
				if (btn == 'yes') {
					Ext.Ajax.request({
						url : 'deleteRole.action',
						params : {
							id : record.data.id
						},
						success : function() {
							grid_role.getStore().remove(record);
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

/***************** 权限弹出选择框 ******************/
var perm_store = new Ext.data.Store({
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
	}]),
	listeners: {
		load: function(store) {
			var index = 0;
			store.each(function(record){
				if (record.data.id > 0) {
					perm_sm.selectRow(index);
				}
				index ++;
			});
		}
	}
});

var perm_sm = new Ext.grid.CheckboxSelectionModel();

var perm_grid = new Ext.grid.GridPanel({
	height: 400,
	store: perm_store,
	cm : new Ext.grid.ColumnModel([
	         new Ext.grid.RowNumberer(),
	         perm_sm,                     
	         {header: '编号', dataIndex: 'id'},
	         {header: '名称', dataIndex: 'permName'}
	     ]),
	sm: perm_sm,
	bbar: new Ext.PagingToolbar({
		pageSize: 10,
		store: perm_store,
		displayInfo: true,
		emptyMsg: '没有记录'
	})
	
});

var window_add_perm_for_role = new Ext.Window({
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
		}
	},
	items : [perm_grid],
	buttons: [{
		text: '添加'
	}]
});

var btn_add_perm_for_role = new Ext.Button({
	text: '添加权限',
	iconCls : 'icon-plugin',
	handler : function() {
		var role = grid_role.getSelectionModel().getSelected();
		if (role) {
			window_add_perm_for_role.show();
			perm_store.load({
				params: {start:0, limit:20, roleId: role}
			});
		} else {
			Ext.Msg.alert('错误', '请选择要操作的角色');
		}
	}
});

/****************      end       ****************/


var searchRole = function() {
	ds_role.baseParams.conditions = text_search_role.getValue();
	ds_role.load({
		params : {
			start : 0,
			limit : 20
		}
	});
}

var btn_search_role = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : searchRole
});

var text_search_role = new Ext.form.TextField({
	name : 'textSearchRole',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchRole();
			}
		}
	}
});

var cm_role = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), {
	header : '角色名称',
	width : 90,
	dataIndex : 'roleName',
	sortable : true,
	editor : new Ext.form.TextField({
		allowBlank : false,
		maxLength : 50
	})
}, {
	header : '创建时间',
	dataIndex : 'createTime',
	type: 'date',
	renderer: function(value) {return Ext.util.Format.date(value, 'Y-m-d');},
	menuDisabled : true
}]);

cm_role.defaultSortable = false;

var ds_role = new Ext.data.Store({
	proxy : new Ext.data.HttpProxy({
		url : 'findAllRole.action'
	}),
	reader : new Ext.data.JsonReader({
		totalProperty : 'totalProperty',
		root : 'root'
	}, [{
		name : 'id',
		type : 'int'
	}, {
		name : 'roleName',
		type : 'string'
	}, {
		name : 'createTime',
		type : 'date',
		dateFormat: 'Y-m-dTH:i:s'
	}])
});
ds_role.load({
	params: {start: 0, limit: 0}
});
var grid_role = new Ext.grid.EditorGridPanel({
	iconCls : 'icon-plugin',
	region : 'center',
	loadMask : {
		msg : '数据加载中...'
	},
	cm : cm_role,
	ds : ds_role,
	sm : new Ext.grid.RowSelectionModel({
		singleSelect : true
	}),
	enableColumnMove : false,
	trackMouseOver : false,
	stripeRows: true,
	frame : true,
	clicksToEdit : 1,
	tbar : [btn_add_role, '-', btn_del_role, '-',btn_add_perm_for_role, '-',
			text_search_role, btn_search_role],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_role,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条  共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'afteredit' : function(e) {
			var fName = e.field;
			var fValue = e.value;
			
			if (Ext.isDate(fValue)) {
				fValue = fValue.format('Y-m-d');
			}
			alert(fValue);
			Ext.Ajax.request({
				url : 'updateRole.action',
				params : {
					fieldName : fName,
					fieldValue : fValue,
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
		},
	
		'rowdblclick':function(grid, rowIndex){
			ds_roleperm.baseParams.roleId = grid.getStore().getAt(rowIndex).data.id;
			ds_roleperm.load({params : {}});
		}
	}
});

var ds_roleperm =  new Ext.data.Store({
	url : 'findPermissionByRole.action',
	sortInfo : {field: 'permId', direction: 'ASC'},
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'id',type : 'int'}, 
		{name : 'permId',type : 'int'}, 
		{name : 'permName', type: 'string'},
		{name : 'url',type : 'string'}]
	)
});

RolePermPanel = Ext.extend(Ext.grid.GridPanel,{
	constructor:function(){
	RolePermPanel.superclass.constructor.call(this,{
	loadMask : {msg : '数据加载中...'},
		cm : new Ext.grid.ColumnModel([ 
		    new Ext.grid.RowNumberer(),
			{header : '内码',	width : 120,dataIndex : 'id'}, 
			{header : '权限内码',width : 90,	dataIndex : 'permId',sortable : true},
			{header : '权限名称',width : 100,	dataIndex : 'permName',sortable : true}, 
			{header : '权限地址',width : 100, id: 'url',	dataIndex : 'url',sortable : true} 
			]
		),
		autoExpandColumn : 'url',
		ds : ds_roleperm,
		sm : new Ext.grid.RowSelectionModel({singleSelect : true})
		
	});
}
});

var role_panel = new Ext.Panel({
	title : '角色管理',
	iconCls : 'icon-plugin',
	region : 'center',
	border : 'layout',
	frame : true,
	layout:'border',
	defaults: {
	    collapsible: true,
	    split: true
	},
	items: [{
	    region:'center',
	    layout : 'border',
	    items : [grid_role]
	},{
	    region: 'south',
	    layout :'fit',
		title : '角色拥有权限',
	    height: 250,
	    minSize: 200,
	    maxSize: 450,
	    items : [new RolePermPanel()]
	}]
});

var p_role = {
	id : 'role-panel',
	border : false,
	layout : 'border',
	items : [role_panel]
}
