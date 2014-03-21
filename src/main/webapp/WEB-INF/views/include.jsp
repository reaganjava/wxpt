<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="<%=request.getContextPath()%>/resources/css/default.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/js/themes/icon.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.easyui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/outlook2.js"> </script>
<script type="text/javascript">
var _menus = {"menus":[
					{"menuid":"1","icon":"icon-sys","menuname":"系统管理",
						"menus":[{"menuname":"菜单管理","icon":"icon-nav","url":"http://www.16sucai.com"},
								{"menuname":"添加用户","icon":"icon-add","url":"demo.html"},
								{"menuname":"用户管理","icon":"icon-users","url":"demo2.html"},
								{"menuname":"角色管理","icon":"icon-role","url":"demo2.html"},
								{"menuname":"权限设置","icon":"icon-set","url":"demo.html"},
								{"menuname":"系统日志","icon":"icon-log","url":"demo.html"}
							]
					},{"menuid":"8","icon":"icon-sys","menuname":"员工管理",
						"menus":[{"menuname":"员工列表","icon":"icon-nav","url":"demo.html"},
								{"menuname":"视频监控","icon":"icon-nav","url":"demo1.html"}
							]
					},{"menuid":"56","icon":"icon-sys","menuname":"部门管理",
						"menus":[{"menuname":"添加部门","icon":"icon-nav","url":"demo1.html"},
								{"menuname":"部门列表","icon":"icon-nav","url":"demo2.html"}
							]
					},{"menuid":"28","icon":"icon-sys","menuname":"财务管理",
						"menus":[{"menuname":"收支分类","icon":"icon-nav","url":"demo.html"},
								{"menuname":"报表统计","icon":"icon-nav","url":"demo1.html"},
								{"menuname":"添加支出","icon":"icon-nav","url":"demo.html"}
							]
					},{"menuid":"39","icon":"icon-sys","menuname":"商城管理",
						"menus":[{"menuname":"商品分","icon":"icon-nav","url":"/shop/productcatagory.aspx"},
								{"menuname":"商品列表","icon":"icon-nav","url":"/shop/product.aspx"},
								{"menuname":"商品订单","icon":"icon-nav","url":"/shop/orders.aspx"}
							]
					}
			]};
			
   function login() {
	   var $username = $('#username');
       var $password = $('#password');
       if($username.val() == '') {
    	   msgShow('系统提示', '请输入用户名！', 'warning');
    	   return false;
       }
       if($password.val() == '') {
    	   msgShow('系统提示', '请输入密码！', 'warning');
    	   return false;
       }
       $.post('/ajax/editpassword.ashx?newpass=' + $newpass.val(), function(msg) {
           msgShow('系统提示', '恭喜，密码修改成功！<br>您的新密码为：' + msg, 'info');
           $newpass.val('');
           $rePass.val('');
           close();
       })
   }
   
   
   function cleanLogin() {
	   var $username = $('#username');
       var $password = $('#password');
       $username.val('');
       $password.val('');
   }
  

   //修改密码
   function serverLogin() {
       var $newpass = $('#txtNewPass');
       var $rePass = $('#txtRePass');

       if ($newpass.val() == '') {
           msgShow('系统提示', '请输入密码！', 'warning');
           return false;
       }
       if ($rePass.val() == '') {
           msgShow('系统提示', '请在一次输入密码！', 'warning');
           return false;
       }

       if ($newpass.val() != $rePass.val()) {
           msgShow('系统提示', '两次密码不一至！请重新输入', 'warning');
           return false;
       }

       $.post('/ajax/editpassword.ashx?newpass=' + $newpass.val(), function(msg) {
           msgShow('系统提示', '恭喜，密码修改成功！<br>您的新密码为：' + msg, 'info');
           $newpass.val('');
           $rePass.val('');
           close();
       })
       
   }

   $(function() {

       openPwd();
       //
       $('#editpass').click(function() {
           $('#w').window('open');
       });

       $('#btnEp').click(function() {
           serverLogin();
       })

      

       $('#loginOut').click(function() {
           $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {

               if (r) {
                   location.href = '/ajax/loginout.ashx';
               }
           });

       })
		
		
		
   });
</script>
<html>
<head id="Head1">
    <title>管理后台</title>
</head>
