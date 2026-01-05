<html>
<body>
<h2>Welcome To My School</h2>
<form action="getall">
<input type="submit" value="Get All">
</form>
<form action="register.jsp">
<input type="submit" value="Add User">
</form>
<form action="getall" method="get">
    <input type="hidden" name="sort" value="name">
    <input type="submit" value="Sort By Name">
</form>
<form action="getall" method="get">
    <input type="hidden" name="sort" value="age">
    <input type="submit" value="Sort By Age">
</form>
</body>
</html>
