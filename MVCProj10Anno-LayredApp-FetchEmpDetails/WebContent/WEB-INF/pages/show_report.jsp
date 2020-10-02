<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %>

<h1 class="text-primary text-center"> Employees Info Report </h1>
<head>
   <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"  rel="stylesheet">
</head>
<div class="container">
<c:choose >
    <c:when test="${empsInfo ne null && !empty empsInfo }">
        <table class="table  table-hover table-bordered  table-stripped table-sm">
             <tr  class="text-info  bg-primary">
               <th>SerialNo </th>
               <th>EmpNo </th>
               <th>EmpName </th>
               <th>Desg </th>
               <th>Salary </th>
               <th>GrorssSalary </th>
               <th>NetSalary </th>
               <th>DeptNo </th>
              </tr>
              <c:forEach  var="dto"  items="${empsInfo}">
                   <tr  class="bg-success">
                      <td>${dto.serialNo}  </td>
                      <td>${dto.empNo}  </td>
                      <td>${dto.ename}  </td>
                      <td>${dto.job}  </td>
                      <td>${dto.sal}  </td>
                      <td>${dto.grossSalary}  </td>
                      <td>${dto.netSalary}  </td>
                      <td>${dto.deptNo}  </td>
                      
                   </tr>
              </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
         <h1 >Records not found</h1>
    </c:otherwise>
</c:choose>

<br>
 <h1><a class="text-primary  text-center" href="welcome">home</a></h1>
 <br>
 <h1><a class=" text-danger text-center" href="JavaScript:doPrint()">Print</a></h1>
 
</div>
 <script language="JavaScript">
      function doPrint(){
    	  frames.focus();
    	  frames.print();
      }
 </script>

  


