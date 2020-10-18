<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm" %>


<h1 style="color:red;text-align:center"> file Uploading page </h1>

<frm:form  modelAttribute="jsFrm" enctype="multipart/form-data">
    <table  align="center"  bgcolor="cyan">
        <tr>
          <td> Jobseeker name :: </td>
          <td> <frm:input path="jsName"/> </td>
        </tr>
        <tr>
          <td> Jobseeker address :: </td>
          <td> <frm:input path="jsAddrs"/> </td>
        </tr>
        <tr>
          <td> Jobseeker Resume  :: </td>
          <td> <input type="file"  name="resume"> </td>
        </tr>
        <tr>
          <td> Jobseeker photo  :: </td>
          <td> <input type="file"  name="photo"> </td>
        </tr>
        <tr>
          <td> <input type="submit" value="upload"> </td>
          <td>  <input type="reset" value="cancel"></td>
        </tr>
    </table>
</frm:form>

