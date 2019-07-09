<%@ include file="/WEB-INF/views/includes.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.Calendar"%>   
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
<title>Teacher Panel</title>
<link rel="icon" type="image/x-icon" href="<c:url value="/resource/images/imgg.png"/>" />
<style>

body {
	 background-image: url("<c:url value="/resource/images/gff.jpg"/>" );
	  -webkit-background-size: cover;
   background-repeat: no-repeat;
  background-position: 99% center;
 background-size: 2000px 950px;
    counter-reset: Serial;           /* Set the Serial counter to 0 */
}	
     .navbar {
      margin-bottom: 0;
      border-radius: 0;
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
 
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      height: 110%;
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
  width: 210px;
  height: 280px;
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
   font-size: 14px;
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

tr td {
 padding: 8px;

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
     <li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li>
        <li><a></a></li> <li><a></a></li> <li><a></a></li> <li><a></a></li> <li><a></a></li> <li><a></a></li> <li><a></a></li>
         <li><a></a></li> <li><a></a></li> <li><a></a></li> <li><a></a></li> <li><a></a></li>
         <li><li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li>
         <a class="btn" href="<c:url value="/logout" />"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
  </ul>
</div>
</div>
</nav>
<div class="container">            
  <ul class="breadcrumb">
    <li>
     <spring:url value="/teacher" var="teacher"/>
       <a href="${teacher}">Teachers</a>
     </li>  
  </ul>
</div>   
<button onclick="topFunction()" id="myBtn" title="Go to top">Top</button>
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
    <h3>Teacher Profile</h3>
      <div class="flip-card">
  <div class="flip-card-inner">
    <div class="flip-card-front">
   <img src="<c:url value="/resource/images/ivc.png"/>" alt="Avatar" width=90px height=90px>
   <br>
   <br>
       <div><Label>User Name:</Label>${user}</div> 
        
       <div><Label>Teacher's Name:</Label>${teacherName}</div>  
              <div>${email}</div>  
       <div>${phoneNumber}</div>      
         
    </div>
  </div>
</div>
    </div>
     <div class="col-sm-10 text-left"> 
  <h2 class="bg-info">Teacher's Panel</h2>
    	<hr> 	
<table class="table table-striped" cellspacing="0" width="100%" border="0">
<tr>
<th>Srno.</th>
<th>Semester</th>
<th>Department</th>
<th>Subject</th>
<%
int a=Calendar.getInstance().get(Calendar.MONTH);
if(a<=4 || a>=6)
{%>
	<th>Take Attendance</th>
<%	}	%>
<th>View Attendance</th>
<th>Date</th>

<%
if(a<=4 || a>=6)
{%>
	<th>Take Older Attendance</th>
<%	}	%>

</tr>

	<c:forEach items="${teachersemdeptsubjectList}" var="teachersemdeptsubject">
	<tr>
	<td></td>
 	<td><c:out value="${teachersemdeptsubject.semName }"/></td>
 	<td><c:out value="${teachersemdeptsubject.dept }"/></td>
	<td><c:out value="${teachersemdeptsubject.subjectName}"/></td> 
	
	<%
if(a<=4 || a>=6)
{%>
	<td><a class="btt" href="<c:url value='/attendance/find/${teachersemdeptsubject.semdept_idSem}/${teachersemdeptsubject.subject_code}'/>">Take Attendance</a></td>
 <%	}	%> 
    
    <td><a class="btt" href="<c:url value='/attendance/viewAttendance/${teachersemdeptsubject.semdept_idSem}/${teachersemdeptsubject.subject_code}'/>">View Attendance</a></td>
	<td><c:out value="${date}"/></td> 
<%
if(a<=4 || a>=6)
{%>	
	<td><a class="btt" href="<c:url value='/attendance/takeOlderAttendance/${teachersemdeptsubject.semdept_idSem}/${teachersemdeptsubject.subject_code}'/>">Take Older Attendance</a></td>
	 <%	}	%>
	
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
</body>
</html>