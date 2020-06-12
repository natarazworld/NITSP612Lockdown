<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
  
  <h1 style="color:red;text-align:center">Result page </h1>
  
  <c:choose>
    <c:when test="${!empty listEmps }">
      <table border="1" align="center" bgcolor="pink">
         <tr bgcolor="blue"> <th>EMPNO</th> <th>ENAME</th> <th>JOB</th> <th>SALARY</th> <th>DEPTNO</th> </tr>
      
       <c:forEach var="emp" items="${listEmps}">
         <tr bgcolor="green" bordercolor="yellow">
          <td>${emp.EMPNO} </td>
          <td>${emp.ENAME} </td>
          <td>${emp.JOB} </td>
          <td>${emp.SAL} </td>
          <td>${emp.DEPTNO} </td>
         </tr>
       
       </c:forEach>
      
      </table>
     </c:when>
     <c:otherwise>
         <h1 style="color:red">Employees not found</h1>
     </c:otherwise>
  
  </c:choose>
  <br> <br>
  <p align="center"><a href="main.html">home</a> </p>
  
  
  
    
