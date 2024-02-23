<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>s
</head>
<body>
	<h1>Welcome to AdminPage</h1>


	<a href="/logout"><button>Logout</button></a>
	<script>
		var token = '${token}';

		$(document).ready(
				function() {
					$.ajax({
						type : 'GET',
						url : 'http://localhost:8080/admin',
						beforeSend : function(request) {
							request.setRequestHeader('Authorization', 'Bearer '
									+ token);
						},
						success : function(data) {
						},
						error : function(xhr, textStatus, errorThrown) {
						}
					});
				});
	</script>
</body>
</html>

