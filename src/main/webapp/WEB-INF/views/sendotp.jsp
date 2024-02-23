<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="/style.css">
<meta charset="ISO-8859-1">
<title>sendotp</title>
</head>
<body>
<div class="container">
<div class="alert alert-success" role="alert">

   <h2>We have sent OTP to your email</h2>

    <form action="/sendotp" method="post">
    <label for="email">Enter OTP Here</label>
        <input type="email" id="email" name="email" required></form></br>
        <div class="btn">
         <button  >verify</button>
        </div>
    </div> 
</div>
</body>
</html>