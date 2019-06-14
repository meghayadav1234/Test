<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/js/Home.js" />
<form action='' method='post'>
	<div id="search-form">
		<input type="text" name="search" class="search-field" id="search"
			value="" />
		<div class="submit-container">
			<button type="button" value="" class="submit" id="searchbutton"
				onclick="login()" /></button>
		</div>
	</div>
	
</form>
<br>
<br>
<p>Type First Name</p>
 --%>
 
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Welcome</title>
    </head>
    <body>
        <table>
            <tr>
                <td>Welcome ${firstname}</td>
            </tr>
            <tr>
            </tr>
            <tr>
            </tr>
            <tr>
                <td><a href="HomePage.jsp">Home</a>
                </td>
            </tr>
        </table>
    </body>
    </html>











<%--  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
 

    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Welcome</title>
        <!-- <script type="text/javascript" src="Home.js"></script> -->
         <link rel="stylesheet" href="<%=request.getContextPath()%>/js/Home.js"/>
    </head>
    <body>
        <table align="center">
            <tr>
                <td>
                <!-- <a href="login">Login</a> -->
                  <th>
                 <!--  <input type="button"  onclick="alert('hello')"value="Login" > -->
                <button type="button" onclick="login(); return false;">Go</button>
                  
                <!--   <input type="submit" value="Submit" name="button" /></th>  -->
                </td>
                <td><a href="register">Register</a>
                </td>
            </tr>
        </table>
    </body>
    </html>   --%>
<%--     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="<c:url value="/WEB-INF/resources/js/Home.js" />"></script>
</head>
<body>
<button onclick="login()">Click here...</button>
</body>
</html> --%>

<%-- 
    <%@ page contentType = "text/html; charset = UTF-8" %>
<html>
   <head>
      <title>Hello World</title>
   </head>
   
   <body>
      <h2>hhhhhhhhhhhh</h2>
   </body>
</html> --%>