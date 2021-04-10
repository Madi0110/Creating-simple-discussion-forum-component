<%@ include file="templates/header.jsp" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.company.entities.NewsEntity" %>
<div class="wrapper">
    <h1 class="text-center">Home Page</h1>

    <%
    ArrayList<NewsEntity> l = (ArrayList)request.getAttribute("newsList");
    for(NewsEntity e: l) {
    %>
        <div>
            <h3><%= e.getTitle() %></h3>
            <p><%= e.getBody() %></p>
            <a href="<%= request.getContextPath() %>/view?v=<%= e.getId() %>">link</a>
            <hr>
        </div>
    <% } %>

</div>
<%@ include file="templates/footer.jsp" %>