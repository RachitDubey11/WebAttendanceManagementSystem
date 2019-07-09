<%@ include file="/WEB-INF/views/includes.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<title>Older Attendance</title>
<link rel="icon" type="image/x-icon" href="<c:url value="/resource/images/imgg.png"/>" />
<style>

body {
	 background-image: url("<c:url value="/resource/images/blur.jpg"/>" );
	  -webkit-background-size: cover;

   background-repeat: no-repeat;
    counter-reset: Serial;           /* Set the Serial counter to 0 */
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
        padding: 5px;
      }
      .row.content {height:auto;} 
    }
th, td {
  padding: 15px;
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
</style>
</head>
<body>
 <nav class="navbar navbar-inverse"  style="margin-bottom:0">
   <div class="container-fluid">
  <div class="navbar-header">
     <spring:url value="/teacher" var="teacher"/>
   <a href="${teacher}"><img class="nav navbar-active" src="<c:url value="/resource/images/uuy.png"/>" width="43px" height="43px" alt="logo-image"></a>
    </div> 
<div class="container">
  <ul class="nav nav-pills">
    <li class="active">
    <spring:url value="/teacher" var="teacher"/>
        <a  href="${teacher}"><strong>Teachers</strong></a>
        </li><li><a></a></li> <li><a></a></li><li><a></a></li> <li><a></a></li><li><a></a></li><li><a></a></li>
     <li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li>
        <li><a></a></li> <li><a></a></li> <li><a></a></li> <li><a></a></li> <li><a></a></li> <li><a></a></li> <li><a></a></li>
         <li><a></a></li> <li><a></a></li> <li><a></a></li> <li><a></a></li> <li><a></a></li>
         <li><li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li>
         <a class="btn" href="<c:url value="/logout" />"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
  </ul>
</div>
</div>
</nav>
<div class="container">            
  <ul class="breadcrumb">
    <li>
     <spring:url value="/teacher" var="teacher"/>
       <a href="${teacher}">Teacher</a>   
    </li>    
    <li class="active">
     <spring:url value="/attendance/takeOlderAttendance/${idSem}/${code}" var="attendance"/>
       <a href="${attendance}">Select Month</a>
    </li> 
 </ul>
</div>
<div class="container-fluid text-center">    
  <div class="row content">   
  <div class="col-sm-2 sidenav">
 <br>
    </div>
    <div class="col-sm-8 text-left"> 
    <h2>Select Month</h2>
    <div style="overflow-x:auto;">
  <div class="well" style="border-width:0px;margin-left: 300px; background-color:azure; border-style:ridge; width:36%; border-radius: 15px;  padding: 30px;">	
<c:url var="action" value="/attendance/takeOlderAttendance/${idSem}/${code}"></c:url>
<form:form action="${action}" method="POST" modelAttribute="month">
<tr>
				<td>Month:</td>
				<td><form:select path="monthName">
						<form:options items="${monthList}" />
					</form:select></td>
												<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
					
			</tr>
			<tr>
		<td><input type="submit" value="Search Student" class="btn" style="width:130px;height:50px;border:0;"/></td>
		</tr>
</form:form> 
	</div>
	</div>
	</div>
	</div>
</div>
</body>
</html>