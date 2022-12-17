<%@page import="com.entity.Student"%>
<%@page import="com.entity.Teacher"%>
<%@page import="com.entity.Subject"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.Classes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  List<Classes> classes = (List<Classes>) session.getAttribute("Classes");
    Integer sizeofclass = classes.size();
%>
<table style="font-family: arial, sans-serif; border-collapse: collapse; width: 100%;">
    <tr style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
        <td><b>Class Name</b></td>
        <td><b>Subject Details</b></td>
        <td><b>Teacher Details</b></td>
        <td><b>Student Details</b></td>
    </tr>
    
    <%
    for(int index=0; index<sizeofclass; index++){
    %>
    <tr>
    <td style="border: 1px solid #dddddd; text-align: left; padding: 8px;"><%=classes.get(index).getCname()%></td>
    <%
    List<Subject> subjects = classes.get(index).getSubjects();
    for(Subject subject : subjects){
    %>
    <td style="border: 1px solid #dddddd; text-align: left; padding: 8px;"><%= subject.getSname() %></td>
    <%}%>
    <%
    List<Teacher> teachers = classes.get(index).getTeachers();
    for(Teacher teacher : teachers){
    %>
    <td style="border: 1px solid #dddddd; text-align: left; padding: 8px;"><%= teacher.getTname() %></td>
    <%}%>
    <%
    List<Student> students = classes.get(index).getStudents();
    for(Student student : students){
    %>
    <td style="border: 1px solid #dddddd; text-align: left; padding: 8px;"><%= student.getStname() %></td>
    <%}%>
    </tr>
    <%}%>
</table>
</body>
</html>