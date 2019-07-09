    <%@ include file="/WEB-INF/views/includes.jsp"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="hi">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href='https://fonts.googleapis.com/css?family=Aleo' rel='stylesheet'>
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Upgrade Student sem</title>
<link rel="icon" type="image/x-icon" href="<c:url value="/resource/images/imgg.png"/>" />
<style>

body {
	 background-image: url("<c:url value="/resource/images/gff.jpg"/>" );
	  -webkit-background-size: cover;
   background-repeat: no-repeat;
    counter-reset: Serial;           /* Set the Serial counter to 0 */
}	
  .btn {
  background-color: DodgerBlue;
  border: none;
  color: white;
  padding: 8px 14px;
  font-size: 16px;
  cursor: pointer;
   box-shadow: 0 -5px 12px 9px rgba(0,0,0,0.6);
}
.btn:hover {
  background-color: LightBlue;
}
     .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
 
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      color: white;
      padding: 5px;
    }
      /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 5px;
      }
      .row.content {height:auto;} 
    }

th, td {
  padding: 5px;
  text-align: left;
}
tr:hover {background-color: azure;}
tr td:first-child:before
{
  counter-increment: Serial; 
  content:counter(Serial); 
}
#myBtn {
  display: none;
  position: fixed;
  bottom: 20px;
  right: 30px;
  z-index: 99;
  font-size: 18px;
  border: none;
  outline: none;
  background-color: DodgerBlue;
  color: white;
  cursor: pointer;
  padding: 15px;
  border-radius: 4px;
}

#myBtn:hover {
  background-color: #555;
}

   
.flip-card {

  background-color: transparent;
  width: 400px;
  height: 320px;
  perspective: 1000px;
}

.flip-card-inner {

  position: relative;
  width: 100%;
  height: 100%;
  text-align: center;
 
  transform-style: preserve-3d;
  box-shadow: 0 2px 8px 4px rgba(0,0,0,0.6);
}


.flip-card-front{
background-image: url("<c:url value="/resource/images/wee.jpg"/>" );
  position: absolute;
  width: 100%;
  height: 100%;
  backface-visibility: hidden;
}

.flip-card-front {
  background-color: #2980b9;
  color: black;
  z-index: 2;
}
    
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
         <spring:url value="/attendance/yearSearch" var="attendance"/>
        <a href="${attendance}">View Attendance</a>
        </li>
        <li>
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
  <li>
   <spring:url value="/admin" var="admin"/>
       <a href="${admin}">Admin Home</a>
       </li>
    <li class="active">
   <spring:url value="/students/upgradeIdSemOfStudent" var="admin"/>
     <a href="${admin}">Upgrades</a>
    </li>   
   </ul>
</div> 
<div class="container-fluid text-center">    
  <div class="row content">   
  <div class="col-sm-2 sidenav">
  <br>
  </div>
  <div class="col-sm-8 text-left"> 
  <br>
  <br>
  <br>
    <div class="flip-card">
  <div class="flip-card-inner" style="margin-left: 280px;">
    <div class="flip-card-front">
    <h3>Note: Please Read this first, Before click on link</h3>
    <hr>
    <h4>Given Button is for Upgrading the Semester of all Students of any Department</h4>
    <h4>So, If you are fully sure of upgrading the Semester for new session then only press the button</h4>
<br>
<i class='far fa-hand-point-right' style='font-size:20px'></i>
<spring:url value="/students/finallyUpgradeIdSemOfStudent" var="admin"/>
<a class="btn" href="${admin}"><i class='fas fa-chart-line' style='font-size:22px'> </i>Upgrade Semester Of Students</a>
  </div>
  </div>
  </div>
  </div>
  </div>
  </div>


</body>
</html>