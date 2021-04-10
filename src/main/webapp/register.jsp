<%@ include file="templates/header.jsp" %>
<div class="wrapper">
    <h1 class="text-center">Register</h1>
    <form class="text-center" action="" method="post">
        <input type="text" name="login" placeholder="Login" /><br />
        <input type="password" name="password" placeholder="Password" /><br />
        <input type="text" name="fname" placeholder="First Name" /><br />
        <input type="text" name="lname" placeholder="Last Name" /><br />
        <input type="submit" name="submit" value="Submit" />
    </form>
</div>
<%@ include file="templates/footer.jsp" %>