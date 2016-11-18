<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section >


	<div id="result">
		<c:out value="${favPark.parkName}"/><span> Is The Most Popular National Park in America Today!</span>
	</div>
	<div id="imgSurvey">
		<img id="imgSize" src="img/parks/${fn:toLowerCase(favPark.parkCode)}.jpg"/>
	</div>
</section>
</body>
</html>