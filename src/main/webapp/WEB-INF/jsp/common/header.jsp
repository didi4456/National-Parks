<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>National Park Geek</title>
    <c:url value="/css/npgeek.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>
<body>
	<header id="header">
			<c:url value="/home" var="homePageHref"/>
			<c:url value="/img/logo.png" var="logoSrc"/>
			<a href="${homePageHref}">
				<img id="logo" src="${logoSrc}" alt="National Park Logo"/>
			</a>
	</header>
