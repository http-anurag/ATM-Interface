<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ATM Interface</title>
    <style>
    /* Reset some default styles for consistency */
body, h1, form, label, input, select {
    margin: 0;
    margin-top:20px;
     
    padding: 0;
    paddind-left:3px;
    font-family: Arial, sans-serif;
}

body {
background-color:green;
    
    text-align: center;
    padding: 20px;
}

h1 {
    font-size: 24px;
    margin-bottom: 20px;
}

form {
    max-width: 400px;
    margin: 0 auto;
    background-color: #fff;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

label {
    display: block;
    font-weight: bold;
    margin-bottom: 10px;
}

input[type="text"],
input[type="password"],
select {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 16px;
}

input[type="submit"] {
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 5px;
    padding: 10px 20px;
    font-size: 18px;
    cursor: pointer;
}

input[type="submit"]:hover {
    margin-left:12px;
    background-color: #0056b3;
}

/* Style for form elements when they are in focus */
input[type="text"]:focus,
input[type="password"]:focus,
select:focus {
    outline: none;
    border-color: #007bff;
    box-shadow: 0
    
    </style>
</head>
<body>
    <h1>ATM Interface</h1>

    <form action="ATMServlet" method="post">
        <label for="userID">User ID:</label>
        <input type="text" id="userID" name="userID" required><br>

        <label for="pin">PIN:</label>
        <input type="password" id="pin" name="pin" required><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
