<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bob's Auto Parts - Freight Costs</title>
</head>
<body>
<table>
    <tr>
        <td style="background: #cccccc; text-align: center;">Distance</td>
        <td style="background: #cccccc; text-align: center;">Cost</td>
    </tr>
	<?php
	$distance = 50;
	while ($distance <= 250) {
		echo "<tr>
                <td style=\"text-align: center\">" . $distance . "</td>
                <td style=\"text-align: center\">" . ($distance / 10) . "</td>
              </tr>\n";
		$distance += 50;
	}
	?>
</table>
</body>
</html>