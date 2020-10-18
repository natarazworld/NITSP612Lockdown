<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm" %>

<h1 style="color:red;text-align:center"> PErson Registration page </h1>

<frm:form  modelAttribute="perFrm">
  <p style="color:red">
    <frm:errors path="*"/>
   </p>
  <table align="center"  bgcolor="cyan">
     <tr>
        <td>Person name  </td>
        <td><frm:input path="name"/> </td>
     </tr>
     <tr>
        <td>Person addrs  </td>
        <td><frm:input path="addrs"/> </td>
     </tr>
     <tr>
        <td>Person mobileNo  </td>
        <td><frm:input path="mobileNo"/> </td>
     </tr>
     <tr>
        <td>Person gender  </td>
        <td>
            <frm:radiobuttons path="gender" items="${genderList}"/>
         </td>
     </tr>
     <tr>
        <td>hobies </td>
        <td><frm:checkboxes path="hobies"  items="${hobiesList}" /></td>
     </tr>
     <tr>
        <td>Qualification  </td>
        <td>
          <frm:select path="qlfy">
               <frm:options items="${qlfyList}"/>
           </frm:select>
         </td>
     </tr>
     <tr>
        <td>favorite color:: </td>
        <td>
             <frm:select path="colors" multiple="multiple">
                 <frm:options items="${colorsList}"/>
             </frm:select>
        </td>
     </tr>
      <tr>
        <td>DOB (dd-MM-yyyy)  </td>
        <td><frm:input type="date"  path="dob"/> </td>
     </tr>
     <tr>
        <td>DOJ (dd-MM-yyyy)  </td>
        <td><frm:input  type="date" path="doj"/> </td>
     </tr>
     <tr>
        <td>salary range  </td>
        <td><frm:input  type="range"  min="10000" max="200000"  path="salary"/> </td>
     </tr>
     
     
     <tr>
        <td colspan="2"> <input type="submit"  value="register"> </td>
     </tr>
  </table>
</frm:form>    
