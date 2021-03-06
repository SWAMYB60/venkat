<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Categories</title>
</head>
<body>
	<c:url = "action" value="/category/add"></c:url>
	<form:form action="${action}" method="post" commandname="category">

		<table>
			<tr>
				<td><form:label path="id">
						<spring:message text="ID"></spring:message>
					</form:label></td>
				<c:choose>
					<c:when test="${! empty category.id}">
						<td><form:input path="id" disabled="true" readonly="true" /></td>
					</c:when>
					<c:otherwise>
						<td><form:input path="id" pattern=".{4,15}" required="true"
								title="id should contain a minimum of 4 characters" /></td>
					</c:otherwise>
				</c:choose>
			<tr>
				<td><form:label path="name">
						<spring:message text="Name"></spring:message>
					</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="description">
						<spring:message text="Description"></spring:message>
					</form:label></td>
				<td><form:input path="description" /></td>
			</tr>
			<td colspan="2"><c:if test="${!empty category.name}">
					<input type="submit" value="<spring:message text="Edit Category"/>" />
				</c:if> <c:if test="${empty category.name }">
					<input type="submit" value="<spring:message text="Add Category"/>" />
				</c:if>
				<h3>Category List</h3>
				 <c:if test="${!empty categoryList}">
					<table class="tg">
						<tr>
							<th width="80">Category ID</th>
							<th width="120">Category Name</th>
							<th width="120">Category Description</th>
							<th width="60">Edit</th>
							<th width="60">Delete</th>
						</tr>
						<c:forEach items="${categoryList}" var="category">
							<tr>
								<td>${category.id}</td>
								<td>${category.name}</td>
								<td>${category.description}</td>
								<td><a href="<c:url value='category/edit/${category.id}'/>">Edit</a></td>
								<td><a
									href="<c:url value='category/remove/${category.id}'/>">Delete</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:if> </form:form>
		</table>
</body>
</html>