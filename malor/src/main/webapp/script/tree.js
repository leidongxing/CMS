$(function(){
   $('#eq_ip').click(function(){
       var arr=[[
		{
		 title : '设备sn码',
		 field : 'name',
		 width : 220,
		},
		{
		 field : 'ip',title :'ip', width:200,editor:{type:'combobox',
					               options:{valueField:'ip',textField:'ip',panelHeight:'50',
                                   url:'searchServlet?action=Ip',
                                   method:'GET',
					               }}
	    },
		{
		  title :'ip类型',
		  field:'ip_type',
		  width: 120,
		  editor:{type:'combobox',
		          options:{ valueField:'type',textField:'type',panelHeight:'45',
		          data:[{type:'远控ip'},{type:'业务ip'}] } },	
		},
		{
		 title : '最后更新时间',
	 	 field : 'update_time',
		 width : 180,
        },
        {
         title : '操作者',
	 	 field : 'operator_name',
		 width : 100,
        } 
      ]];
      main_reuse('设备','ip','eq','ip','ip','eq_ip',arr,'icon-ip');     
   });
   $('#sw_ip').click(function(){
       var arr=[[
		{
		 title : '交换机sn码',
		 field : 'name',
		 width : 220,
		},
		{
		 field : 'ip',title :'ip', width:200,editor:{type:'combobox',
					               options:{valueField:'ip',textField:'ip',panelHeight:'50',
                                   url:'searchServlet?action=Ip',
                                   method:'GET',
					               }}
	    },
		{
		 title : '最后更新时间',
	 	 field : 'update_time',
		 width : 180,
        },
        {
         title : '操作者',
	 	 field : 'operator_name',
		 width : 100,
        } 
      ]];
      main_reuse('交换机','ip','sw','ip','ip','sw_ip',arr,'icon-ip');
   });
    $('#eq_sw').click(function(){
       var arr=[[
		{
		 title : '设备sn码',
		 field : 'name',
		 width : 220,
		},
		{
		 field : 'switch_sncode',title :'交换机sn码', width:200,editor:{type:'combobox',
					               options:{valueField:'switch_sncode',textField:'switch_sncode',panelHeight:'50',
                                   url:'searchServlet?action=Sw',
                                   method:'GET',
					               }}
	    },
		{
		 title : '最后更新时间',
	 	 field : 'update_time',
		 width : 180,
        },
        {
         title : '操作者',
	 	 field : 'operator_name',
		 width : 100,
        } 
      ]];
      main_reuse('设备','交换机','eq','sw','switch_sncode','eq_sw',arr,'icon-switch');
   });
    $('#ip_node').click(function(){
       var arr=[[
		{
		 title : 'ip',
		 field : 'name',
		 width : 220,
		},
		{
		 field : 'node_name',title :'节点名称', width:200,editor:{type:'combobox',
					               options:{valueField:'node_name',textField:'node_name',panelHeight:'50',
                                   url:'searchServlet?action=Node',
                                   method:'GET',
					               }}
	    },
		{
		 title : '最后更新时间',
	 	 field : 'update_time',
		 width : 180,
        },
        {
         title : '操作者',
	 	 field : 'operator_name',
		 width : 100,
        } 
      ]];
      main_reuse('ip','节点','ip','no','node_name','ip_node',arr,'icon-node');
   });
   $('#sw_node').click(function(){
       var arr=[[
		{
		 title : '交换机sn码',
		 field : 'name',
		 width : 220,
		},
		{
		 field : 'node_name',title :'节点名称', width:200,editor:{type:'combobox',
					               options:{valueField:'node_name',textField:'node_name',panelHeight:'50',
                                   url:'searchServlet?action=Node',
                                   method:'GET',
					               }}
	    },
		{
		 title : '最后更新时间',
	 	 field : 'update_time',
		 width : 180,
        },
        {
         title : '操作者',
	 	 field : 'operator_name',
		 width : 100,
        } 
      ]];
      main_reuse('交换机','节点','sw','no','node_name','sw_node',arr,'icon-node');
   });
   $('#eq_node').click(function(){
       var arr=[[
		{
		 title : '设备sn码',
		 field : 'name',
		 width : 220,
		},
		{
		 field : 'node_name',title :'节点名称', width:200,editor:{type:'combobox',
					               options:{valueField:'node_name',textField:'node_name',panelHeight:'50',
                                   url:'searchServlet?action=Node',
                                   method:'GET',
					               }}
	    },
		{
		 title : '最后更新时间',
	 	 field : 'update_time',
		 width : 180,
        },
        {
         title : '操作者',
	 	 field : 'operator_name',
		 width : 100,
        } 
      ]];
      main_reuse('设备','节点','eq','no','node_name','eq_node',arr,'icon-node');
   });   
   $('#su_node').click(function(){
       var arr=[[
		{
		 title : '供应商名称',
		 field : 'name',
		 width : 220,
		},
		{
		 field : 'node_name',title :'节点名称', width:200,editor:{type:'combobox',
					               options:{valueField:'node_name',textField:'node_name',panelHeight:'50',
                                   url:'searchServlet?action=Node',
                                   method:'GET',
					               }}
	    },
		{
		 title : '最后更新时间',
	 	 field : 'update_time',
		 width : 180,
        },
        {
         title : '操作者',
	 	 field : 'operator_name',
		 width : 100,
        } 
      ]];
      main_reuse('供应商','节点','su','no','node_name','su_node',arr,'icon-node');
   });
   

   
/**
 * [main_reuse description] 综合管理 组件初始化函数（可复用）
 * @param  {[type]} main_key1    [description]  关联关系 string 根节点  如 设备 交换机 ip 供应商
 * @param  {[type]} main_key2    [description]  关联关系 string 子节点  如  交换机 ip 节点 
 * @param  {[type]} main_mark1   [description]  关联关系 根节点id标识字段  string  如 eq sw ip 
 * @param  {[type]} main_mark2   [description]  关联关系 子节点id标识字段  string  如 ip sw no su
 * @param  {[type]} main_mark3   [description]  关联关系 子节点标识字段  string  如 ip switch_sncode equipment_sncode 
 * @param  {[type]} main_url     [description]  请求url参数 string 如 eq_ip  
 * @param  {[type]} main_columns [description]  treegrid数据表格列配置属性 array 如[{}]
 * @param  {[type]} main_icon    [description]  添加节点icon
 * @return {[type]}              [description]  
 */
function main_reuse(main_key1,main_key2,main_mark1,main_mark2,main_mark3,main_url,main_columns,main_icon){
	//根节点右击菜单 
    $('#mm_root').menu('setText',{  
	     target:$('#mm_root').menu('getItem','#append').target,
	     text:'添加关联'+main_key2,
    });
    $('#mm_root').menu({	
       minwidth:250,	
       onClick:function(item){   //根节点添加子节点
	        var node=$('#table').treegrid('getSelected');
	        if(node.id){
	          var append_id=main_mark2+new Date().getTime(); //生成含有子节点标识字段的id
		      if(node.id.slice(0,2)===main_mark1){   
		        $('#table').treegrid('append',{
		          parent:node.id,
		          data:[{
			         id:append_id,
			         name:'关联'+main_key2,
			         iconCls:main_icon,
	                }],
	            });
	            $('#table').treegrid('beginEdit',append_id);  
	            $('#table').treegrid('expand',node.id);    
	          }
	       }
	    }   
	});
    //子节点右击菜单
    $('#mm_leaf').menu('setText',{
	     target: $('#mm_leaf').menu('getItem','#remove').target,
	     text:'删除关联'+main_key2,
    });
    $('#mm_leaf').menu('setText',{
    	 target: $('#mm_leaf').menu('getItem','#save').target,
	     text:'保存本次操作',
    });   
	$('#mm_leaf').menu({
        onClick:function(item){
        	var node = $('#table').treegrid('getSelected');
            var input={}; //构造用于请求服务器的对象
            if(item.name==='remove'){  //删除子节点
            	input[main_mark1]=$('#table').treegrid('getParent',node.id).name;  //包括根节点标识字段(name属性) 
		        input[main_mark2]=node[main_mark3];  //包括子节点标识字段
		        input['id']=node.id.slice(2); //包括子节点id 去除子节点标识字段
		        if(node['ip_type']){     //设备比较特殊 多一个ip_type属性于要加入
		            input['ip_type']=node['ip_type'];
		        }
            	if(input[main_mark2]){    //如果子节点标识字段存在(关联关系存在) 请求用户确认并请求服务器
	          	   $.messager.confirm('确认', '您确认想要删除 '+input[main_mark1]+' 与 '+input[main_mark2]+'的关联关系吗？', function(r){
			            if(r){
			               $.ajax({
			    		      type:"POST",     
			    	          data:"data="+JSON.stringify(input),
			    		      url:"mainServlet?action=delete"+main_url,
			    		      success:function(data){
				    		     if(data==="1"){
				    		       $('#table').treegrid('remove',node.id); 
				    		     }
				    		     else{
				    		       $.messager.alert('错误','删除失败','error');
				    		       $('#table').treegrid('reload');	
				    		     }   
				    		  }   
			               }); 
			            }
	               });
                }
                else{
                     $('#table').treegrid('remove',node.id); //直接在界面上删除
                } 
            }              
		   else if(item.name==='save'){ //保存操作
              if(($('#table').treegrid('getEditors',node.id).length!=0)){ //正处于编辑状态的才需要保存操作
              	   $('#table').treegrid('endEdit',node.id);
              	   console.log(node);
                   input[main_mark1]=$('#table').treegrid('getParent',node.id).name;  //包括根节点标识字段(name属性) 
		           input[main_mark2]=node[main_mark3];  //包括子节点标识字段
		           input['id']=node.id.slice(2); //包括子节点id 去除子节点标识字段
		           if(node['ip_type']){     //设备比较特殊 多一个ip_type属性于要加入
		            input['ip_type']=node['ip_type'];
		           }              
	               if(input[main_mark2]){ //如果子节点标识字段存在  说明关联关系存在 则请求服务器
                      $.ajax({
		    		      type:"POST",     
		    	          data:"data="+JSON.stringify(input),
		    		      url:"mainServlet?action=update"+main_url,
		    		      success:function(data){
			    		     if(data==="1"){
			    		       $.messager.alert('成功','操作成功','info');
			    		     }
			    		     else{
                               $.messager.alert('错误','操作失败'+data,'error',function(){
                               	   $('#table').treegrid('reload');
                               }); 
			    		     }   
			    		  }   
	                  });
	               }
                   else{
                    $.messager.alert('操作未生效','关联字段格式不存在或者不正确','error');
                    $('#table').treegrid('reload');	
                  }   
              }   
           }
      }       
    });
    /*初始化treegrid表格*/
	$('#table').treegrid({
  	    title:'关联'+main_key1+'与'+main_key2,
  	    iconCls:'icon-reload',
  	    height:'450',
  	    animate:true,
  	    toolbar:['----',{
            iconCls:'icon-all',
            text:'查看所有'+main_key1+'关联情况',
            handler:function(){
              $('#table').treegrid('reload');
           }
  	    },'----',
  	    {
  	    	iconCls:'icon-not',
  	    	text:'仅显示未关联'+main_key2+'的'+main_key1,
  	    	handler:function(){
             var roots_arr=$('#table').treegrid('getRoots'); 
             var output=[];
             $.each(roots_arr,function(index,element){
             	if(element['children'].length==0){  
             	   output.push(element);
             	}
             });
             $('#table').treegrid('loadData',output);
            }
  	    },'----',
        {
  	    	iconCls:'icon-yes',
  	    	text:'显示已关联'+main_key2+'的'+main_key1,
  	    	handler:function(){
             var roots_arr=$('#table').treegrid('getRoots'); 
             var output=[];
             $.each(roots_arr,function(index,element){
             	if(element['children'].length!=0){  
             	   output.push(element);
             	}
             });
             $('#table').treegrid('loadData',output);
            }
  	    }
  	    ],
		url:"mainServlet?action=show"+main_url,
		method:'GET',
	    idField :'id',
		treeField:'name',
	    columns:main_columns, 
		onBeforeExpand:function(row){  //空节点 禁止展开 从而禁止请求服务器
           if(row.children.length==0){
              return false;
           }
		},
		onContextMenu:function(e,row){
			e.preventDefault();
			$(this).treegrid('select',row.id);
			var node = $('#table').treegrid('getSelected');  
			if((node.id.slice(0,2)===main_mark1)){  //如果点击为根节点(id中含有根节点标识字段)
                $('#mm_root').menu('show',{
					left: e.pageX,
					top: e.pageY,
				});
			} 	
		    else if(node.id.slice(0,2)===main_mark2){ //如果点击为子节点(id中含有子节点标识字段)
				$('#mm_leaf').menu('show',{
					left: e.pageX,
					top: e.pageY,
				});
		    }
		 
		},
		onDblClickRow:function(row){  
          var node=$('#table').treegrid('getSelected');
		  if(node.id.slice(0,2)===main_mark2){
             $(this).treegrid('beginEdit',row.id);
           }
		},
		onBeforeCollapse:function(row){	
          var root_leaf=$('#table').treegrid('getChildren',row.id);
	      var edit_leaf=[];
	      $.each(root_leaf,function(index,element){
	        if($('#table').treegrid('getEditors',element.id).length!=0){
	           edit_leaf.push(element);
	        }
	      });
	       if(edit_leaf.length!=0){
	       	  $.messager.alert('警告','操作未保存','warning'); 
	       }     
		},
		onCollapse:function(row){
		  var root_leaf=$('#table').treegrid('getChildren',row.id);
		  $.each(root_leaf,function(index,element){
	       if($('#table').treegrid('getEditors',element.id).length!=0){//处于编辑状态
	           $('#table').treegrid('cancelEdit',element.id); //放弃编辑
	            if(!element[main_mark3]){      //子节点节点标识字段不存在  新添加的无效的关联关系 
	           	    $('#table').treegrid('remove',element.id); //直接删除 
	           }
	        }
	      });
		},
    });  
}  

}); 


