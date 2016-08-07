<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <center>
  <h1> Welcome</h1>
  </center>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 60%;
      margin: auto;
  }
  </style>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header"></div>
		<ul class="nav navbar-nav">
			<li><a href="index">Home</a></li>
			<li><a href="ret">View All</a></li>
			<li><a href="cont">Contact us</a></li>
		</ul>
	</div>
	</nav>
	<div class="container" ng-app="imgApp" ng-controller="imgCtrl">
		<c:url var="addfurniture" value="addfurniture"></c:url>
		<form:form commandName="Product" method="post" action="storefurniture">
			<table class="table table-bordered">
				<tr>
					<td><form:label path="id">Furniture Id :</form:label></td>
					<td><form:input path="id" /> <font color="red"><form:errors
								path="id"></form:errors></font></td>
				</tr>
				<tr>
					<td><form:label path="name">Furniture Name :</form:label></td>
					<td><form:input path="name" /> <font color="red"><form:errors
								path="name"></form:errors></font></td>
				 
				<tr>
					<td><form:label path="description">Furniture Description :</form:label></td>
					<td><form:input path="description" /> <font color="red"><form:errors
								path="description"></form:errors></font></td>
				</tr>


				<td><input type="submit" value="submit" class="btn" /></td>
				</tr>

			</table>
		</form:form>
</body>
</html>