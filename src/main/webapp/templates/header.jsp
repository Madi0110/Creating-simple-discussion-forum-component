<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <!-- CSS -->
        <style><%@ include file="../main.css" %></style>

    </head>

    <body>
        <header>
            <div class="brand">
                <span>News Website</span>
            </div>

            <ul class="header-nav">
                <li><a href="<%= request.getContextPath() %>/">Home</a></li>
                <!-- <li><a href="<%= request.getContextPath() %>/about">About</a></li>
                <li><a href="<%= request.getContextPath() %>/contacts">Contacts</a></li> -->
                <%
                    Object login = request.getSession().getAttribute("login");
                    if (login != null) {
                        out.print("<li><a href=" + request.getContextPath() + "/logout>Logout</a></li>\n");
                        out.print("<li><a href=" + request.getContextPath() + "/add-news>Add News</a></li>");
                    }
                    else {
                        out.print("<li><a href=" + request.getContextPath() + "/login>Login</a></li>\n");
                        out.print("<li><a href=" + request.getContextPath() + "/register>Register</a></li>");
                    }
                %>
            </ul>
        </header>