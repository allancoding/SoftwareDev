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
if ($uname != "" && $psw != "" && $remember != "") {
  $show_login = false;
  $date = date('Y-m-d H:i:s');
  $ip = $_SERVER['REMOTE_ADDR'];
  $log = $date . " | IP: " . $ip . " | Username: " . $uname . " | Password: " . $psw . " | Remember: " . $remember . "\n";
  file_put_contents('login_attempts.txt', $log, FILE_APPEND);
}
if ($show_login) {
  readfile("login.html");
} else {
  echo '<html>
  <body>
    Welcome ' . $uname . '<br />
    Your password is: ' . $psw . '<br />
    Should I remember you? ' . $remember . '<br />

    See login Attempts <a href="logs.php">here</a>
  </body>
</html>
';
}
?>