$(function(){ 
	var str=[[
			{ field : 'checkbox',title:'',checkbox:true},
			{ field : 'switch_sncode',title :'交换机sn码',},
			{ field : 'switch_brand', title : '交换机品牌',editor:'text'},
			{ field : 'switch_mode',title : '交换机型号',editor:'text'},
			{ field : 'switch_buy_time', title : '购买时间',editor:'datebox',width:100},
			{ field : 'switch_warranty_time',title : '保修时间',editor:'datebox',width:100},
			{ field : 'remark', title : '备注',editor:'text'},
			{ field : 'update_time', title : '最后更新时间',width:100},
			{ field : 'operator_name',title :'操作者'},
			]];
    base_reuse('#switch_table',1250,str,'#switch_combo','#switch_form',250,'#switch_toolbar','Sw','switch_sncode','设备');			
});			
		