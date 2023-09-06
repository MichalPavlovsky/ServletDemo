<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>


<html>
<body>
<h2>Hello Worrrrrrld! <%= new Date()%></h2>

<% int j =458;
    int k =60;
    int l = j+k;

%>

Hodnota je <%=l%><br>

<%
   for(int i =0; i<10; i++) {
   %>
        <p><%=i%></p>
        <%
        }
        %>

<%!
public int spocitaj(int a, int b) {
     return a+b;
     }
     %>
<p> Spocitaj a + b = <%=spocitaj(10,5)%> </p>


<%@include file= "/footer.jsp"%>
</body>
</html>
