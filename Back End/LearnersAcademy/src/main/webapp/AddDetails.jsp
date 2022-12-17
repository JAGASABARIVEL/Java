<%@page import="com.entity.MamRegistration"%>
<%@page import="com.entity.ClassRegistration"%>
<%@page import="com.entity.SubjectRegistration"%>
<%@page import="com.entity.StudentRegistration"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    
    <form action="./addDetails" method="post">
        <table>
           
            
            
            
             <tr>
             <td>
                 <h6>Subject Name : </h6>
             </td>
                <td>
                    <br>
                    <select name="subject">
                        <% 
                        List<SubjectRegistration> sul = (List<SubjectRegistration>) session.getAttribute("subjectlist");
                        for (SubjectRegistration sr : sul){
                    %>
                        <option value="<%= sr.getName() %>"><%= sr.getName() %></option>
                    <%}%>
                    </select>
                </td>
                <td>
                    <form action="./addSubject" method="post">
                        <input type="submit" value="Add Subject"/>
                    </form>
                </td>
                
            </tr>
            
            <tr>
            <td>
                 <h6>Teacher Name : </h6>
             </td>
                <td>
                <br>
                <select name="teacher">
                    <% 
                        List<MamRegistration> tl = (List<MamRegistration>) session.getAttribute("teacherlist");
                        for (MamRegistration sr : tl){
                    %>
                        <option value="<%= sr.getName() %>"><%= sr.getName() %></option>
                    <%}%>
                    </select>
                </td>
                <td>
                    <form action="./addTeacher" method="post">
                        <input type="submit" value="Add Teacher"/>
                    </form>
                </td>
            </tr>
            
            <tr>
            <td>
                 <h6>Class Name : </h6>
             </td>
                <td>
                    <br>
                    <select name="class">
                        <% 
                        List<ClassRegistration> cl = (List<ClassRegistration>) session.getAttribute("classlist");
                        for (ClassRegistration sr : cl){
                    %>
                        <option value="<%= sr.getName() %>"><%= sr.getName() %></option>
                    <%}%>
                    </select>
                </td>
                <td>
                    <form action="./addClass" method="post">
                        <input type="submit" value="Add Class"/>
                    </form>
                </td>
            </tr>
            
            <tr>
            <td>
                 <h6>Student Name : </h6>
             </td>
                <td>
                    <br>
                    <select name="student">
                    <% 
                        List<StudentRegistration> sl = (List<StudentRegistration>) session.getAttribute("studentlist");
                        for (StudentRegistration sr : sl){
                    %>
                        <option value="<%= sr.getName() %>"><%= sr.getName() %></option>
                    <%}%>
                    </select>
                </td>
                <td>
                    <form action="./addStudent" method="post">
                        <input type="submit" value="Add Student"/>
                    </form>
                </td>
            </tr>
            
            <tr>
                <td>
                    <input type="submit" value="Submit"/>
                </td>
            </tr>
            </table>
            </form>
        
        
        
        
        
</body>
</html>