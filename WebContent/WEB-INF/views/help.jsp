<%@ include file="/WEB-INF/views/includes.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head> 
<title>Help</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
 html,body {
	 background-image: url("<c:url value="/resource/images/cfre.jpg"/>" );
	  -webkit-background-size: cover;
  -moz-background-size: cover;
 background-repeat: no-repeat;
  background-position: 100% center;
  -o-background-size: cover;
font-family: 'Numans', sans-serif;
}

 .container{
height: 100%;
align-content: center;
}

.card{
height: 370px;
margin-top: auto;
margin-bottom: auto;
width: 400px;
background-color: rgba(0,0,0,0.5) !important;
}


.card-header h3{
color: white;
}

.social_icon{
position: absolute;
right: 20px;
top: -45px;
}

.input-group-prepend span{
width: 100px;
background-color: #FFC312;
color: black;
border:0 !important;

}

.input-group2-prepend span{
width: 225px;
color: Black;
border:0px !important;
margin-left: 10px;
}

input:focus{
outline: 0 0 0 0  !important;
box-shadow: 0 0 0 0 !important;

}

.links{
color: white;
}

.links a{
margin-left: 4px;
}
 .navbar {
      margin-bottom: 0;
      border-radius: 0;
     font-size:13px;
     height: 40px;
    }
/* mouse over link */
a:hover {
  color: Turquoise ;
}

/* selected link */
a:active {
  color: blue;
}
    
</style>
</head>
<body>
<body style="height:450px">
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
      <a class="nav-link " href="${teachers}"><strong>CONTACT</strong></a>
    </li>
    <li class="nav-item">
        <spring:url value="/help" var="teachers"/>
      <a class="nav-link active" href="${teachers}"><strong>HELP</strong></a>
    </li>
    </ul>
</nav>

<br>
<div class="container">
	<div class="d-flex justify-content-center h-100">
		<div class="card">
			<div class="card-header">
				<h3>For Help</h3>
			</div>
			<div class="card-body">
			<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i>Email Us- </span>
							</div>
							<div class="input-group2-prepend">
						<a><span class="input-group-text">rachit.dandare@gmail.com </span></a>
						<a><span class="input-group-text"><i class="fas fa-user"></i>anjaligupta.jnp21@gmail.com </span></a>
						<a><span class="input-group-text"><i class="fas fa-user"></i>manjuldwivedi.98it@gmail.com </span></a>
						
						</div>
						
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i>Contact-</span>
						</div>
							<div class="input-group2-prepend">
						<a><span class="input-group-text">946568798</span></a>
						<a><span class="input-group-text"><i class="fas fa-user"></i>656579909 </span></a>
						</div>
						</div>
			
			</div>
		</div>
	</div>
</div>



</body>
</html>