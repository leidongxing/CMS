$(function(){
      //初始化位置($(window).width()-692)/2}
      $('#login').css({'position':'absolute','left':($(window).width()-692)/2});
      $('#register').css({'position':'absolute','left':($(window).width()-692)/2});
      $(window).resize(function(){  
        $('#login').css({'position':'absolute','left':($(window).width()-692)/2});
        $('#register').css({'position':'absolute','left':($(window).width()-692)/2});
      });  
}); 
 //注册 登录 状态切换
      function change(){
          $('.loginbox').find('p').html('');
          $('#login').fadeToggle(500);
          $('#register').fadeToggle(500);
      }
      //输入框获取焦点 
      $('.loginbox .loginuser').focus(function(){
         $(this).next('p').html('');
      });
      $('.loginbox .loginpwd').focus(function(){
         $(this).next('p').html('');
      });
      //表单提交验证
      function form_validate(type){
          if($(type).find('.loginuser').val().length===0){
             $(type).find('.loginuser').next('p').html('用户名不能为空');
             return false;
          }
          else if($(type).find('.loginpwd').val().length===0){
             $(type).find('.loginpwd').next('p').html('密码不能为空');
             return false;
          }
          else if($(type).find('.loginpwd').val().length!=0){
            if($(type).find('.loginpwd').val().length<5||$(type).find('.loginpwd').val().length>10){
              $(type).find('.loginpwd').next('p').html('密码为5到10位');
              return false;  
            }
          }
          return true;
      }


