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
  <link rel="icon" type="image/x-icon" href="<c:url value="/resource/images/imgg.png"/>" />
<title>Edit Admin</title>
<style type="text/css">
.error {
	color: red;
}
body {
	 background-image: url("<c:url value="/resource/images/blu.jpg"/>" );
   -webkit-background-size: cover;
  -moz-background-size: cover;
  background-size: cover;
  -o-background-size: cover;
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
.xyz{
 background-color: Azure;
  border: none;
  padding: 4px 8px;
  font-size: 14px;
  cursor: pointer;
}
.xyz:hover{
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
      /* Set gray background color and 100% height */
  .sidenav {
      padding-top: 20px;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
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

    
    table, th, td {
   border-collapse: collapse; 
  }
th, td {
  padding: 15px;
}
input[type=text] {
  width: 100%;
  padding: 4px 8px;
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
    <li>
    <spring:url value="/admin" var="admin"/>
       <a href="#">Edit Admin</a>
    </li>  
 </ul>
</div>

 <div class="row content">
    <div class="col-sm-2 sidenav">
    </div>
 <div class="col-sm-8 text-left">   
<h2>Edit Admin Data</h2>
<br>
<div class="well" style="border-width:0px;margin-left: 350px; background-color:azure; border-style:ridge; width:30%; border-radius: 15px;  padding: 20px;">	
<c:url var="action" value="/adminUpdate"></c:url>
<form:form action="${action}" method="POST" modelAttribute="user">
		<div class="xyz" >	
		<form:hidden path="id" />
	 	<form:errors path="id" cssClass="error"/>
	</div>
	 <div class="xyz" >	
		<Label>User Name:</Label>
		<form:input path="userName" required="true"/>
		<form:errors path="userName" cssClass="error"/>
	</div>
	<div class="xyz">	
		<Label>Password:</Label>
        <form:input path="password" required="true"/>
	</div>
		
	<div class="text-center"><input type="submit" value="Update" class="btn" style="width:180px;height:50px;border:0;" />
	</div>

</form:form>
   </div>
 </div>
  </div>


</body>
</html>

