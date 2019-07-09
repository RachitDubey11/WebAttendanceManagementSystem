<%@ include file="/WEB-INF/views/includes.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>kkkk title here</title>
<style>
.bb{
margin-top: 90%;
margin-left: 5%;
}
</style>
</head>
<body>
	Dear <strong>${user}</strong>, Welcome to Teachers Page.


<c:url var="action" value="/attendance/find"></c:url>
<form:form action="${action}" method="POST" modelAttribute="attendance">
  <table style="width: 100%; height: 100%">         
			 <tr>
		         <td>Date:</td>
				 <td><form:input path="aDate" value="${date}"/></td>
										<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
			
		</tr>
			<tr>
		<td colspan="2"><input type="submit" value="Search Subject" /></td>
		</tr>
		
		            <tr style="height: 90%">
                <td>
                    <iframe src="" name="WORK" style="width: 100%; height: 100%" frameborder="0"></iframe>
                </td>
            </tr>
	</table>
</form:form> 



<table>
<tr>
  <td>Teacher's Name:</td>
  <td>${userName}</td>
</tr>
</table>

<table border="2">
<tr>
<th>Semester</th>
<th>Department</th>
<th>Subject</th>
<th>Delete</th>
</tr>

	<c:forEach items="${teachersemdeptsubjectList}" var="teachersemdeptsubject">
	<tr>
 	<td><c:out value="${teachersemdeptsubject.semName }"/></td>
 	<td><c:out value="${teachersemdeptsubject.dept }"/></td>
	<td><c:out value="${teachersemdeptsubject.subjectName}"/></td> 
	 <td><a href="<c:url value='/teachersemdeptsubject/delete/${teachersemdeptsubject.id}/${idTeacher}'/>">Delete</a></td> 
	</tr>
	</c:forEach>
	
   <tr>
            	 <td>   <a href="<c:url value='/teachersemdeptsubject/register/${idTeacher}'/>">Add Row</a></td>
            </tr>
                        	<a href="<c:url value="/logout" />">Logout</a>
            
</table>
</body>
</html>


