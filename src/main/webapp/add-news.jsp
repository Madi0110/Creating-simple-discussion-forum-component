<%@ include file="templates/header.jsp" %>
<div class="wrapper">
    <h1 class="text-center">Add News</h1>
    <form class="text-center" action="" method="post">
        <input type="text" name="title" placeholder="Title" /><br />
        <textarea name="body" placeholder="Body"></textarea><br />
        <input type="submit" name="submit" value="Submit" />
    </form>
</div>
<%@ include file="templates/footer.jsp" %>