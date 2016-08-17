<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
     <link rel="stylesheet" href='<x:url value="/resources/css/bootstrap.min.css"></x:url>' />
  <script src='<x:url value="/resources/js/jquery.min.js"></x:url>'></script>
  <script src='<x:url value="/resources/js/bootstrap.min.js"></x:url>'></script>
  <script src='<x:url value="/resources/js/angular.min.js"></x:url>'></script>
   
</head>
   <body>
   <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
    </div>
    <ul class="nav navbar-nav">
            <li><a href="cont">Contact us</a></li>
      <li><a href="logout">Logout</a></li>
          </ul>
  </div>
</nav>
<h1>Hello... <%=session.getAttribute("loggedInUser")%></h1>
      <div class="container">
            <table class="table table-hover table-bordered">
            <tr><td rowspan="5">
            <img src='<x:url value="/resources/images/${product.image}"/>'/></td></tr>
            <tr><td>${product.id}</td></tr>
            <tr><td>${product.name}</td></tr>
            <tr><td>${product.price}</td></tr>
            <tr><td>${product.description}</td></tr>
            
            <sec:authorize access="hasRole('ROLE_USER')">
            <tr><td></td><td><a href="viewcart?id=${product.id}" class="btn btn-primary">Add Cart</a>
              </td></tr></sec:authorize>               
            </table>
      </div>
   </body>
</html>

</body>
</html>