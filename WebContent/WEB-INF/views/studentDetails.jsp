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
<title>Student Detail</title>
<style>
body {
	 background-image: url("<c:url value="/resource/images/gff.jpg"/>" );
	  -webkit-background-size: cover;
 counter-reset: Serial;     
   background-repeat: no-repeat;
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
  padding: 12px 16px;
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
  padding: 4px 8px;
  font-size: 14px;
  cursor: pointer;
  box-shadow: 0 -1px 2px 1px rgba(0,0,0,0.4);
}
.btt:hover {
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
    <li class="active">
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
       <a href="${students}">Students</a>
     </li>    
     <li class="active">
    <a href=#>Student list</a>
    </li>  
  </ul>
</div>
<button onclick="topFunction()" id="myBtn" title="Go to top">Top</button>
<div class="container-fluid text-center">    
  <div class="row content">   
  <div class="col-sm-2 sidenav">

 	<a href="<c:url value='/students/register/${idSem}'/>">
    <img src="<c:url value="/resource/images/ads.png"/>" class="img-thumbnail" style="width:42px;height:42px;border:0;"><b>Add Students</b></a>
	 <br>
    </div>
     <div class="col-sm-9 text-left"> 
      <h1>Students List</h1>
    	<hr>
    	<table class="table table-striped" cellspacing="0" width="100%" border="0" >
<tr>
<th>Srno.</th>
<th>Student's Name</th>
<th>Username</th>
<th>Password</th>
<th>Email</th>
<th>Mobile Number</th>
<th>Edit</th>
<th>Delete</th>
</tr>
	<c:forEach items="${studentValue}" var="student">
	<tr>
	<td></td>
	<td><c:out value="${student.studentName }"/></td>
	<td><c:out value="${student.user.userName }"/></td>
	<td><c:out value="${student.user.password}"/></td>
	<td><c:out value="${student.email}"/></td>
	<td><c:out value="${student.phoneNumber}"/></td>
	
    <td><a class="btt" href="<c:url value='/students/edit/${student.idStudent}/${idSem}'/>">Edit</a></td>
	<td><a class="btt" href="<c:url value='/students/delete/${student.user.id}/${idSem}'/>">Delete</a></td>
	</tr>
	</c:forEach>
	
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
</footer>     
</body>
</html>