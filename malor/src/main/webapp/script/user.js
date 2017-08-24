$(function(){
		$('#user_table').datagrid({	
		        width : 700,
		        height: 500,
				title :'用户管理',
			    url:'searchServlet?action=User',
			    method:'GET',
				toolbar:'#user_toolbar',
				iconCls: 'icon-system',
				columns :[[
				{ field : 'checkbox',title:'',checkbox:true},
				{ field : 'username',title:'用户名',width:150},
				{ field : 'last_time',title:'上次登录时间',width:165},
				{ field : 'competence',title:'操作权限',width:165,editor:{type:'combobox',
		          options:{valueField:'competence',textField:'competence',panelHeight:'43',
		          data:[{competence:'实验室管理员'},{competence:'普通用户'}] }}	
		        },
		        {
                  field:'lib_com',title:'管理实验室',width:165,editor:{type:'combobox',
		          options:{valueField:'lib_com',textField:'lib_com',panelHeight:'43',
		          data:[{lib_com:'郑西实验室'},{lib_com:'广深港实验室'},
                        {lib_com:'CBTC实验室'},{lib_com:'列控实验室'},
                        {lib_com:'平台实验室'},{lib_com:'综合监控实验室'},
                        {lib_com:'DMI实验室'}] }},	
		        },                 
		        ]],
				onCheck:function(rowIndex,rowData){
				   $(this).datagrid('beginEdit',rowIndex);
			    },
			    onUncheck:function(rowIndex,rowData){
                   $(this).datagrid('cancelEdit',rowIndex);
			    }
        }); 
        $('#user_toolbar .edit').click(function(){
        	var select_obj=$('#user_table').datagrid('getSelections');
		    if(select_obj.length!=0){
		    	   $.each(select_obj,function(index,element){
                       $('#user_table').datagrid('endEdit',$('#user_table').datagrid('getRowIndex',element));  
		    	   });  
			       $.ajax({
		              type:'POST',
		              data:"data="+JSON.stringify(select_obj),
		              url:"optionServlet?action=editUser",
		              success:function(data){
		                if(data==='1'){
		                  $.messager.alert('成功','修改用户权限成功','info');
		                }else{
		                  $('#user_table').datagrid('cancelEdit');
		                  $.messager.alert('错误',data,'error');
		                }	
		              }
			       });
			}   
        });
        $('#user_toolbar .remove').click(function(){
			var select_obj=$('#user_table').datagrid('getSelections');
			if(select_obj.length!=0){	   	  
				    $.messager.confirm('确认','您确认想要删除该用户吗？',function(r){
				        if(r){ 
				               $.ajax({
				    		     type:"POST",     
				    	         data:"data="+JSON.stringify(select_obj),
				    		     url:"optionServlet?action=deleteUser",
				    		     beforeSend:function(){
					    		    $.messager.progress({
					    		       title:'删除用户',
					    		       text:'正在删除中....',
					    		    });
					    		  },
				    		     success:function(data){	
				    		      $.messager.progress('close');   
					    		    if(data==="1"){ 
					    		     $.messager.alert('成功','删除用户成功','info');
					    		     $('#user_table').datagrid({
					    		       url:'searchServlet?action=User', 
					    		       method:'GET',
					    		     });	
					    		    }
					    		    else{
					    		      $.messager.alert('错误','删除该用户失败','error');
					    		    }   		
					    		         
				               }         
				          });
				        } 
				    });
	        }     
	    }); 

	     $('#user_form').dialog({
        	    width:400,
        	    height:200,
				draggable: false,
				modal : true,
				closed : true,
				title:'修改权限',
				iconCls:'icon-edit',
				onClose:function(){
				  $(this).form('reset');
				},
				buttons:[{
						text : '确认修改',
						iconCls :'icon-edit-new',
						handler:function(){
				         var isValid=$('#update_form').form('enableValidation').form('validate');
					     if(isValid){
                            $.ajax({
			    		     type:"POST",     
			    	         data:"password="+$('#pwd').val()+"&username="+$('.user').children('span').html(),
			    		     url:"tabServlet",
			    		     beforeSend:function(){
				    		    $.messager.progress({
				    		       title:'修改密码中',
				    		       text:'正在修改中....',
				    		    });
				    		  },
			    		     success:function(data){
			    		        $.messager.progress('close');   
				    		      if(data==="1"){ 
			                        $.messager.alert('成功','修改新密码成功','info'); 
				    		      }else{
				    		        $.messager.alert('错误',"修改新密码失败",'error');
				    		      }
				    		      $('#update_form').dialog("close").form('reset'); 	
					          }   
						     });
				            }
				         }
				      }]  
	});
   
});  	        
   