<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<h1 style="color:red;text-align:center">Home page </h1>
   <a href="countries">get All countries</a>
   
   <hr>
     <form action="first" method="POST">
        <input type="submit" value="submit">  <!-- POST mode request -->
     </form>
     <br>
     <a href="first">go</a>   <!-- GET mode request -->
   