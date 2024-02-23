<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/style.css">
    <title>User Registration</title>
</head>
<body>
<div class="container">


    <h2>Login</h2>

    <form action="/auth" method="post">
    
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
         <a href="/forgotpassword" class="forgot-password">Forgot Password</a> </br>
        
         


        <input type="submit" value="Login">
        <button><a href="/register">Registration</a></button>
       
         
       
    </form>
</div>

</body>
</html>
