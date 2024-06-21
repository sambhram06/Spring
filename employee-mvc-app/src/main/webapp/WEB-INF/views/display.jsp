<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Employee Details Found</h2>
	<h2>Employee Name:${employee.getName() }</h2>
	<h2>Employee Phone:${employee.getPhone() }</h2>
	<h2>Employee email:${employee.getEmail() }</h2>
	<h2>Employee Id:${employee.getId() }</h2>
	<h2>Gender:${employee.getGender() }</h2>
	<h2>Designation:${employee.getDesg() }</h2>
	<h2>Salary:${employee.getSalary() }</h2>
</body>
</html>