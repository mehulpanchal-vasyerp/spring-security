<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration</title>
</head>
<body>

    <h2>User Registration</h2>

    <form action="/addUser" method="post">
    
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

        <label>Role:</label>
        <input type="radio" id="admin" name="role" value="ROLE_ADMIN">
        <label for="admin">Admin</label>
        <input type="radio" id="user" name="role" value="ROLE_USER" checked>
        <label for="user">User</label><br>

        <input type="submit" value="Register">
    </form>

</body>
</html>
