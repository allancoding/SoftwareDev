<?php

$name = $_POST['name'];
$email = $_POST['email'];
$feedback = $_POST['feedback'];

$file = 'feedback.txt';
$entry = date('Y-m-d H:i:s') . " - Name: " . $name . " - Email: " . $email . " - " . "Feedback: " . $feedback . "\n---\n";
file_put_contents($file, $entry, FILE_APPEND);

?>

<!DOCTYPE html>
<html>
<head>
    <title>Bob's Auto Parts - Feedback Submitted</title>
</head>
<body>

<h1>Feedback submitted</h1>
<p>Your feedback has been sent.</p>

</body>
</html>
