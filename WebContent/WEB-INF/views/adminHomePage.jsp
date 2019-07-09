<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/WEB-INF/views/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
 
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
 
<title>Admin Login page</title>
 <link rel="icon" type="image/x-icon" href="<c:url value="/resource/images/img70.png"/>" />
 <style type="text/css">
.error {
	color: red;
}

body {
	 background-image: url("<c:url value="/resource/images/sofa.jpg"/>" );
	  -webkit-background-size: cover;
  -moz-background-size: cover;
  background-size: cover;
  -o-background-size: cover;
   background-repeat: no-repeat;
  background-position: 99% center;
 background-size: 1670px 700px;
}	
 
 @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 5px;
      }
      .row.content {height:auto;} 
    }
 .btn {
  background-color: DodgerBlue;
  border: none;
  color: white;
  padding: 8px 14px;
  font-size: 16px;
  cursor: pointer;
}
.btn:hover {
  background-color: LightBlue;
}

 .btt {
  background-color: DodgerBlue;
  border: none;
  color: white;
  padding: 4px 4px;
  font-size: 15px;
  cursor: pointer;
   box-shadow: 0 -3px 4px 3px rgba(0,0,0,0.4);
}
.btt:hover {
  background-color: LightBlue;
}

.navbar {
      margin-bottom: 0;
      border-radius: 0;
      
    }
.sidenav {
      padding-top: 100px;
      height: 100%;
    } 
    
    
.flip-card {

  background-color: transparent;
  width: 350px;
  height: 280px;
  perspective: 1000px;
}

.flip-card-inner {

  position: relative;
  width: 100%;
  height: 100%;
  text-align: center;
 
  transform-style: preserve-3d;
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.4);
}

.flip-card:hover .flip-card-inner {

}

.flip-card-front, .flip-card-back {
background-image: url("<c:url value="/resource/images/5555.jpg"/>" );
  position: absolute;
  width: 100%;
  height: 100%;
  backface-visibility: hidden;
}

.flip-card-front {
  background-color: #2980b9;
  color: white;
  z-index: 2;
}

.flip-card-back {
  background-color: #2980b9;
  color: white;
  transform: rotateY(180deg);
  z-index: 1;
}
    
 .row.content {height: 450px}
     
</style>	
</head>
 <body>
<nav class="navbar navbar-inverse"  style="margin-bottom:0">
   <div class="container-fluid">
  <div class="navbar-header">
  <spring:url value="/admin" var="admin"/>
   <a href="${admin}"><img class="nav navbar-active" src="<c:url value="/resource/images/uuy.png"/>" width="43px" height="43px" alt="logo-image"></a>
    </div> 
<div class="container">
  <ul class="nav nav-pills">
    <li>
    <spring:url value="/teachers/teachersList" var="teachers"/>
        <a  href="${teachers}"><strong>Teachers</strong></a>
        </li>
    <li>
       <spring:url value="/students/find" var="students"/>
         <a href="${students}"><Strong>Students</Strong></a>
      </li>
      <li>
        <spring:url value="/subject/find" var="subject"/>
         <a href="${subject}"><Strong>Subjects</Strong></a>
         </li>
        <li>
         <spring:url value="/attendance/yearSearch" var="year"/>
        <a href="${year}"><Strong>View Attendance</Strong></a>
        </li>
      <li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li>
        <li><a></a></li> <li><a></a></li> <li><a></a></li> <li><a></a></li> <li><a></a></li> <li><a></a></li> <li><a></a></li>
         <li><a></a></li> <li><a></a></li> <li><a></a></li> <li><a></a></li> <li><a></a></li>
         <li>
         <a class="btn" href="<c:url value="/logout" />"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
  </ul>
</div>
</div>
</nav>
  <div class="container">            
  <ul class="breadcrumb">
    <li class="active">
    <spring:url value="/admin" var="admin"/>
       <a href="${admin}"> Admin Home</a>
    </li>    
 </ul>
</div>
  <div class="container-fluid text-center">    
  <div class="row content">  
  <div class="col-sm-1 sidenav">
    </div>
   <div class="col-sm-8 text-left ">  
  <h2 class="bg-danger">Welcome Admin</h2>
    <div class="text-center" >
    
     <div class="flip-card">
  <div class="flip-card-inner" style="margin-left: 380px;">
    <div class="flip-card-front">
 <img src="<c:url value="/resource/images/ivc.png"/>" alt="Avatar" width=100px height=100px>
   <h3>Admin Profile</h3>
      Admin UserName:  ${userName}<br>
     Admin Password:  ${password} <br>
   <a class="btt" href="<c:url value='/adminEdit/${id}'/>">Edit</a>
   </div>
  </div>
 </div>
</div>
</div>
     <div class="col-sm-3 sidenav">
       <br><br><br>  <br><br><br>  <br><br><br>  <br><br><br>  <br><br><br>  <br><br><br>
  <div class=btt>
  <spring:url value="/students/upgradeIdSemOfStudent" var="admin"/>
     <a href="${admin}"><i class='fas fa-chart-line' style='font-size:22px; color:red'> </i>
    <b><font color="White">Upgrade Semester Of Student of Different Departments</font></b></a>
	 <br>
 </div>
      </div>
      </div>
      </div>

    </body>
</html>