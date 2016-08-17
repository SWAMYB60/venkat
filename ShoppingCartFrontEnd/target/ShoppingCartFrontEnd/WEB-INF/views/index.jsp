<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html lang="en">
<head>
  <title>shoppingcart.com</title>
  <center>
  
  <h1>SHOPPING CART</h1>
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
    <div class="navbar-header">
      
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="hi">Home</a></li>
      <li><a href="#">View All</a></li>
      <li><a href="addfurniture">Addfurniture</a></li>
      <li><a href="register">Register</a></li>
       <li><a href="#">Contact us</a></li>
      <li><a href="login">Login</a></li>
      <li><a href="display">display</a></li>
      
     </ul>
  </div>
</nav>
  

<div class="container">
  
    <div class="center-block">  
    
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
       <li data-target="#myCarousel" data-slide-to="4"></li>
    </ol>
    
   <!-- Wrapper for slides -->
    
    
    <div class="carousel-inner" role="listbox">
    
    
    
    
      <div class="item active">
         <img src="<c:url value="/resources/images/furniture1.jpg"/>" alt="Chania" width="600" height="500">
      </div>

      <div class="item">
        <img src="<c:url value="/resources/images/furniture2.jpg"/>" alt="Chania" width="600" height="500">
      </div>
    
      <div class="item">
        <img src="<c:url value="/resources/images/furniture3.jpg"/>" alt="Chania" width="600" height="500"> 
      </div>
      
      
       <div class="item">
         <img src="<c:url value="/resources/images/furniture4.jpg"/>" alt="Chania" width="600" height="500">
      </div>
      
          <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div></div></div>
 

<div class="container">
            
  <div class="row">
    <div class="col-sm-4">
      
          
         <img src="<c:url value="/resources/images/furniture5.jpg"/>" alt="Pulpit Rock" style="width:300px;height:150px">
         <a href="search?pro=chair" > </a>
    </div>
    <div class="col-sm-4">
           
         <img src="<c:url value="/resources/images/furniture6.jpg"/>" alt="Moustiers Sainte Marie" style="width:300px;height:150px">
          <a href="search?pro=chair" > </a>
    </div>
    <div class="col-sm-4">
      <a href="enter pro?data=table">
           <img src="<c:url value="/resources/images/furniture7.jpg"/>" alt="Cinque Terre" style="width:300px;height:150px">
            <a href="search?pro=chair" ></a>
      </a>
    </div>
  </div>
</div>
</body>
</html>

</body>
</html>
<%@include file="/WEB-INF/views/footer.jsp" %>
 
</body>
</html>