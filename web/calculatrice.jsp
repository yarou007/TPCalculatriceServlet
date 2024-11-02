<%-- 
    Document   : calculatrice
    Created on : 2 nov. 2024, 09:18:38
    Author     : 21655
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculatrice</title>
    </head>
    <body>
        
        <% 
            if ( request.getAttribute("msg")!=null) {
                 String msgerror = (String) request.getAttribute("msg");
                 out.println(msgerror);
            }
        %>
        
       
        <form name="calcul" method="POST" action="servletcalcul">
            <input text="text" name="a" placeholder="entrer a" >
            <br>
             <select name="op">
                <option value="+" selected>+</option>   
                <option value="-">-</option>
                <option value="/">/</option>
                <option value="*">*</option>
            </select>
            
            <br>
            <input text="text" name="b" placeholder="entrer b" >
            <br>
            <input type="submit" value="Caclucler"> 
        </form>
    </body>
</html>
