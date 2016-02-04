<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel='stylesheet prefetch'
	href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>
<link rel="stylesheet" href='<c:url value="/resources/css/style.css"/>'>
<body>
	<div class="login-card">
		<h1>Log-in</h1>
		<br>
		<form:form id="userForm" method="post" commandName="user"
			action="login.do">
			<div>
				<form:input name="username" path="username"  placeholder="Username"/>
			</div>
			<div>
				<form:input name="password" path="password" placeholder="Password"/>
			</div>
			<div class="login-help">
				<input type="submit" class="login login-submit" value="Login" />
			</div>
		</form:form>
</body>