<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<h1 style="color:blue;text-align:center"> show All files  to download </h1>

 <c:choose>
    <c:when test="${filesList ne null && !empty filesList  }">
        <table align="center"  bgcolor="pink">
         <c:forEach var="fileName"  items="${filesList}">
               <tr>
                 <td>${fileName} </td>
                 <td><a href="download?fname=${fileName}">download</a> </td>
               </tr>
         </c:forEach>
         </table>
    </c:when>
    <c:otherwise>
           <h1 style="color:red;text-align:center"> No files found to download </h1>
    </c:otherwise>
 </c:choose>
    
