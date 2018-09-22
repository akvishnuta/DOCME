<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link href="<c:url value="/resources/css/common/bootstrap/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/user/userList.css" />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="https://code.jquery.com/jquery-3.3.1.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/user/login/login.js" />"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-4">
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Code</th>
							<th>Name</th>
							<th>UserName</th>
							<th>Passsword</th>
							<th>Salt</th>
							<th>Phone</th>
							<th>Email</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="user" items="${userList}">
						<tr>
							<td><c:out value="${user.code}"/></td>
							<td><c:out value="${user.name}"/></td>
							<td><c:out value="${user.username}"/></td>
							<td><c:out value="${user.password}"/></td>
							<td><c:out value="${user.salt}"/></td>
							<td><c:out value="${user.phone}"/></td>
							<td><c:out value="${user.email}"/></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>