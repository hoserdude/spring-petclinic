<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">

<jsp:include page="fragments/headTag.jsp" />
<body>
	<jsp:include page="fragments/bodyHeader.jsp" />
	<div class="container">
		<form class="form-horizontal" action="<%=request.getContextPath()%>/j_spring_security_check"
			method="POST">
			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">User
					Name:</label>
				<div class="col-lg-10">
					<input class="form-control" id="username" name="j_username"
						type="text" />
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-lg-2 control-label">Password</label>
				<div class="col-lg-10">
					<input type="password" class="form-control" name="j_password"
						id="password" placeholder="Password">
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<button type="submit" class="btn btn-default">Sign in</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>