<%@ include file="/WEB-INF/views/includes.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head> 
<title>About</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
body {
	 background-image: url("<c:url value="/resource/images/exs.jpg"/>" );
  -webkit-background-size: cover;
  -moz-background-size: cover;
 background-repeat: repeat;
  background-position: 100% center;
  -o-background-size: cover;
 }	
 .navbar {
      margin-bottom: 0;
      border-radius: 0;
     font-size:13px;
     height: 40px;
    }
   .row.content {height: 350px}
   
/* mouse over link */
a:hover {
  color: Turquoise ;
}
button{ 
width: 140px;
height: 40px;}

/* selected link */
a:active {
  color: blue;
}
</style>
</head>
<body>
<body style="height:1000px">
<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
   <a class="navbar-brand">
   <spring:url value="/" var="admin"/>
   <a href="${admin}"><img class="nav navbar-active" src="<c:url value="/resource/images/uuy.png"/>" width="43px" height="43px" alt="logo-image"></a> 
  </a>
  <ul class="nav nav-pills" role="tablist">
    <li class="nav-item">
      <a class="nav-link" href="${admin}"><strong>HOME</strong></a>
    </li>
    <li class="nav-item">
        <spring:url value="/about" var="teachers"/>
      <a class="nav-link  active" href="${teachers}"><strong>ABOUT</strong></a>
    </li>
     <li class="nav-item">
         <spring:url value="/contact" var="teachers"/>
      <a class="nav-link" href="${teachers}"><strong>CONTACT</strong></a>
    </li>
    <li class="nav-item">
        <spring:url value="/help" var="teachers"/>
      <a class="nav-link" href="${teachers}"><strong>HELP</strong></a>
    </li>
    </ul>
</nav>
<br>
<div style="margin-top:1px">
<a><img src="<c:url value="/resource/images/vbs.jpg"/>" width="1360px" height="170px"></a>
<hr>
</div>
  <div class="row">
    <div class="col-sm-2">
    <br>
     <div class="dropdown">
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
    Departments
    </button>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="http://www.vbspu.ac.in/introduction-department-of-information-technology/">Information Technology</a>
      <a class="dropdown-item" href="http://www.vbspu.ac.in/introduction-department-of-computer-science-and-engineering/">Computer Science</a>
    </div>
  </div>
     <div class="dropdown">
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
    Syllabus
    </button>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="http://www.vbspu.ac.in/syllabus-department-of-information-technology/">Information Technology</a>
      <a class="dropdown-item" href="http://www.vbspu.ac.in/syllabus-department-of-computer-science-and-engineering/">Computer Science</a>
    </div>
  </div>
    <div class="dropdown">
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
    Calender
    </button>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="http://www.vbspu.ac.in/academic-calender/">Academic Calender</a>
        </div>
  </div>
      <hr class="d-sm-none">
    </div>
    <div class="col-sm-9">
      <h2>About University</h2>
      <p>Purvanchal University, Jaunpur renamed as Veer Bahadur Singh Purvanchal University in the honour of late Shri Veer Bahadur Singh, former Chief Minister of the state, was established on 2nd October 1987 as an affiliating university under U.P. state university act 1973. Continuous qualitative and quantitative growth, excellence in academic and administrative activities, transparent and efficient academic administration have been some of the distinct characteristics on the basis of which the university emerged as one among the leading universities. Started with the 68 affiliated colleges, the university now has widened it's spectrum of activities with 367 affiliated graduate and post-graduate colleges and students enrollment of nearly three lacs and eighty thousand in 5 Districts of Eastern Uttar Pradesh.</p>
<hr>
<h3> Introduction (UNS Institute of Engineering and Technology)</h3>
<p>The Uma Nath Singh Institute of Engineering and Technology, Started in the year 1997 initially with three departments in the faculty of Engineering and Technology at Veer Bahadur Singh Purvanchal University, Jaunpur. Initially the institute launched its academic activities with strength of ninety students. In the year 2002, the institute raised the annual intake from 90 to 180.The institute in a very short span of time established all the facilities to impart effective education to students. the institute achieved the distinction as one of the best equipped institute of the state. The institute boasts of having adequate numbers of faculty members with other required facilities like the computer centre, fiber optics Laboratory, microwave Laboratory, instrumentation facilities, language lab, computer labs, mechanical workshop.</p>
 
 <hr>
 <h3>Salient Features Of The Department</h3>
<ul>
<li>Excellent Infrastructure</li>
<li>Continuous power supply.</li>
<li>Career guidance from training and placement officer.</li>
<li>The Laboratories are installed with broad-band internet facility. </li>
 </ul> 
  
   </div>
  </div>

</body>
</html>