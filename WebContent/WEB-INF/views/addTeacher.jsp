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
  <link rel="icon" type="image/x-icon" href="<c:url value="/resource/images/jj.png"/>" />
<title>Add Teacher</title>
<style type="text/css">
.error {
	color: red;
}
body {
	 background-image: url("<c:url value="/resource/images/werr.jpg"/>" );
	  -webkit-background-size: cover;

   background-repeat: no-repeat;
}
.btn {
  background-color: DodgerBlue;
  border: none;
  color: white;
  padding: 10px 14px;
  font-size: 16px;
  cursor: pointer;
}
.btn:hover {
  background-color: LightBlue;
}
.md-form:hover {
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
      height: 120%;
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
        padding: 10px;
      }
      .row.content {height:auto;} 
    }
input[type=text] {
  width: 80%;
  padding: 5px 8px;
  margin: 2px 0;
  box-sizing: border-box;
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
    <li class="active">
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
       <li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li>
        <li><a></a></li> <li><a></a></li> <li><a></a></li> <li><a></a></li> <li><a></a></li> <li><a></a></li> <li><a></a></li>
         <li><a></a></li> <li><a></a></li> <li><a></a></li> <li><a></a></li> <li><a></a></li>
         <li>
                  <spring:url value="/logout" var="logout"/>
         <a class="btn" href="${logout}"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
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
    <spring:url value="/teachers/teachersList" var="teachers"/>
       <a href="${teachers}">Teachers</a>
    </li>      
    <li class="active">
    <a href="<c:url value='/teachers/register'/>">Add Teachers </a>
    </li>  
  </ul>
</div>
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
    </div>
   <div class="col-sm-8 text-left">   
      <h2>Add New Teacher</h2>
      <hr>
  <div class="text-center">   
<c:url var="action" value="/teachers/create"></c:url>
    <div class="card">
      </div>
      </div> 
<div id="mainWrapper">     
<div class="well" style="border-width:0px;margin-left: 300px; background-color:azure; border-style:ridge; width:40%; border-radius: 15px;  padding: 30px;">	
<c:url var="action" value="/teachers/create"></c:url>
<form:form action="${action}" method="POST" modelAttribute="teacher">
	<label>Teachers Name</label>
	<div class="md-form">	
	<div class="text-center">
		 <form:input path="teacherName" placeholder="Teacher's Name" required="true"/>
		<form:errors path="teacherName" cssClass="error"/>	
	</div>
	</div>
	<label>User Name</label>
	<div class="md-form">
	
	<div class="text-center">
				<form:input path="user.userName" placeholder="User Name" required="true"/>
				<form:errors path="user.userName" cssClass="error"/>
				</div>
	</div>
		<label>Password</label>  
	<div class="md-form">  
	<div class="text-center">       
				<form:input path="user.password" placeholder="Enter Password" required="true"/>
				<form:errors path="user.password" cssClass="error"/>
				</div>
	</div>
		<label>Email Address</label>
	<div class="md-form">	
	<div class="text-center">
				<form:input path="email" placeholder="Enter email"/>
				<form:errors path="email" cssClass="error"/>
			</div>	
			</div>	
	<label>Mobile No.</label>
	<div class="md-form">	
	<div class="text-center">   
		<form:input path="phoneNumber" placeholder="Enter Mobile no." />
		<form:errors path="phoneNumber" cssClass="error"/>		
	</div>
	</div>
		<div>
		  <input type="hidden" path="user.state" value="Active" />
		</div>	
	<br> 
	<div class="text-center">
		<div class="button">
	 <input type="submit" value="Add User" class="btn" style="width:150px;height:50px;border:0;" />		
	</div>
	</div>
</form:form>
 </div>
 </div>
    </div>
  </div>
</div>

</body>
</html>

