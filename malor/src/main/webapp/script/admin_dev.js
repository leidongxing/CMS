$(function(){	
	//扩展editor方法    addEditor与removeEditor
	$.extend($.fn.datagrid.methods, {
        addEditor : function(jq, param) {
            $.each(param, function(index, item) {
                var e = $(jq).datagrid('getColumnOption',item.field);
                e.editor = item.editor;
            });
        },
        removeEditor : function(jq,param) {
            $.each(param, function(index, item) {
                var e = $(jq).datagrid('getColumnOption',item.field);
                e.editor ="";
            });
        }
    });
     $('#dev_table').treegrid({	
			        height:500,
			        width:1250,
			        idField :'id',
		            treeField:'name',
			        title:'设备管理',
			        url:'optionServlet?action=showAdminTree',
			        columns:[[
							{ field : 'name',title:'设备名称',width:200,halign:'center'},				       
							{ field : 'dev_sncode',title :'设备sn码',width:130,halign:'center'},
							{ field : 'hardware_version',title:'硬件版本',width:130,halign:'center'},
							{ field : 'software_version', title:'软件版本',width:130,halign:'center'},
							{ field : 'platform_version',title:'平台版本',width:130,halign:'center'},
							{ field : 'config_version', title:'配置版本',width:130,halign:'center'},
                            { field : 'dev_status', title:'设备状态',width:130,halign:'center'},
							{ field : 'dev_home',title :'设备归属实验室', width:130,halign:'center'},                                   
							]],
			        toolbar:'#dev_toolbar',
					iconCls:'icon-system',
					onBeforeExpand:function(row){  //空节点 禁止展开 从而禁止请求服务器
                       if(row.children.length==0){
                         return false;
                       }
		            },
		            onContextMenu:function(e,row){
		    			e.preventDefault();
		    			if(row===null){
		    			  //console.log("保留");
		    			}
		    			else
		    			{	
			    			$(this).treegrid('select',row.id);
			    			var node = $('#dev_table').treegrid('getSelected');  
			    			if((node.id.slice(0,4)==='root')){  //如果点击为根节点(id中含有根节点标识字段
			                    $('#mm_root').menu('show',{
			    					left: e.pageX,
			    					top: e.pageY,
			    				});
			    			} 	
			    		    else if(node.id.slice(0,3)==='sub'){ //如果点击为二级节点(id中含有二级节点标识字段
			    				$('#mm_sub').menu('show',{
			    					left: e.pageX,
			    					top: e.pageY,
			    				});
			    		    }
			    		    else if(node.id.slice(0,4)==='leaf'){//如果点击为三级节点(id中含有三级节点标识字段
			    		    	$('#mm_leaf').menu('show',{
			    					left: e.pageX,
			    					top: e.pageY,
			    				});
			    		    }
		    			}	
		    		},
    });
	//三种不同节点的编辑器数组
	var root_editor=[{field:'name',editor:'text'},{field:'dev_home',editor:{type:'combobox',
                    options:{valueField:'dev_home',textField:'dev_home',panelHeight:'100',
                     data:[{dev_home:'郑西实验室'},{dev_home:'广深港实验室'},{dev_home:'CBTC实验室'},
                           {dev_home:'列控实验室'},{dev_home:'平台实验室'},{dev_home:'综合监控实验室'},
                           {dev_home:'DMI实验室'}]}}}];
    var sub_editor=[{field:'name',editor:'text'}];
	var leaf_editor=[{field:'name',editor:'text'},{field:'dev_sncode',editor:'text'},{field:'hardware_version',editor:'text'},
	       		     {field:'software_version',editor:'text'}, {field:'platform_version',editor:'text'},
                     {field:'config_version',editor:'text'},{field:'dev_status',editor:{type:'combobox',
                      options:{valueField:'dev_status',textField:'dev_status',panelHeight:'65',
                      data:[{dev_status:'正常'},{dev_status:'损坏(可修复)'},{dev_status:'损坏(不可修复)'}]}}}];
    function showRootEditor(nodeId){
        $('#dev_table').treegrid('removeEditor',sub_editor);
 		$('#dev_table').treegrid('removeEditor',leaf_editor);
 		$('#dev_table').treegrid('addEditor',root_editor);
 		$('#dev_table').treegrid('select',nodeId); 
    	$('#dev_table').treegrid('beginEdit',nodeId);
    }
    function showSubEditor(nodeId){
        $('#dev_table').treegrid('removeEditor',root_editor);
        $('#dev_table').treegrid('removeEditor',leaf_editor);
        $('#dev_table').treegrid('addEditor',sub_editor);
        $('#dev_table').treegrid('select',nodeId); 
    	$('#dev_table').treegrid('beginEdit',nodeId);
    }
    function showLeafEditor(nodeId){
        $('#dev_table').treegrid('removeEditor',root_editor);
 		$('#dev_table').treegrid('removeEditor',sub_editor);
 		$('#dev_table').treegrid('addEditor',leaf_editor);
 		$('#dev_table').treegrid('select',nodeId); 
    	$('#dev_table').treegrid('beginEdit',nodeId);
    }

    //保存已有的 编辑状态节点id
    var edit_root=[];
    var edit_sub=[];
    var edit_leaf=[];
    //保存新增的 编辑状态节点id
    var add_sub=[];
    var add_root_leaf=[];
    var add_sub_leaf=[];
    //保存需要删除的 节点id
    var remove_root=[];
    var remove_sub=[];
    var remove_leaf=[];
    function isExist(id,str){
        for(i in str){
        	if(id===str[i]){
        		return true;
        	}
        }
        return false;
    }
    
    $('#mm_root').menu({
        onClick:function(item){
        	var node = $('#dev_table').treegrid('getSelected');
            if(item.id==='rootAddSub'){ 
    	        if(node.id){
    	          var append_id='sub'+new Date().getTime(); //生成sub id
    		        $('#dev_table').treegrid('append',{
    		          parent:node.id,
    		          data:[{id:append_id,name:'新增二级设备',iconCls:'icon-sub',}],
    	            });
    		        showSubEditor(append_id);
    		        $('#dev_table').treegrid('expand',node.id);         
    	            add_sub.push(append_id);              
    		     }   
             }
             else if(item.id==='rootAddLeaf'){
            	 if(node.id){
       	          var append_id='leaf'+new Date().getTime(); //生成leaf id
       		        $('#dev_table').treegrid('append',{
       		          parent:node.id,
       		          data:[{id:append_id,name:'新增三级设备',iconCls:'icon-leaf',}],
       	            });
       		        showLeafEditor(append_id);
 		            $('#dev_table').treegrid('expand',node.id);
       	            add_root_leaf.push(append_id);   	                       	            
       		     }      
            }
            else if(item.id==='editRoot'){
            	if(node.id){
            		showRootEditor(node.id); 
       	            edit_root.push(node.id); 
            	}
            }
            else if(item.id==='removeRoot'){
            	if(node.id){
            	    $('#dev_table').treegrid('remove',node.id); 
                    remove_root.push(node.id);
                    if(isExist(node.id,edit_root)){
                    	edit_root.pop(node.id);
                    }
            	}
            }
            else if(item.id==='endRoot'){
                if(node.id){
                	$('#dev_table').treegrid('cancelEdit',node.id);
                	edit_root.pop(node.id);
                }
            }
        }   
     });
    $('#mm_sub').menu({
        onClick:function(item){
        	var node = $('#dev_table').treegrid('getSelected');     	     
            if(item.id==='subAddLeaf'){ 
            	if(node.id){
       	          var append_id='leaf'+new Date().getTime(); //生成leaf id
       		        $('#dev_table').treegrid('append',{
       		          parent:node.id,
       		          data:[{id:append_id,name:'新增三级设备',iconCls:'icon-leaf',}],
       	            });  
       		        showLeafEditor(append_id);		            
 		            $('#dev_table').treegrid('expand',node.id);
       	            add_sub_leaf.push(append_id);    	                       	            
       		    }    
            }
            else if(item.id==='removeSub'){
              if(node.id){
                 $('#dev_table').treegrid('remove',node.id); 
                 if(isExist(node.id,add_sub)){  
                    add_sub.pop(node.id);
                 }
                 else{
                 	remove_sub.push(node.id);
                 }

                 if(isExist(node.id,edit_sub)){
                 	edit_sub.pop(node.id);
                 }
              }
            } 
            else if(item.id==='editSub'){
              if(node.id){   
                  showSubEditor(node.id);
                  edit_sub.push(node.id);   
               }
            }
            else if(item.id==='endSub'){
            	if(node.id){
            	  $('#dev_table').treegrid('cancelEdit',node.id);
            	  edit_sub.pop(node.id);
            	}
            }
        }    
     }); 


    $('#mm_leaf').menu({
        onClick:function(item){
        	var node = $('#dev_table').treegrid('getSelected');
              if(item.id==='removeLeaf'){ 
            	 if(node.id){  	 	
            	    $('#dev_table').treegrid('remove',node.id);
            	    if(isExist(node.id,add_root_leaf)){
            	       remove_root_leaf.push(node.id); 	
            	    }
            	    else if(isExist(node.id,add_sub_leaf)){
            	       remove_sub_leaf.push(node.id);
            	    }

                    if(isExist(node.id,edit_leaf)){
                 	  edit_leaf.pop(node.id);
                    }
            	 }
               }
               else if(item.id==='editLeaf'){
               	  if(node.id){
                     showLeafEditor(node.id);
       	             edit_leaf.push(node.id);
               	  }  	 
               }
               else if(item.id==='endLeaf'){
            	 if(node.id){
            	   $('#dev_table').treegrid('cancelEdit',node.id);
            	   edit_leaf.pop(node.id);
            	 }
               }
         }                  
     }); 
    $('#dev_form').dialog({
    	    width:500,
    	    height:300,
			draggable: false,
			modal : true,
			closed : true,
			title:'添加一级设备',
			iconCls:'icon-add',
			onClose:function(){
			  $(this).form('reset');
			},
			buttons:[{
					text:'确认添加',
					iconCls :'icon-edit-new',
					handler:function(){
			         var isValid=$('#dev_form').form('enableValidation').form('validate');
				     if(isValid){
				       var data=formToJson('#dev_form'); 	
                        $.ajax({
			    		     type:"POST",     
			    	         data:"data="+data,
			    		     url:"optionServlet?action=addRoot",
			    		     beforeSend:function(){
				    		    $.messager.progress({
				    		       title:'添加该设备',
				    		       text:'正在添加中....',
				    		    });
				    		  },
			    		     success:function(data){
			    		      $.messager.progress('close');   
				    		    if(data==="1"){ 
			                      $.messager.alert('成功','添加一级设备成功','info');
				    		    } else{
				    		      $.messager.alert('错误',data,'error');
				    		    }
				    		    $('#dev_form').dialog("close").form('reset'); 
				    		    $('#dev_table').treegrid('load'); 	
					          }   
						     });
			          }
			         }
			      }]  
    });
    
    function formToJson(form) {  
	    var result = {};  
	    var fieldArray = $(form).serializeArray();  
	    for (var i = 0; i < fieldArray.length; i++) {  
	        var field = fieldArray[i];  
	        if (field.name in result) {  
	            result[field.name] += ',' + field.value;  
	        } else {  
	            result[field.name]=field.value;  
	        }  
	    }  
	    return JSON.stringify(result);  
    } 

    $('#add').click(function(){
		$('#dev_form').dialog("open");
    });
    
    function loadRoot(e,arr){
        var output={}; //构造传输当前对象
        $('#dev_table').treegrid('endEdit',e);
        var current_node=$('#dev_table').treegrid('find',e); 
        output.dev_root_id=e.slice(4);
        output.dev_home=current_node.dev_home;
        output.dev_name=current_node.name;
        arr.push(output);
    }

    function loadSub(e,arr){
        var output={}; //构造传输当前对象
        $('#dev_table').treegrid('endEdit',e);
        var current_node=$('#dev_table').treegrid('find',e); 
        output.dev_sub_id=e.slice(3);
        output.dev_name=current_node.name;
        arr.push(output);
    }

    function loadLeaf(e,arr){
        var output={}; //构造传输当前对象
        $('#dev_table').treegrid('endEdit',e);
        var current_node=$('#dev_table').treegrid('find',e); 
        output.dev_leaf_id=e.slice(4);      
        output.dev_name=current_node.name;
        output.dev_sncode=current_node.dev_sncode;
        output.hardware_version=current_node.hardware_version;
        output.software_version=current_node.software_version;
        output.platform_version=current_node.platform_version;
        output.config_version=current_node.config_version;
        output.dev_status=current_node.dev_status;
        arr.push(output);
    }

    function loadRootParents(e,arr){
        var output={}; //构造传输当前对象
        var current_node=$('#dev_table').treegrid('find',e); 
        output.dev_root_id=current_node._parentId.slice(4);
        arr.push(output);
    }

    function loadSubParents(e,arr){
        var output={}; //构造传输当前对象
        var current_node=$('#dev_table').treegrid('find',e); 
        output.dev_sub_id=current_node._parentId.slice(3);
        arr.push(output);
    }
    $('#save').click(function(){
          //分成不同类型进行传递
	    var tb_root_update=[];
	    var tb_sub_update=[];
	    var tb_leaf_update=[];

	    var tb_sub_insert=[];
	    var tb_root_leaf_insert=[];
        var tb_sub_leaf_insert=[];
	    var tb_root_sub=[];
	    var tb_root_leaf=[];
	    var tb_sub_leaf=[];

	    var tb_root_remove=[];
	    var tb_sub_remove=[];
	    var tb_leaf_remove=[];
		 //更新节点id
		 // console.log(edit_root);
		 // console.log(edit_sub);
		 // console.log(edit_leaf);
		 //新增节点id
	     // console.log(add_sub);
	     // console.log(add_root_leaf);
	     // console.log(add_sub_leaf);  	 
		 //删除节点id
		 // console.log(remove_root);
		 // console.log(remove_sub);
		 // console.log(remove_leaf);
    	 if(edit_root.length!=0){
            $.each(edit_root,function(index,element){
               loadRoot(element,tb_root_update);
    	    });
    	    edit_root=[];
    	 }
    	 if(edit_sub.length!=0){
    	 	 $.each(edit_sub,function(index,element){
               loadSub(element,tb_sub_update);
    	    });
    	 	edit_sub=[];
    	 }
    	 if(edit_leaf.length!=0){
    	 	 $.each(edit_leaf,function(index,element){
               loadLeaf(element,tb_leaf_update);
    	    });
    	 	edit_leaf=[]; 
    	 }
         // console.log(tb_root_update);
         // console.log(tb_sub_update);
         // console.log(tb_leaf_update);       
        if(add_sub.length!=0){
            $.each(add_sub,function(index,element){
               loadSub(element,tb_sub_insert);
               loadRootParents(element,tb_root_sub);
    	    });
    	    add_sub=[];
        }
        if(add_root_leaf.length!=0){
            $.each(add_root_leaf,function(index,element){
               loadLeaf(element,tb_root_leaf_insert);
               loadRootParents(element,tb_root_leaf);
    	    });
    	    add_root_leaf=[];
        }
        if(add_sub_leaf.length!=0){
            $.each(add_sub_leaf,function(index,element){
               loadLeaf(element,tb_sub_leaf_insert);
               loadSubParents(element,tb_sub_leaf);
    	    });
    	    add_sub_leaf=[];
        }
        // console.log(tb_sub_insert);
	    // console.log(tb_leaf_insert);
	    // console.log(tb_root_sub);
	    // console.log(tb_root_leaf);
	    // console.log(tb_sub_leaf);
         if(remove_root.length!=0){
            $.each(remove_root,function(index,element){
               loadRoot(element,tb_root_remove);
    	    });
    	 }
    	 if(remove_sub.length!=0){
    	 	 $.each(remove_sub,function(index,element){
               loadSub(element,tb_sub_remove);
    	    });
    	 }
    	 if(remove_leaf.length!=0){
    	 	 $.each(remove_leaf,function(index,element){
               loadLeaf(element,tb_leaf_remove);
    	    });
    	 } 
        // console.log(tb_root_remove);
	    // console.log(tb_sub_remove);
	    // console.log(tb_leaf_remove);    
        
        var submit_data='tb_root_update='+JSON.stringify(tb_root_update)+'&tb_sub_update='+JSON.stringify(tb_sub_update)+
                   '&tb_leaf_update='+JSON.stringify(tb_leaf_update)+'&tb_sub_insert='+JSON.stringify(tb_sub_insert)+
                   '&tb_root_leaf_insert='+JSON.stringify(tb_root_leaf_insert)+'&tb_sub_leaf_insert='+JSON.stringify(tb_sub_leaf_insert)+
                   '&tb_root_sub='+JSON.stringify(tb_root_sub)+'&tb_root_leaf='+JSON.stringify(tb_root_leaf)+
                   '&tb_sub_leaf='+JSON.stringify(tb_sub_leaf)+'&tb_root_remove='+JSON.stringify(tb_root_remove)+
                   '&tb_sub_remove='+JSON.stringify(tb_sub_remove)+'&tb_leaf_remove='+JSON.stringify(tb_leaf_remove);
    	 $.ajax({
    		      type:'POST',     
    	          data:submit_data,
    		      url:'optionServlet?action=saveAdminTree',
    		      success:function(data){
	    		     if(data===""){
	    		       $.messager.alert('成功','操作成功','info');
	    		     }
	    		     else{
                       $.messager.alert('错误','操作失败'+data,'error',function(){
                       	   $('#dev_table').treegrid('reload');
                       }); 
	    		     }   
	    		  }   
	           });	
        

    });


});