  $(function(){
	 var str=[[
			{ field : 'checkbox',title:'',checkbox:true},
			{ field : 'equipment_sncode',title :'设备sn码',width:130},
			{ field : 'equipment_brand', title : '设备品牌',editor:'text',width:55},
			{ field : 'cpu_num',title:'cpu个数',editor:'text',width:50},
			{ field : 'cpu_model', title : 'cpu型号',editor:'text',width:70},
			{ field : 'memory_num',title : '内存数量',editor:'text',width:55},
			{ field : 'memory_clock', title : '内存频率',editor:'text',width:55},
			{ field : 'memory_size', title : '内存大小',editor:'text',width:55},
			{ field : 'harddisk_num',title : '硬盘数量',editor:'text',width:55},
			{ field : 'harddisk_size',title : '硬盘容量',editor:'text',width:55},
			{ field : 'nic_num',title : '网卡数量',editor:'text',width:55},
			{ field : 'nic_model',title : '网卡品牌型号',editor:'text',width:85},
			{ field : 'raid',title : 'raid卡',editor:'text'},
			{ field : 'power',title : '电源',editor:'text'},
			{ field : 'equipment_buy_time',title : '购买时间',editor:'datebox',width:70},
			{ field : 'equipment_warranty_time',title : '保修时间',editor:'datebox',width:70},
			{ field :  'remark', title :'备注',editor:'text'},
			{ field : 'update_time',title : '最后更新时间',width:130},
			{ field : 'operator_name',title : '操作者',width:75},
			]];
   base_reuse('#eq_table',1250,str,'#eq_combo','#eq_form',350,'#eq_toolbar','Eq','equipment_sncode','设备');
 });

			
					