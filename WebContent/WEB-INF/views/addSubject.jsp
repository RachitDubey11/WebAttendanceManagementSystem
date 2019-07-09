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

<title>Add Subject</title>
<style type="text/css">
.error {
	color: red;
}
body {
	 background-image: url("<c:url value="/resource/images/blu.jpg"/>" );
	  -webkit-background-size: cover;
counter-reset: Serial;  
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
        padding: 15px;
      }
      .row.content {height:auto;} 
 

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
    <li>
       <spring:url value="/students/find" var="students"/>
         <a href="${students}"><Strong>Students</Strong></a>
      </li>
      <li class="active">
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
     <spring:url value="/subject/find" var="subject"/>
       <a href="${subject}">Subject Search </a>
     </li>  
      
     <li>
     <spring:url value="/subject/find" var="subject"/>
       <a href="#">Add Subjects</a>
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
  <div class="well" style="border-width:0px;margin-left: 260px; background-color:azure; border-style:ridge; width:55%; border-radius: 15px;  padding: 25px;">	
   
 <form action="/WebAttendanceManagementSystem/subject/create.html" method="POST">
	 <tr>
		      <td>Subject's Name:</td>
				<td><input type="text" name="subjectName" required/>
			<form:errors path="subjectName" cssClass="error"/>
			<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
		        <input type="hidden" name="idSem" value="${st}" /></td>
		   </tr>
		       	<tr>
		<td><input type="submit" value="Add Subject" class="btn" style="width:130px;height:50px;border:0;"/></td>
		</tr>
	
</form>
</div>
	</div>
	<hr>
	</div>
	</div>
</div>
	
</body>
</html>

