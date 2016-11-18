<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section id="forecast">

	<h1 id="fiveDay">Your 5 Day Forecast For <c:out value="${dailyForecast.name}"/></h1>

		<c:url value="/weatherForecast" var="formAction" />
		<form method="POST" action="${formAction}">
		<div>
			 <select name="tempPref">
			 	<option value="">Select a Temperature Preference</option>
				<option value="farenheit">Farenheit</option>
				<option value="celsius">Celsius</option>
			</select>
		</div>
			<input type="hidden" name="parkCode" value="${park.parkCode}"/>
			<input type= "submit" value = "Submit" />
		</form>
<%-- 		<c:choose> --%>
<%-- 			<c:when test="${preference.tempPref == celsius}"> --%>
<%-- 				<c:set var="tempLowChoice" value="${(dailyForecast.lowTemp - 32) * (5 / 9)}"/> --%>
<%-- 			</c:when> --%>
<%-- 		</c:choose> --%>
	<div id="align"> 
	<c:forEach var="dailyForecast" items="${forecast}">
		<div id="cast">
			<p>Day: <c:out value="${dailyForecast.fiveDayForecast}"/></p>
			<img src="img/weather/${dailyForecast.forecast}.png"/>	
			
			<p><span>High Temp: </span><c:out value="${dailyForecast.highTemp}"/></p>
			<p><span>Low Temp: </span><c:out value="${dailyForecast.lowTemp}"/></p>
			<p><span>Daily Forecast: </span><c:out value="${dailyForecast.forecast}"/></p>
		
			<span>Forecast Recommendation: </span>
				<c:out value="${dailyForecast.forecastRecommendation}"/>
				<c:out value="${dailyForecast.tempRecommendation}"/>
				<c:out value="${dailyForecast.tempDiffRecommendation}"/>
			</div>									  
	</c:forEach>
		</div>
</section>

	