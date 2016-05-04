
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Names</title>
    </head>
    <body>
        <h1>Names</h1>
        <ul>
         <c:forEach var="name" items="${sessionScope.names}">
              <li> 
                <h3>${name} <a href="delete?name=${name}">Remove</a> </h3>
              </li>
              
         </c:forEach>
        </ul>
        
        <form action="add" method="post">
             <input type="text" name="name" required="required" />
             <input type="submit" value="Add Name" />
        </form>
        <p/>
        <a href="clear">Clear All Names</a>
    </body>
</html>
