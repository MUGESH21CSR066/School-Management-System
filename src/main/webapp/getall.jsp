<%@ page import="java.util.List" %>
<%@ page import="Student.Student" %>
<html>
<body>
<h2>Student Details</h2>
<table border="1" bordercolor="black" cellpadding="10" cellspacing="0" >
<thead>
<tr>
<th>Id</th>
<th>Name</th>
<th>Age</th>
<th>Action</th>
</tr>
</thead>
<tbody>
<%
    List<Student> studentList = (List<Student>) request.getAttribute("studentList");

    if (studentList != null) {
        for (Student student : studentList) {
%>
        <tr>
            <td><%= student.getId() %></td>
            <td><%= student.getName() %></td>
            <td><%= student.getAge() %></td>
            <td>
                <a href="edit.jsp">Edit</a> |
                <a href="delete.jsp">Delete</a>
            </td>
        </tr>
<%
        }
    }
%>
</tbody>


</table>
</body>
</html>
