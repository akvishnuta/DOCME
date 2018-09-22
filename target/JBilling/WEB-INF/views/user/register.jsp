<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link href="<c:url value="/resources/css/common/bootstrap/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/user/register/register.css" />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="https://code.jquery.com/jquery-3.3.1.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/user/register/register.js" />"></script>
</head>
<body>
	<div class="container">
		<br><br>
		<div class="row">
			<div class="heading col-sm-12 col-lg-4">
				<h1>Register</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12 col-lg-12">
				<hr style="border-color: #fff;">
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12 col-lg-4 offset-lg-4">
				
				<div class="card">
					<div class="card-body">
						<form:form action="register" method="POST" modelAttribute="user">
							<div id="login-div" class="row">
								<div class="col-sm-12 form-group">
									<span id="login-error"></span>
								</div>
								<div class="col-sm-12 form-group">
								    <label  for="name">Name</label>
								    <form:input path="name" type="text" enabled="false" class="form-control" id="name" placeholder="Name"/>
									<form:errors path="name" cssClass="login-error"></form:errors>
								</div>
								<div class="col-sm-12 form-group">
								    <label  for="username">UserName</label>
								    <form:input path="username" type="text" enabled="false" class="form-control" id="username" placeholder="UserName"/>
								</div>
								<div class="col-sm-12 form-group">
								    <label  for="password">Password</label>
								    <form:input path="password" type="password" enabled="false" class="form-control" id="password" placeholder="Password"/>
									<form:errors path="password" cssClass="login-error"/>
								</div>
								<div class="col-sm-12 form-group">
								    <label  for="retype-password">Re-Type Password</label>
								    <form:input path="reTypePassword" type="password" enabled="false" class="form-control" id="retype-password" placeholder="Password"/>
									<form:errors path="" cssClass="login-error"/>
								</div>
								<div class="col-sm-12 form-group">
								    <label  for="phone">Phone</label>
								    <form:input path="phone" type="text" enabled="false" class="form-control" id="phone" placeholder="Phone"/>
								</div>
								<div class="col-sm-12 form-group">
								    <label  for="mail">E-Mail</label>
								    <form:input path="email" type="text" enabled="false" class="form-control" id="mail" placeholder="E-Mail"/>
								</div>
								<div class="col-sm-12 form-group">
								    <label  for="area">Area</label>
								    <select class="form-control" id="area"></select>
								</div>
								<div class="col-sm-12 form-group text-right">
								    <button id="sign-in-btn" class="btn btn-success">Sign In</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>