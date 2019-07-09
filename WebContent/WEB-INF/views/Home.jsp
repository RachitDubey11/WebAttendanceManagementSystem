<%@ include file="/WEB-INF/views/includes.jsp"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
body {
	 background-image: url("<c:url value="/resource/images/rggh.jpg"/>" );
	  -webkit-background-size: cover;
  -moz-background-size: cover;
 background-repeat: no-repeat;
  background-position: 100% center;
  -o-background-size: cover;
 }	
 .navbar {
      margin-bottom: 0;
      border-radius: 0;
     font-size:13px;
     height: 40px;
    }
  .carousel-inner img {
    width: 100%;
    height: 625px;
  }
   .row.content {height: 350px}
   
/* mouse over link */
a:hover {
  color: Turquoise ;
}

/* selected link */
a:active {
  color: blue;
}
   
   
   
</style>
</head>
<body style="height:450px">
<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
<div class="navbar-header">
  <spring:url value="/" var="admin"/>
   <a href="${admin}"><img class="nav navbar-active" src="<c:url value="/resource/images/uuy.png"/>" width="43px" height="43px" alt="logo-image"></a>    
 </div>
  <ul class="nav nav-pills" role="tablist">
    <li class="nav-item">
      <a class="nav-link active" href="#"><strong>HOME</strong></a>
    </li>
    <li class="nav-item">
        <spring:url value="/about" var="teachers"/>
      <a class="nav-link" href="${teachers}"><strong>ABOUT</strong></a>
    </li>
     <li class="nav-item">
         <spring:url value="/contact" var="teachers"/>
      <a class="nav-link" href="${teachers}"><strong>CONTACT</strong></a>
    </li>
    <li class="nav-item">
        <spring:url value="/help" var="teachers"/>
      <a class="nav-link" href="${teachers}"><strong>HELP</strong></a>
    </li>
    </ul>
    <ul></ul><ul></ul><ul></ul><ul></ul><ul></ul><ul></ul><ul></ul><ul></ul><ul></ul><ul></ul><ul></ul>
    <ul></ul><ul></ul><ul></ul><u></u><u></u><ul></ul><ul></ul><ul></ul><ul></ul><u></u><u></u><ul></ul><ul></ul><ul></ul><ul></ul><u></u>
    <ul class="nav navbar-right">
    <li class="nav-item">
     <a class="btn btn-outline-success" href="<c:url value="/login" />"><strong>LOGIN</strong></a>
    </li>   
   </ul>
</nav>
<div id="demo" class="carousel slide" data-ride="carousel">
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>
  <div class="carousel-inner">
  <div class="carousel-item active">
       <img src="<c:url value="/resource/images/iui.jpg"/>" width="8000" height="300">
      <div class="carousel-caption">
       <h1><strong><font color="Blue"><u>Attendance Management Portal</u></font></strong></h1>
       <h3><strong><font color="darkBlue"><u>Department of Computer Science and Information Technology</u></font></strong></h3>
      <h4><strong><font color="black">Uma Nath Singh Institute Of Engineering and Technology</font></strong></h4>
      
       <p><a href="http://www.vbspu.ac.in/"><img src="<c:url value="/resource/images/vbspu.png"/>" style="width:70px; height:70px;"><strong><font size="3px">(Veer Bahadur Singh Purvanchal University)</font></strong> <img src="<c:url value="/resource/images/vbspu.png"/>" style="width:70px; height:70px;"></a></p>
     </div>   
    </div>
    <div class="carousel-item">
     <img src="<c:url value="/resource/images/uyu.jpg"/>" width="800" height="300">
      <div class="carousel-caption">
     <h1><strong><font color="black">Attendance Management Portal</font></strong></h1>
      <p><a href="http://www.vbspu.ac.in/"><img src="<c:url value="/resource/images/vbspu.png"/>" style="width:90px; height:90px;"><strong><font size="5px">(Veer Bahadur Singh Purvanchal University)</font></strong><img src="<c:url value="/resource/images/vbspu.png"/>" style="width:90px; height:90px;"></a></p>
        </div>   
    </div>
    <div class="carousel-item">
         <img src="<c:url value="/resource/images/frontpage.jpg"/>" width="800" height="300">
    
      <div class="carousel-caption">
         <h1><font color="black"><strong>Attendance Management Portal</strong></font></h1>
       <p><a href="http://www.vbspu.ac.in/"><img src="<c:url value="/resource/images/vbspu.png"/>" style="width:90px; height:90px;"><strong><font size="5px">(Veer Bahadur Singh Purvanchal University)</font></strong>      <img src="<c:url value="/resource/images/vbspu.png"/>" style="width:90px; height:90px;"></a></p>
      </div>   
    </div>  
    </div>
  </div>
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
</div>
<%-- 
  <footer>
<div class="fixed-bottom">
      <ul class="nav flex-row">
        <li class="nav-item"><a class="nav-link" href="#">About</a></li>
        <li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
        <li class="nav-item"><a class="nav-link" href="#">Help</a></li>
        <li class="nav-item"><a class="nav-link" href="#">Follow us</a></li>
      </ul>
    </div>
</footer>
--%>
</body>
</html>


      