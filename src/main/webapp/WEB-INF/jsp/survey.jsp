<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section id="main-content">

	<h2>New Geek Survey</h2>
	
		<c:url value="/survey" var="formAction" />
	<form method="POST" action="${formAction}">
	
	
	<div> 
		Select Your Favorite Park :<select name= "parkCode">
			<option value=""></option>
			<option value="selectFavoritePark"> Select Your Favorite Park</option>
			<option value="CVNP"> Cuyahoga Valley National Park </option>
			<option value="ENP"> Everglades National Park </option>
			<option value="GCNP"> Grand Canyon National Park </option>
			<option value="GNP"> Glacier National Park </option>
			<option value="GSMNP"> Great Smokey Mountains National Park </option>
			<option value="GTNP"> Grand Teton National Park </option>
			<option value="MRNP"> Mount Rainier National Park </option>
			<option value="RMNP"> Rocky Mountain National Park </option>
			<option value="YNP"> YellowStone National Park </option>
			<option value="YNP2"> Yosemite National Park </option>
		</select>
	</div>
	
	<div> 
	<label for= "emailAddress"> Email Address</Label>
		<input type= "text" name="emailAddress" id="emailAddress" />
	</div>
	
		<div> 
	<label for= "stateOfResidence"> State</Label>
		<input type= "text" name="stateOfResidence" id="stateOfResidence" />
	</div>
	
	<div>
	
	 Select Your Activity Level: <select name="physicalActivityLevel">
	 	<option value=""></option>
		<option value="inactive"> Inactive</option>
		<option value="sedentary"> Sedentary</option>
		<option value=" active"> Active </option>
		<option value="extremelyactive"> ExtremelyActive </option>
	</select>
	
	</div>
	<input type= "submit" value = "Submit" />
<%-- 	<input type="hidden" value="${favoritePark}" name="parkcode"/> --%>
	
	</form>
</section>
	
