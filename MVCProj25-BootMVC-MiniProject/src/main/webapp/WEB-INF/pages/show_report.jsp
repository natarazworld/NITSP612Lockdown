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
             <tr class="text-primary">
               <th>SerialNo </th>
               <th>EmpNo </th>
               <th>EmpName </th>
               <th>Desg </th>
               <th>Salary </th>
               <th>GrorssSalary </th>
               <th>NetSalary </th>
               <th>DeptNo </th>
               <th>Operations </th>
              </tr>
              <c:forEach  var="dto"  items="${empsInfo}">
                   <tr class="text-primary" >
                      <td>${dto.serialNo}  </td>
                      <td>${dto.empNo}  </td>
                      <td>${dto.ename}  </td>
                      <td>${dto.job}  </td>
                      <td>${dto.sal}  </td>
                      <td>${dto.grossSalary}  </td>
                      <td>${dto.netSalary}  </td>
                      <td>${dto.deptNo}  </td>
                      
                      <td>
                          <a href="editEmp.htm?empNo=${dto.empNo}"><img src="images/edit1.png" width="50" height="50"/></a>
                          <a href="deleteEmp.htm?eno=${dto.empNo}"  onclick="confirm('are u sure delete ${dto.ename}')"><img src="images/delete1.jpg" width="50" height="50"/></a>
                        </td>
                      
                   </tr>
              </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
         <h1 >Records not found</h1>
    </c:otherwise>
</c:choose>
 <br><br>
  <c:if test="${resultMsg ne null && !empty resultMsg}">
   <marquee direction="right"><h1 class="text-primary font-weight-bold">${resultMsg}</h1> </marquee>
   </c:if>
   
<h2><a href="saveEmp.htm"><img src="images/add1.jpg" width="100" height="100"/></a> 
    &nbsp; &nbsp;<a href="welcome.htm"><img src="images/home.gif" width="100" height="100"/></a>
    &nbsp; &nbsp;<a  href="JavaScript:doPrint()"><img src="images/print1.jpg" width="100" height="100"></a>
</h2>
      
</div>
 <script language="JavaScript">
      function doPrint(){
    	  frames.focus();
    	  frames.print();
      }
 </script>

  


