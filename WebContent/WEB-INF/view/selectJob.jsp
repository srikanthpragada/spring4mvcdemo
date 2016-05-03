<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Jobs</title>
</head>
<body>
  <h1>Add Job</h1>
  
  <sf:form commandName="job" action="processJob">
    Select Job : 
       <sf:select path="id" items="${jobs}"  itemLabel="title" itemValue="id" >
       </sf:select>
       <p/>
       <input type="submit" value="Submit" />
  </sf:form>
         
   
   

</body>
</html>