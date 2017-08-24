$(function(){
  $('#tabs').tabs({
	     fit:true,
	     border:false,
	     tabWidth:80,
	     tabHeight:35,
	   });
  $('.nav li').click(function(){
  	 if($('.user span').html()==='null'){	
	   var result=confirm('请您重新登陆系统!');
	   if(result===true){
		window.location.href='index.html';
	   }
	   return;		 
     }
     else{
     	var option_name=$(this).children('span').html();
     	var option_id=$(this).attr('id');
     	var width=width<1030?1030:$(document).width();
     	$('.nav li').removeClass('selected')
        $(this).addClass('selected');
     	$('#tabs').tabs('add',{
	    	   title:option_name,
	    	   tabWidth:150, 
	    	   closable:true,
	    	   selected:true,
	    	   iconCls:'icon-search',
	    	   href:'manageServlet?action='+option_id+'&width='+width,
	    	   method:'get',
	        });
       } 	
  });
   $.extend($.fn.validatebox.defaults.rules,{    
     lengthTo:{
        validator:function(value,param){
             return value.length>=param[0] &&value.length<=param[1];
        },
        message:'密码应该为5到10位'
     },
     equalTo:{
        validator:function(value,param){
          if ($("#"+param[0]).val()!=""&&value!=""){  
                return $("#" + param[0]).val() ===value;  
              }else{  
             return true;  
           } 
        },
        message:'两次输入的密码不一致'
     },    
   }); 
   $('#update_form').dialog({
        	    width:400,
        	    height:200,
				draggable: false,
				modal : true,
				closed : true,
				title:'修改密码',
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
function exitSystem(){
	var result=confirm('您确定注销用户并退出系统吗？');
	if(result===true)
	{
	  window.location.href='exitServlet';
	}	
}
function updatePassword(){
  $('#update_form').dialog('open');
}
function manageDev(){
    var width=width<1030?1030:$(document).width();
	$('#tabs').tabs('add',{
	    	 title:"设备管理",
	    	 tabWidth:100, 
	    	 closable:true,
	    	 selected:true,
	    	 iconCls:'icon-world',
	    	 href:'widthServlet?action=admin_dev&width='+width,
	    	 method:'get',
	       }); 	
}
function manageUser(){
	var width=width<1030?1030:$(document).width();
	$('#tabs').tabs('add',{
	    	 title:"用户管理",
	    	 tabWidth:100, 
	    	 closable:true,
	    	 selected:true,
	    	 iconCls:'icon-user',
	    	 href:'widthServlet?action=user&width='+width,
	    	 method:'get',
	       }); 
}