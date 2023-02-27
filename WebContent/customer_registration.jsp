<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Registration Page</title>
</head>
<body>
<h1>Customer Registration Page</h1>

<form action ="regCustomer" method= "post">

	<label for="tbName">Name : </label><input type ="text" name="tbName" id = "tbName"/><br>
	
	<label for="tbEmail">Email :</label><input type ="email" name="tbEmail" id = "tbEmail"/><br>
	
	<label for="tbMobile">Mobile No: </label><input type ="tel" name="tbMobile" id = "tbMobile"/><br>
	
	<label for="tbPass">Password : </label><input type ="password" name="tbPass" id = "tbPass"/><br>
	
	
	<label for="ddlState">State :</label>
		<select name ="ddlStates">
			<option value="">---Select---</option>
			<option value="Karnataka">KA</option>
			<option value="Tamil Nadu">TN</option>
			<option value="Andhra Pradesh">AP</option>
			<option value="Kerala">KL</option>
		</select><br>
	
	  
	<input type="submit" value = "Register"/>
	
</form>

</body>
</html>