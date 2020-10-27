
<%@taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%>
<head>
   <title><tiles:insertAttribute name="title"/> </title>
</head>
<table width="100%" height="100%"  border="0">
   <tr height="15%" bgcolor="orange">
     <td colspan="2"> <tiles:insertAttribute name="header"/> </td>
   </tr>
   <tr height="70%" bgcolor="pink">
     <td width="20%"  bgcolor="cyan"> <tiles:insertAttribute name="menu"/> </td>
     <td width="70%"> <tiles:insertAttribute name="body"/> </td>
   </tr>
   <tr height="15%"  bgcolor="yellow">
     <td colspan="2"> <tiles:insertAttribute name="footer"/> </td>
   </tr>
</table>