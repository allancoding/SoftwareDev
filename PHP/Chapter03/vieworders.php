<!DOCTYPE html>
<html>
<head>
	<title>Bob's Auto Parts</title>
</head>
<body>
	<h1>Bob's Auto Parts</h1>
	<h2>Customer Orders</h2>
	<?php 
	$orders = file("C:\\xampp\\htdocs\\phpandmysql\\Chapter02\\orders\\orders.txt");
	
	$number_of_orders = count($orders);
	if($number_of_orders == 0){
	    echo '<p><strong>No orders pending.<br />
                        Please try again later.</strong></p>';
	    exit();
	}
	
	for($count = 0; $count < $number_of_orders; $count++){
	    echo $orders[$count] ."<br />";
	}
	
	?>
</body>
</html>