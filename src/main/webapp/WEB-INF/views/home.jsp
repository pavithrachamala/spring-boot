<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<header role = "banner"> 
         <h1>SPI banking application</h1> 
      </header>
 
      <nav> 
         <ul> 
           
  			 <sec:authorize access="hasAnyRole('ADMIN')">
  			 	 <li><a href = "usermgt">user mgt</a></li> 
  			 </sec:authorize>
           
            <sec:authorize access="hasAnyRole('ADMIN','MGR')">
            	<li><a href = "customermgt">customer mgt</a></li> 
 		    </sec:authorize>
            <sec:authorize access="hasAnyRole('ADMIN','MGR','CLERK')">
            	<li><a href = "accountmgt"> account mgt</a></li> 
            </sec:authorize>
            <li><a href = "logout">logout</a></li> 
         </ul> 
      </nav> 
   
      <article> 
         <section> 
            <p>SPI bank gives power to your dream</p>
         </section> 
      </article>  
   <footer> 
         <p>Created by <a href = "https://www.hcltech.com/">HCL Tech</a></p> 
   

 </body>
</html>