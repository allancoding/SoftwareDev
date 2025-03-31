<?php
$folder = "pictures/";
$picture = array(
    $folder."brakes.png",
    $folder."headlight.png",
    $folder."steering_wheel.png",
    $folder."tire.png",
    $folder."wiper_blade.png"
);

shuffle($picture);

?>
<!DOCTYPE html>
<html>
<head>
	<title>Bob's Auto Parts</title>
</head>
<body>
	<h1>Bob's Auto Parts</h1>
	<div align="center">
	<table style="width: 100%; border: 0;">
		<tr>
			<?php 
			for($count=0; $count < 3; $count++){
			    echo "<td style=\"width: 33%; text-align: center\">";
			    echo "<img src=\"";
			    echo $picture[$count];
			    echo "\" /></td>";
			}
			?>
		</tr>
	</table>
	</div>
</body>
</html>