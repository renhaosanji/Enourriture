<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
   <head>
      <title>����</title>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
   </head>
   <body>
      <div class="container" id="wrap">
         <div class="row">
            <div class="col-md-6 col-md-offset-3">
               <form name="signUpForm" class="form" role="form">
                  <legend>ȸ������</legend>   
               
                  <input type="text" name="name" class="form-control input-lg" ng-model="userName" placeholder="�̸�" ng-required="true"/>
                  <br>
                  <input type="text" name="ID" class="form-control input-lg" ng-model="userId" placeholder="���̵�" ng-required="true"/>
                  <br>
                  <input type="password" name="password" class="form-control input-lg" placeholder="�н�����" ng-model="userPassword" ng-required="true" ng-pattern="/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$/" />
                  <div ng-show="signUpForm.password.$error.pattern" class="alert alert-warning" role="alert">�ּ� 4����, �ִ� 8�����̰� ��� 1���� �ҹ���, �빮��, ���ڸ� �����ؾ��մϴ�.</div>
                  <input type="password" name="password_chk" class="form-control input-lg" placeholder="�н����� ���Է�" ng-model="userRepassword" ng-required="true"/>
                  <br>
                  <input type="text" name="mail" class="form-control input-lg" placeholder="Email" ng-model="userEmail" ng-required="true" />
                  <br>
                  <input type="text" name="phone" class="form-control input-lg" placeholder="Phone" ng-model="userEmail" ng-required="true" />
                  <br>
                  <button class="btn btn-lg btn-primary btn-block signup-btn" type="submit">ȸ������</button>
               </form>
               <div>

               </div>
            </div>
         </div>
      </div>         
   </body>
</body>
</html>