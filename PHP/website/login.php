<?php
    $uname = $_POST["uname"];
    $psw = $_POST["psw"];
    $remember = $_POST["remember"];
    if ($_POST["remember"] == "on") {
        $remember = "Yes";
    } else {
        $remember = "No";
    }
    if ($uname != "" && $psw != "" && $remember != ""){   
        $log = "Username: " . $uname . ", Password: " . $psw . ", Remember: " . $remember . "\n";
        file_put_contents('login_attempts.txt', $log, FILE_APPEND);
    }
?>
<html>
<body>

Welcome <?php echo $uname; ?><br>
Your password is: <?php echo $psw; ?><br>
Should I remember you? <?php echo $remember; ?><br>

See login Attempts <a href="logs.php">here</a>
</body>
</html>