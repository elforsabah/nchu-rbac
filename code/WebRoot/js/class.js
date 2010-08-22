
/* column model */
var cm_class = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), {
	header : '职务名称',
	sortable : true,
	menuDisabled : true,
	width : 90,
	dataIndex : 'className',
	editor : new Ext.form.TextField({
		allowBlank : false,
		maxLength : 20
	})
}, {
	header : '备注',
	id : 'remark',
	dataIndex : 'remark',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 100
	})
}]);


var data = [ 
	[1,"wilson.fu","memo1"], 
	[2,"wilson.fu2","memo2"], 
	[3,"wilson.fu3","memo3"] 
];

	
/* data store */
var ds_class = new Ext.data.SimpleStore({ 
	fields:[ 
	        {name:"id"}, 
	        {name:"className"}, 
	        {name:"remark"} 
	        ] 
}); 
ds_class.loadData(data); 


/* add window */
var window_add = new Ext.Window({
	title : '添加班级',
	width : 350,
	height : 440,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	listeners : {
		'hide' : function() {
			this.setTitle('添加班级');
			this.findById('class.className').ownerCt.form.reset();
		}
	},
	items : [new Ext.FormPanel({
		labelWidth : 70,
		labelAlign : 'right',
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
			fieldLabel : '班级名称',
			id : 'class.className',
			name : 'class.className',
			allowBlank : false,
			maxLength : 20
		}, {
			fieldLabel : '备注',
			name : 'class.remark',
			maxLength : 100
		}],
		buttonAlign : 'right',
		minButtonWidth : 60,
		buttons : [{
			text : '添加',
			handler : function(btn) {
				alert("添加成功");
				this.ownerCt.ownerCt.hide();
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

var search_area = new Ext.Panel({
	layout: "form",
	defaultType: "textfield",
	items:[{
		fieldLabel: "条件"		
	}]
	
});

var btn_add = new Ext.Button({
	text : '添加班级',
	iconCls : 'icon-add',
	handler : function() {
		window_add.show();
	}
});

var btn_del = new Ext.Button({
	text : '删除班级',
	iconCls : 'icon-del',
	handler : function() {
		var record = grid_class.getSelectionModel().getSelected();
		if (record) {
			Ext.Msg.confirm('确认删除', '你确定删除该条记录?', function(btn) {
				if (btn == 'yes') {
					alert("删除成功!")
				}
			});
		}
	}
});

var btn_search = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		ds_class.loadData();
	}
});




/* grid area */
var grid_class = new Ext.grid.EditorGridPanel({
	title : '班级管理',
	iconCls : 'icon-grid',
	loadMask : {
		msg : '数据加载中...'
	},
	region : 'center',
	cm : cm_class,
	ds : ds_class,
	sm : new Ext.grid.RowSelectionModel({
		singleSelect : true
	}),
	enableColumnMove : false,
	trackMouseOver : false,
	frame : true,
    model : 'local',
	clicksToEdit : 1,
	tbar : [btn_add, 
	        '-', 
	        btn_del, 
	        '-',
	        search_area,
	        btn_search],
	listeners : {
		
	}
});

/* main area */
var p_class = {
	id : 'class-panel',
	border : false,
	layout : 'border',
	items : [grid_class]
};