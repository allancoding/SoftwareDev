<!DOCTYPE html>
<html>

<head>
	<title>Browse Directories</title>
</head>

<body>
	<h1>Browsing</h1>

	<?php
	$current_dir = '/';
	$dir = opendir($current_dir);

	echo "<p>Upload director is " . $current_dir . " </p>";
	echo "<p>Directory Listing:</p><ul>";

	while (false !== ($file = readdir($dir))) {
		if ($file != "." && $file != "..") {
			echo "<li>" . $file . "</li>";
		}
	}

	echo "</ul>";
	closedir($dir);
	?>
</body>

</html>