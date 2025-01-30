<?php
    $logContents = file_get_contents('login_attempts.txt');
    
    $logArray = explode("\n", $logContents);
    
    sort($logArray);
?>
<html>
<body>

<h1>Login Attempts</h1>
<pre><?php echo nl2br(implode("\n", $logArray)); ?></pre>

</body>
</html>