<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>Select Subject for View Attendance</title>
<style>
.bb{
margin-top: 90%;
margin-left: 5%;
}
body {
	 background-image: url("<c:url value="/resource/images/blu.jpg"/>" );
	  -webkit-background-size: cover;

   background-repeat: no-repeat;
}	
.btn {
  background-color: DodgerBlue;
  border: none;
  color: white;
  padding: 12px 16px;
  font-size: 16px;
  cursor: pointer;
}
.btn:hover {
  background-color: LightBlue;
}
 .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    .header {
  padding: 80px;
  text-align: center;
  background: #1abc9c;
  color: white;
}
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      height: 150%;
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
        padding: 15px;
      }
      .row.content {height:auto;} 
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
        <li class="active">
         <spring:url value="/attendance/yearSearch" var="attendance"/>
        <a href="${attendance}">View Attendance</a>
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
  <li>
  <spring:url value="/admin" var="admin"/>
       <a href="${admin}">Admin Home</a>
    </li>   
      <li>  
    <spring:url value="/attendance/yearSearch" var="attendance"/>
        <a href="${attendance}">Select Year</a>
        </li>
    
         <li class="active">  
      <spring:url value="/attendance/subjectSearch" var="attendance"/>
        <a href="#">Select Subject</a>
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
	  <div style="overflow-x:auto;">
  <div class="well" style="border-width:0px;margin-left: 280px; background-color:azure; border-style:ridge; width:60%; border-radius: 15px;  padding: 25px;">	
   
<c:url var="action" value="/attendance/viewAttendanceAdminPanel/${idSem}/${idYear}"></c:url>
<form:form action="${action}" method="POST" modelAttribute="subject">
		<tr> 
				<td>Subject:</td>
				
				<form:select path="subjectName" id="code">
    <c:forEach var="subject" items="${subjectList}">
    <form:option value="${subject.code}">${subject.subjectName}</form:option>
    </c:forEach>
    </form:select>
			</tr> 
		<tr>
		<td><input type="submit" value="Search" class="btn" style="width:150px;height:50px;border:0;"/></td>
		</tr>
</form:form>
</div>
	</div>
	</div>
	</div>
</div>
</body>
</html>

