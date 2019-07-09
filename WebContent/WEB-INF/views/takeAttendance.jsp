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

<title>Take Attendance</title>
<style>
body {
	 background-image: url("<c:url value="/resource/images/blu.jpg"/>" );
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
       </li>
       <li><a></a></li><li><a></a></li> <li><a></a></li><li><a></a></li> <li><a></a></li><li><a></a></li>
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
        <a  href="${teacher}">Teachers</a>
        </li>    
    <li class="active">
     <spring:url value="/attendance/find/${teachersemdeptsubject.semdept_idSem}/${teachersemdeptsubject.subject_code}" var="attendance"/>
       <a href=#>Take Attendance</a>
    </li> 
 </ul>
</div>
<button onclick="topFunction()" id="myBtn" title="Go to top">Top</button>
<div class="container-fluid text-center">    
  <div class="row content">   
  <div class="col-sm-2 sidenav">
</div>
  <div class="col-sm-8 text-left"> 
      <h3>Student List for attendance</h3>
    	<hr> 	 
<table class="table table-striped" cellspacing="0" width="100%" border="0">
<tr>
<th>Srno.</th>
<th>P/A</th>
<th>Student's Name</th>
<th>Roll No.</th>
</tr>
<c:url var="action" value="/attendance/editCustomer"></c:url>
<form:form action="${action}" method="POST" modelAttribute="attendance">
<c:forEach var = "student" items = "${sd}">
 <tr>
 <td></td>
 <td><input type="hidden" name="idStudent" checked="checked" value="${student.idStudent }">          
<input type = "checkbox" name = "idStudent" path="student.idStudent" value = "${student.idStudent}" /></td>
 <td><c:out value = "${student.studentName}" /></td>
   <td><c:out value = "${student.user.password}" /></td>
<form:input type="hidden" path="aDate" value="${date}"/>
<form:input type="hidden" path="semdept.idSem" value="${idSem}"/>
<form:input type="hidden" path="subject.code" value="${code}"/>
 <form:input type="hidden" path="month.idMonth" value="${month}"/></td> 
</c:forEach> 

 <c:forEach var = "subject" items = "${presentStudent}">
  <tr>
  <td></td>
  <td><input type="hidden" name="idStudent" checked="checked" value="${subject.idStudent }">        
 <input type = "checkbox" name = "idStudent" path="subject.idStudent" checked="checked" value = "${subject.idStudent}" /></td>
  <td><c:out value = "${subject.studentName}" />
      <td><c:out value = "${subject.password}" />
  
  <input type="hidden" value="on" name="_idStudent"/>
<form:input type="hidden" path="aDate" value="${date}"/>
<form:input type="hidden" path="semdept.idSem" value="${idSem}"/>
<form:input type="hidden" path="subject.code" value="${code}"/>
 <form:input type="hidden" path="month.idMonth" value="${month}"/></td> 
 </tr>
 </c:forEach>
 
 
 <c:forEach var = "subject1" items = "${absentStudent}">
 <tr>
  <td></td>
  <td><input type="hidden" name="idStudent" checked="checked" value="${subject1.idStudent }">          
<input type = "checkbox" name = "idStudent" path="subject1.idStudent"  value = "${subject1.idStudent}" /></td>
  <td><c:out value = "${subject1.studentName}" />
      <td><c:out value = "${subject1.password}" />
  
<input type="hidden" value="on" name="_idStudent"/>
<form:input type="hidden" path="aDate" value="${date}"/>
<form:input type="hidden" path="semdept.idSem" value="${idSem}"/>
<form:input type="hidden" path="subject.code" value="${code}"/>
<form:input type="hidden" path="month.idMonth" value="${month}"/></td> </tr>
 </c:forEach>
<div>
<input type="submit" value="Take Attendance" class="btn" style="width:200px;height:50px;border:0;" />
</div>
</form:form> 	
</table>
	</div>
	</div>
	</div>
<script>
// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
    document.getElementById("myBtn").style.display = "block";
  } else {
    document.getElementById("myBtn").style.display = "none";
  }
}
function topFunction() {
  document.body.scrollTop = 0;
  document.documentElement.scrollTop = 0;
}
</script>
 </body>
</html>