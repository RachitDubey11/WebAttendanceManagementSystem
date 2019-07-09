<%@ include file="/WEB-INF/views/includes.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head> 
<title>Contact</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
body {
	 background-image: url("<c:url value="/resource/images/tfrr.jpg"/>" );
	  -webkit-background-size: cover;
  -moz-background-size: cover;
 background-repeat: no-repeat;
  background-position: 100% center;
  -o-background-size: cover;
   counter-reset: Serial;  
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

/* selected link */
a:active {
  color: blue;
}
table{
Width:100%;

}
   th, td {
  padding: 5px;
  text-align: left;
}
tr td:first-child:before
{
  counter-increment: Serial; 
  content:counter(Serial); 
} 
</style>
</head>
<body>
<body  style="height:1200px; width:1050px;">
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
      <a class="nav-link" href="${teachers}"><strong>ABOUT</strong></a>
    </li>
     <li class="nav-item">
         <spring:url value="/contact" var="teachers"/>
      <a class="nav-link active" href="${teachers}"><strong>CONTACT</strong></a>
    </li>
    <li class="nav-item">
        <spring:url value="/help" var="teachers"/>
      <a class="nav-link" href="${teachers}"><strong>HELP</strong></a>
    </li>
    </ul>
</nav>
<br>
<div class="row">
    <div class="col-sm-6">
    
    </div>
    
    <div class="col-sm-4">
    <br>
    <h1><center>Contact</center></h1>
    <br>
   <div class="container">
  <div id="accordion">
    <div class="card">
      <div class="card-header">
        <a class="card-link" data-toggle="collapse" href="#collapseOne">
          Teacher's Name:
        </a>
      </div>
    </div>
    <div class="card">
      <div class="card-header">
        <a class="card-link" data-toggle="collapse" href="#collapseTwo">
        Sanjeev Gangwaar
      </a>
      </div>
     <div id="collapseTwo" class="collapse show" data-parent="#accordion">
        <div class="card-body">
       <p> Mob. no.-9456469792  </p>
       <p> Email-  gangwar.sanjeev@gmail.com   </p>
     
        </div>
      </div>
    </div>
    <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseThree">
          Dileep kr Yadav
        </a>
      </div>
      <div id="collapseThree" class="collapse" data-parent="#accordion">
        <div class="card-body">
       <p> Mob. no.-8726943272 </p>
       <p> Email-dileep1482@gmail.com</p>
            </div>
      </div>
    </div>
     <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseFour">
        Gyanendra Pal
      </a>
      </div>
      <div id="collapseFour" class="collapse" data-parent="#accordion">
        <div class="card-body">
       <p> Mob. no.-8400015001            </p>
       <p> Email-gyanpal@gmail.com               </p>
        </div>
      </div>
    </div>
     <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseFive">
        Santosh kr Yadav
      </a>
      </div>
      <div id="collapseFive" class="collapse" data-parent="#accordion">
        <div class="card-body">
        <p> Mob. no.-9721412182            </p>
       <p> Email- santosh.yadav08@gmail.com              </p>
        </div>
      </div>
    </div>
     <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseSix">
        Prashant kr Yadav
      </a>
      </div>
      <div id="collapseSix" class="collapse" data-parent="#accordion">
        <div class="card-body">
       <p> Mob. no.-8726512503</p>
       <p> Email-prashant.yadaw@gmail.com </p>
        </div>
      </div>
    </div>
     <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseSeven">
        Praveen Pandey
      </a>
      </div>
      <div id="collapseSeven" class="collapse" data-parent="#accordion">
        <div class="card-body">
       <p> Mob. no.- 8903557902</p>
       <p> Email-pravin108786@gmail.com</p>
        </div>
      </div>
    </div>
     <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseeight">
        Divyendu Mishra
      </a>
      </div>
      <div id="collapseTwoeight" class="collapse" data-parent="#accordion">
        <div class="card-body">
       <p> Mob. no.-9455012072</p>
       <p> Email-divyendu01mishra@gmail.com </p>
        </div>
      </div>
    </div>
     <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseNine">
        Ashok Kr Yadav
      </a>
      </div>
      <div id="collapseNine" class="collapse" data-parent="#accordion">
        <div class="card-body">
       <p> Mob. no.-9453244456            </p>
       <p> Email-ashok231988@gmail.com               </p>
        </div>
      </div>
    </div>
     <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseTen">
       Sunil Kr Yadav
      </a>
      </div>
      <div id="collapseTen" class="collapse" data-parent="#accordion">
        <div class="card-body">
       <p> Mob. no.-7007238344</p>
       <p> Email-Sunilyadav988@gmail.com</p>
        </div>
      </div>
    </div>
     <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapse5">
        Purnendra Kumar
      </a>
      </div>
      <div id="collapse5" class="collapse" data-parent="#accordion">
        <div class="card-body">
       <p> Mob. no.-9919058559            </p>
       <p> Email-mmm999rj14@gmail.com               </p>
        </div>
      </div>
    </div>
     <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapse4">
        Deepti Pandey
      </a>
      </div>
      <div id="collapse4" class="collapse" data-parent="#accordion">
        <div class="card-body">
        <p> Mob. no.-9455942081</p>
       <p> Email- sanjeevani111.d@gmail.com </p>
        </div>
      </div>
    </div>
   
     <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapse1">
        Manoj Yadav
      </a>
      </div>
      <div id="collapse1" class="collapse" data-parent="#accordion">
        <div class="card-body">
        <p> Mob. no.- 8953662052   </p>
       <p> Email- manojkumaryadav1789@gmail.com              </p>
        </div>
      </div>
    </div>
      <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapse3">
        Ritesh Srivastava
      </a>
      </div>
      <div id="collapse3" class="collapse" data-parent="#accordion">
        <div class="card-body">
        <p> Mob. no.-            </p>
       <p> Email-               </p>
        </div>
      </div>
    </div>
     <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapse2">
        Krishna Kr Yadav
      </a>
      </div>
      <div id="collapse2" class="collapse" data-parent="#accordion">
        <div class="card-body">
       <p> Mob. no.-            </p>
       <p> Email-               </p>
        </div>
      </div>
    </div>
     <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapse78">
        Ravi Kant Yadav
      </a>
      </div>
      <div id="collapse78" class="collapse" data-parent="#accordion">
        <div class="card-body">
       <p> Mob. no.-8004413876</p>
       <p> Email-rkyadav.vbspu@gmail.com </p>
        </div>
      </div>
    </div>
  </div>
</div>
  </div>   
  </div>

</body>
</html>