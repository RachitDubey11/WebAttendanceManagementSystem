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

<title>Add Student</title>
<style type="text/css">
.error {
	color: red;
}
body {
	 background-image: url("<c:url value="/resource/images/ewee.jpg"/>" );
	  -webkit-background-size: cover;
 background-size: 1350px 690px;
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
tr:hover {
  background-color: LightBlue;
}
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    .md-form:hover {
  background-color: LightBlue;
}
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      height: 80%;
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
    }
input[type=text] {
  width: 100%;
  padding: 5px 8px;
  margin: 3px 0;
  box-sizing: border-box;
}
</style>

<script>
function validateForm() {
  var x = document.forms["myForm"]["sname"]["rno"]["fname"].value;
  if (x == "") {
    alert("Data must be filled out");
    return false;
  }
}
</script>

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
    <li >
    <spring:url value="/teachers/teachersList" var="teachers"/>
        <a  href="${teachers}"><strong>Teachers</strong></a>
        </li>
    <li  class="active">
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
    <spring:url value="/students/find" var="students"/>
       <a href="${students}">Search Student</a>
    </li> 
    <li class="active">
    <a href="<c:url value='#'/>">Add Students </a>
    </li>  
  </ul>
</div>
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
    </div>
   <div class="col-sm-8 text-left">   
      <h2>Add New Student</h2>
      <hr>
 <div class="text-center">   
  </div>
<div id="mainWrapper">     
<div class="well" style="border-width:0px;margin-left: 350px; background-color:azure; border-style:ridge; width:30%; border-radius: 15px;  padding: 25px;">	

 
<c:url var="action" value="/students/create/${st}"></c:url>
<form:form action="${action}" name="myForm" onsubmit="return validateForm()" method="POST" modelAttribute="student">
	           
	         <div class="md-form">
			 <Label>Student's Name:</Label>
				<form:input path="studentName" name="sname" placeholder="Student's Name" required="true"/>
				<form:errors path="studentName" cssClass="error"/>
				</div>
		<div class="md-form">
		      <label> UserName:</label>
		      <form:input path="user.userName" name="fname" placeholder="User Name" required="true"/>
		    	<form:errors path="user.userName" cssClass="error"/>
		    	</div>
 
		       	<div class="md-form">
		       <label>RollNo:</label>
		     <form:input path="user.password" name="rno" placeholder="Password" required="true"/> 
		       <form:errors path="user.password" cssClass="error" />
		       </div>
		       <div class="md-form">
		       <label>E-Mail:</label>
				<form:input type="email" path="email" placeholder="E-mail" />
				<form:errors path="email" cssClass="error"/>
				</div>
		       	<div class="md-form">
		       <label>Mobile No:</label>
				<form:input path="phoneNumber" placeholder="Mobile no"  />
				<form:errors path="phoneNumber" cssClass="error"/>
	
		       <form:input type="hidden" path="Semdept.idSem" value="${st}" />
		       <input type="hidden" path="user.state" value="Active" />
		        <form:input type="hidden" path="Year.idYear" value="${idYear}" />
		       
		       </div>
		       <br>
		       	<div class="text-center">		
		<div class="button">
		<input type="submit" value="Add Student" class="btn" style="width:150px;height:50px;border:0;"/>
		</div>
		</div>

</form:form>
</div>
</div>
</div>
</div>
 </div>
</div>
</body>
</html>

