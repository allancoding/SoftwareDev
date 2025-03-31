<?php
// constant variables
define("TIREPRICE", 100);
define("OILPRICE", 10);
define("SPARKPRICE", 4);

//create short variable names
# This variables are converted into Integer from String of $_POST[] array.
$tireqty = (int)($_POST['tireqty']);
$oilqty = (int)($_POST['oilqty']);
$sparkqty = (int)($_POST['sparkqty']);
$find = $_POST['find'];

/** This variables are strings from the $_POST[] array.
$tireqty = $_POST['tireqty'];
$oilqty = $_POST['oilqty'];
$sparkqty = $_POST['sparkqty'];
**/
?>

<!DOCTYPE html>
<html>
    <head>
    	<title>Bob's Auto Parts - Order Results</title>
    </head>
    <body>
    	<h1>Bob's Auto Parts</h1>
    	<?php
       	$totalqty = 0;
    	$totalqty = $tireqty + $oilqty + $sparkqty;
    	
    	if($totalqty == 0){
    	    ## Checking the Variable Type
    	    echo '<p>';
    	    echo '$totalqty: ' . gettype($totalqty) . '<br/>';
    	    echo '$tireqty: ' . gettype($tireqty) . '<br/>';
    	    echo '$oilqty: ' . gettype($oilqty) . '<br/>';
    	    echo '$sparkqty: ' . gettype($sparkqty) . '<br/>';
    	    echo '</p>';
    	    echo '<p style = "color: red;">';
    	    echo 'You did not order anything from the previous page! </p>';
    	    exit;
    	}
    	else {
    	echo '<h2>Order Results</h2>';
    	echo '<p>Order processed at ' . date('H:i, jS F Y') . "</p>";
    	
    	echo '<p style="font-weight: bold;">';
    	switch ($find) {
    	    case "a":
                echo "Regular customer.";
                break;
    	    case "b":
    	        echo "Customer reffered by TV advertisement.";
    	        break;
    	    case "c":
    	        echo "Customer reffered by phone directory.";
    	        break;
    	    case "d":
    	        echo "Customer reffered by word of mouth.";
    	        break;
    	    default:
                echo "We do not know how this customer found us.";
    	    break;
    	}
    	echo '</p>';
    	
    	echo '<p>Your order is as follows: </p>';
    	# (shell script comment) This is the same output as the variable assignment.
    	echo '<strong><u>Calling the $_POST[] array</u></strong><br/>';
    	echo htmlspecialchars($_POST['tireqty']) . ' tires. <br/>';
    	echo htmlspecialchars($_POST['oilqty']) . ' bottles of oil. <br/>';
    	echo htmlspecialchars($_POST['sparkqty']) . ' spark plugs. <br/>';
        echo "<p> </p>";
    	
        echo '<strong><u>Calling the variable assignment</u></strong><br/>';
    	echo htmlspecialchars($tireqty) . ' tires. <br/>';
    	echo htmlspecialchars($oilqty) . ' bottles of oil. <br/>';
    	echo htmlspecialchars($sparkqty) . ' spark plugs. <br/>';
    	
    	$totalqty = $tireqty + $oilqty + $sparkqty;
    	echo "<p>";
    	echo "Items ordered: $totalqty. <br/>";

//    	$totalamount = 0.00;
    	$totalamount = $tireqty * TIREPRICE +
    	               $oilqty * OILPRICE +
    	               $sparkqty * SPARKPRICE;
    	               
    	echo "Subtotal: $" .number_format($totalamount, 2). "<br/>";
    	
    	$taxrate = 0.10; // local sales tax is 10%
    	$totalamount = $totalamount * (1 + $taxrate);
    	echo "Total including tax:  $" .number_format($totalamount, 2). ".<br/>";
    	
    	echo "</p>";
    	
    	# (shell script comment) Heredoc sysntax
    	echo <<<theString
    	<br/> This is
        a sample heredoc string.
        The End.
theString;
    	# Testing Variable Status
    	echo "<p>";
    	echo "<strong>Testing the Variable Status</strong> <br/>";
    	echo 'isset($tireqty): ' . isset($tireqty) . '<br/>';
    	echo 'isset($nothere): ' . isset($nothere) . '<br/>';
    	echo 'empty($tireqty): ' . empty($tireqty) . '<br/>';
    	echo 'empty($nothere): ' . empty($nothere) . '<br/>';
    	echo "</p>";
    	}
    	?>
    </body>
</html>