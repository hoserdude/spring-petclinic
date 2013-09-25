<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="container">
	<nav class="navbar navbar-static-top">
		<div class="navbar-inner">
			<a class="brand">Pet Clinic</a>
	        <ul class="nav">
	            <li class="active"><a href="<spring:url value="/" htmlEscape="true" />"><i class="icon-home"></i>
	                Home</a></li>
	            <li><a href="<spring:url value="/owners/find.html" htmlEscape="true"/>" data-toggle="tab"><i
	                    class="icon-search"></i> Find owners</a></li>
	            <li><a href="<spring:url value="/vets.html" htmlEscape="true" />" data-toggle="tab"><i
	                    class="icon-th-list"></i> Veterinarians</a></li>
	            <li><a href="<spring:url value="/oups.html" htmlEscape="true"/>" data-toggle="tab"
	                                        title="trigger a RuntimeException to see how it is handled"><i
	                    class="icon-warning-sign"></i> Error</a></li>
	
	        	<li class="divider-vertical"></li>
	          <sec:authorize access="isAuthenticated()">
	          	<li><p class="navbar-text">Hello <sec:authentication property="principal.username" /></p></li>
	            <li><a href="<spring:url value="/j_spring_security_logout" htmlEscape="true" />">Logout</a></li>
	          </sec:authorize>
	
	          <sec:authorize access="isAnonymous()">    
	          	<li><p class="navbar-text">Hello Guest</p></li>
	            <li><a href="<spring:url value="/login" htmlEscape="true" />">Login</a></li>
	          </sec:authorize>
	        </ul>
	    </div>
	</nav>
</div>