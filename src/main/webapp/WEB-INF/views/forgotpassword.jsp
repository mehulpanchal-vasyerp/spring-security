<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/style.css">
    <title>Forgot Password</title>
</head>
<body>
<div class="container">


    <h2>Your Registered Email </h2>

    <form action="/sendotp" method="post">
    <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
         <button>Send OTP</button>
     
    
        
       
    </form>
</div>

</body>
</html>
