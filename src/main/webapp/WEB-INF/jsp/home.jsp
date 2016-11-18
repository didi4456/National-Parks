<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section>  

	<h1 id="pageTitle">America's Beautiful Parks</h1>

	
	<c:forEach var="nationalPark" items="${nationalParkList}">
		<div id="parkName">
			<c:out value="${nationalPark.name}"/>
		</div>
		<div id="image">
	
		<c:url value="/parkDetail?parkCode=${nationalPark.parkCode}" var="detailPageHref"/>
		<a href="${detailPageHref}">
			<img src = "img/parks/${fn:toLowerCase(nationalPark.image)}.jpg" />
		</a>
		</div>
		
		<div id="summary">
		<p id="largerFont"><b>Location: <c:out value="${nationalPark.location}"/></b> </p>
		
			<p><c:out value="${nationalPark.summary}"/></p>
		</div>
	
	</c:forEach>
		<div>
		<p> <c:url var="survey" value="/survey"/>
		<a href="${survey}">Participate in our Daily Survey!</a>
		</p>
		</div>
	
</section>
</body>
</html>