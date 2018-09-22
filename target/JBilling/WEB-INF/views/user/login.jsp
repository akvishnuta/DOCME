<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link href="<c:url value="/resources/css/common/bootstrap/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/user/login/login.css" />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="https://code.jquery.com/jquery-3.3.1.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/login/login.js" />"></script>
</head>
<body>
	<div class="container">
		<br><br>
		<div class="row">
			<div class="heading col-sm-12 col-lg-4">
				<h1>Login</h1>
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
						<form>
							<div id="login-div" class="row">
								<div class="col-sm-12 form-group">
									<span id="login-error"></span>
								</div>
								<div class="col-sm-12 form-group">
								    <label  for="item">UserName</label>
								    <input type="text" enabled="false" class="form-control" id="username" placeholder="UserName">
								</div>
								<div class="col-sm-12 form-group">
								    <label  for="item">Password</label>
								    <input type="password" enabled="false" class="form-control" id="password" placeholder="Password">
								</div>
								<div class="col-sm-12 form-group">
								    <label  for="area">Area</label>
								    <select class="form-control" id="area">
								    	
								    </select>
								</div>
								<div class="col-sm-12 form-group text-right">
								    <button id="sign-in-btn" class="btn btn-success">Sign In</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>