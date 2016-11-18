<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section>  

	<h1 id="pageTitle"><c:out value="${park.name}"/> Information</h1>
	
		<div> 
			<img id="imageDetail" src = "img/parks/${fn:toLowerCase(park.image)}.jpg" />
		</div>
	<div id="parkDetailContainer">	
	<div id="container1">
		<div >
			<span id="largerFont">Location: </span><c:out value="${park.location}"/>
		</div>
		
		<div >
			<span id="largerFont">Acreage:</span> <c:out value="${park.acreage}"/>
		</div>
		
		<div >
			<span id="largerFont">Elevation:</span> <c:out value="${park.elevationInFeet}"/> feet
		</div>
		
		<div >
			<span id="largerFont">Miles of Trail:</span> <c:out value="${park.milesOfTrail}"/>
		</div>
		<div >
			<span id="largerFont">Climate:</span> <c:out value="${park.climate}"/>
		</div>
			</div>
	<div id="container2">
		
		<div >
			<span id="largerFont">Num. of Campsites:</span> <c:out value="${park.numberOfCampsites}"/>
		</div>
		
		<div >
			<span id="largerFont">Year Founded:</span><c:out value="${park.yearFounded}"/>
		</div>
		
		<div >
			<span id="largerFont">Annual Visitors:</span> <c:out value="${park.annualVisitors}"/>
		</div>
		
		<div >
			<span id="largerFont">Entry Fee:</span> $<c:out value="${park.entryFee}"/>
		</div>
		
		<div >
			<span id="largerFont">Number of Animal Species: </span><c:out value="${park.numberOfAnimalSpecies}"/>
			<p>
		</div>
	</div>
</div>
		<div >
		
			<span id="detailSummary"> <c:out value="${park.summary}"/></span>
		</div>
			
		<div>
			<p id="largerFont">"<c:out value="${park.inspirationalQuote}"/>"</p>
			<p>
			<p>-<c:out value="${park.quoteSource}"/></p>
		</div>
		
		<div id="weatherLink">
		 <c:url var="weather" value="/weatherForecast?parkCode=${park.parkCode}"/>
		<a href="${weather}">Click here to view your 5 day weather forecast!</a> 
		</div>
</section>
</body>
</html>