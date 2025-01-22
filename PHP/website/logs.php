<?php
    // Read the file contents
    $logContents = file_get_contents('login_attempts.txt');
    
    // Split the contents into an array by new lines
    $logArray = explode("\n", $logContents);
    
    // Sort the array
    sort($logArray);
?>
<html>
<body>

<h1>Login Attempts</h1>
<pre><?php echo nl2br(implode("\n", $logArray)); ?></pre>

</body>
</html>