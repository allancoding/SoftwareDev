<?php
    $logContents = file_get_contents('login_attempts.txt');
?>
<html>
<body>

<h1>Login Attempts</h1>
<pre><?php echo nl2br($logContents); ?></pre>

</body>
</html>