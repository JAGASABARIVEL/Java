<%@page import="java.util.List"%>
<%@page import="com.entity.Student"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="./searchStudents" method="post">
		<input type="text" name="name" /> <input type="submit" value="Submit" />
	</form>
	<%
	if (request.getParameter("name") == null) {
		session.setAttribute("hide", "display:none");
	}
	else{
		session.setAttribute("hide", "display:block");
	}
	
	%>
	<table style="<%= session.getAttribute("hide") %>">
		<tr>
			<th>Name</th>
			<th>Class Name</th>
			<th>Subject Name</th>
			<th>Teacher Name</th>
		</tr>

		<%
		List<Student> students = (List<Student>) session.getAttribute("students");
		
		for (Student student : students) {
			int lengthOfSubject = student.getClasses().getSubjects().size();
		%>
		<tr>
			<td><%=student.getStname()%></td>
			<td><%=student.getClasses().getCname()%></td>
			<%
			for (int index = 0; index < lengthOfSubject; index++) {
			%>
			<td><%=student.getClasses().getSubjects().get(index).getSname()%></td>
			<td><%=student.getClasses().getSubjects().get(index).getTeacher().getTname()%></td>
			<%
			}
			%>

		</tr>

		<%
		}		
		%>

	</table>

</body>
</html>