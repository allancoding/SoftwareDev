<!DOCTYPE html>
<html>
<head>
	<title>Site Submission Results</title>
</head>
<body>
	<h1>Site Submission Results</h1>

<?php

$url = $_POST['url'];
$email = $_POST['email'];

$url = parse_url($url);
$host = $url['host'];

if (!($ip = gethostbyname($host))) {
	echo "Host for URL does not have valid IP address.";
	exit();
}

echo 'Host ('.$host.') is at IP '.$ip.'<br/>';

$email = explode('@', $email);
$emailhost = $email[1];

if (!getmxrr($emailhost, $mxhostsarr)){
	echo 'Email address is not a valid host.';
	exit();
}

echo "Email is delivered via: <br />
<ul>";

foreach ($mxhostsarr as $mx) {
	echo "<li>" . $mx. "</li>";
}

echo "</ul>";

echo "<p>All submitted details are ok.</p>";
echo "<p>Thank you for submitting your site.
		It will be visited by one of our staff members soon.</p>";
?>
</body>
</html>