<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/style.css">
<title>User Registration</title>
</head>
<body>

	<div class= "container">
		<h2>Registration</h2>

		<form action="/addUser-page" method="post">

			<label for="username">Username:</label> <input type="text"
				id="username" name="username" required> <label
				for="password">Password:</label> <input type="password"
				id="password" name="password" required> <label for="name">Name:</label>
			<input type="text" id="name" name="name" required> <label
				for="email">Email:</label> <input type="email" id="email"
				name="email" required>
			<div>
				<label>Role:</label> <input type="radio" id="admin" name="role"
					value="ROLE_ADMIN"> <label for="admin">Admin</label> <input
					type="radio" id="user" name="role" value="ROLE_USER" checked>
				<label for="user">User</label><br>
			</div>

			
	<input type="submit" value="Register">
	<button><a href="/login">Login</a></button>

		</form>
	</div>

</body>
</html>
