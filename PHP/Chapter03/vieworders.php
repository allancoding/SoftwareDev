<?php
$document_root = $_SERVER['DOCUMENT_ROOT'];
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bob's Auto Parts - Customer Orders</title>
</head>
<body>
<h1>Bob's Auto Parts</h1>
<h2>Customer Orders</h2>
<?php
$orders = file("orders.txt");
$number_of_orders = count($orders);

if ($number_of_orders == 0) {
	echo "<p><strong>No orders pending.<br />Please try again later.</strong></p>";
}

for ($i = 0; $i < $number_of_orders; $i++) {
	echo $orders[$i] . "<br/>";
}

?>

</body>
</html>