<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html lang="en">

<jsp:include page="fragments/headTag.jsp"/>

<body>
    <jsp:include page="fragments/bodyHeader.jsp"/>
	<div class="container">
      <div class="jumbotron">
        <h1>Welcome To The Pet Clinic</h1>
        <p>
          <a class="btn btn-lg btn-primary" href="<spring:url value="/vets.html" htmlEscape="true" />">See Our Vets &raquo;</a>
        </p>
      </div>
    <spring:url value="/resources/images/pets.png" htmlEscape="true" var="petsImage"/>
    <img src="${petsImage}"/>

    <jsp:include page="fragments/footer.jsp"/>

</div>
</body>

</html>
