<?php
require_once 'file_exceptions.php';

// constant variables
define("TIREPRICE", 100);
define("OILPRICE", 10);
define("SPARKPRICE", 4);

//create short variable names
# This variables are converted into Integer from String of $_POST[] array.
$tireqty = (int) $_POST['tireqty'];
$oilqty = (int) $_POST['oilqty'];
$sparkqty = (int) $_POST['sparkqty'];

$find = $_POST['find'];
$address = preg_replace('/\t|\R/', ' ', $_POST['address']);
$document_root = $_SERVER['DOCUMENT_ROOT'];
$date = date('H:i, jS F Y');
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
    	    echo '<p style = "color: red;">';
    	    echo 'You did not order anything from the previous page! </p>';
    	    exit();
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
    	
    	if($tireqty > 0){
    	echo htmlspecialchars($tireqty) . ' tires. <br/>';
    	}
    	if($oilqty > 0){
    	echo htmlspecialchars($oilqty) . ' bottles of oil. <br/>';
    	}
    	if($sparkqty){
    	echo htmlspecialchars($sparkqty) . ' spark plugs. <br/>';
    	}
    	
    	echo "<p>";
    	echo "Items ordered: $totalqty. <br/>";

    	$totalamount = $tireqty * TIREPRICE +
    	               $oilqty * OILPRICE +
    	               $sparkqty * SPARKPRICE;
    	               
    	echo "Subtotal: $" .number_format($totalamount, 2). "<br/>";
    	
    	$taxrate = 0.10; // local sales tax is 10%
    	$totalamount = $totalamount * (1 + $taxrate);
    	echo "Total including tax:  $" . number_format($totalamount, 2) . ".<br/>";
    	
    	echo "</p>";
    	
    	if($address != null){
    	echo "Address to ship to is " . htmlspecialchars($address) . ".";
    	}
    	
    	$outputstring = $date . "\t" . $tireqty . " tires \t" . $oilqty . " oil \t" . $sparkqty . " spark plugs \t \$" . $totalamount
                        . "\t" . $address . "\n";
    	
        /** Codes from Chapter 2
        // open file for appending
        // $fp = fopen("$document_root/../orders/orders.txt", 'w+');
        $fp = fopen("C:\\xampp\\htdocs\\phpandmysql\\Chapter02\\orders\\orders.txt", 'ab');
        
        if(!$fp){
            echo "<p><strong> Your order could not be processed at this time. 
                  Please try again later.</strong></p>";
            exit();
        }
        
        flock($fp, LOCK_EX);
        fwrite($fp, $outputstring, strlen($outputstring));
        flock($fp, LOCK_UN);
        fclose($fp);
        
        echo '<p>Order written.</p>';
        **/
                        
        try
        {
            if (!($fp = @fopen("C:\\xampp\\htdocs\\phpandmysql\\Chapter02\\orders\\orders.txt", 'ab'))) {
                throw new fileOpenException();
            }
            
            if (!flock($fp, LOCK_EX)) {
                throw new fileLockException();
            }
            
            if (!fwrite($fp, $outputstring, strlen($outputstring))) {
                throw new fileWriteException();
            }
            
            flock($fp, LOCK_UN);
            fclose($fp);
            echo "<p>Order written.</p>";
        }
        catch (fileOpenException $foe)
        {
            echo "<p><strong>Orders file could not be opened.<br/>
Please contact our webmaster for help.</strong></p>";
        }
        catch (Exception $e)
        {
            echo "<p><strong>Your order could not be processed at this time.<br/>
Please try again later.</strong></p>";
        }
    	}
    	?>
    </body>
</html>