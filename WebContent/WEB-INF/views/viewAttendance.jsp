<%@ include file="/WEB-INF/views/includes.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>Admin Attendance list</title>
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


.flip-card {
  background-color: transparent;
  width: 200px;
  height: 250px;
  perspective: 1000px;
}

.flip-card-inner {
  background-color: #2980b9;
 background-color: transparent;
  position: relative;
  width: 100%;
  height: 100%;
  text-align: center;
  transform-style: preserve-3d;
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.4);
}

.flip-card-front {
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
  padding: 4px 8px;
  font-size: 14px;
  cursor: pointer;
  box-shadow: 0 -1px 2px 1px rgba(0,0,0,0.4);
}
.btt:hover {
  background-color: LightBlue;
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
         <li class="active" >
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
      <li>  
    <spring:url value="/attendance/yearSearch" var="attendance"/>
        <a href="${attendance}">Select Year</a>
        </li>
         <li class="active">  
      <spring:url value="/attendance/subjectSearch" var="attendance"/>
        <a href="#">Attendance List</a>
        </li>
        </ul>
      </div>
       <button onclick="topFunction()" id="myBtn" title="Go to top">Top</button>
<div class="container-fluid text-center">    
  <div class="row content">   
 <div class="col-sm-2 sidenav">
    <div class="flip-card">
  <div class="flip-card-inner">
    <div class="flip-card-front">
    <h2>Detail</h2>
    <label>Department :</label>${dept}
<br>
 <br>
<label>Semester:</label>${semName}
 <br>
 <br>
<Label>Subject's Name:</Label>
 <br>${subjectName}

    </div>
  </div>
  
  </div>
  </div>

  <div class="col-sm-8 text-left"> 
  
   <h2>Attendance List</h2> 
   <hr>	

<table class="table table-striped"  cellspacing="0" width="100%" border="0">
<tr>
<th>SrNo.</th>
<th>StudentName</th>
<th>Roll No.</th>
<th>Attend</th>
<th>Total</th>
<th>Percentage</th>
<th>View Details</th>

</tr>
	<c:forEach items="${viewAttendanceList}" var="percent">
	<tr>
	<td></td>
		 <td><c:out value="${percent.studentName}"/></td>
		 			 <td><c:out value="${percent.password}"/></td>
	 <td><c:out value="${percent.attend}"/></td>
	<td><c:out value="${percent.total}"/></td>
	<td><c:out value="${percent.percentage}"/></td> 
	<td><a class= "btt" href="<c:url value='/attendance/viewAttendanceStudent/${percent.idStudent}/${idSem}/${code}/${idYear}'/>">View Details</a></td>
 </tr>
	</c:forEach>
	</table>
</div>
<div class="col-sm-2 sidenav">

 <spring:url value="/attendance/viewMonthlyAdminPanel/${idSem}/${code}/${idYear}" var="admin"/>
   <a class="btn" href="${admin}">View Attendance By Dates</a>
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

	<footer>
<!-- <div class="fixed-bottom">
      <ul class="nav navbar-nav">
        <li><a href="#">About</a></li>
        <li><a href="#">Contact</a></li>
        <li><a href="#">Help</a></li>
        <li><a href="#">Follow us</a></li>
        
      </ul>
    </div> -->
</footer>    
</body>
</html>