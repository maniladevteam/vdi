<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<title>Login Page</title>

</head>
<body>

<form method="post" action="j_security_check">
    <table>
    <tr><td>Username:</td><td><input type="text" name="j_username" /></td></tr>
    <tr><td>Password:</td><td><input type="password" name="j_password" /></td></tr>
    <tr><td><input type="submit" value="Login" /></td></tr>
    </table>
</form>
</body>
</html>