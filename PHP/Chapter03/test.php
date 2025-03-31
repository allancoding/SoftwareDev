<?php

$prices['Tires'] = 100;
$prices['Oils'] = 10;
$prices['Spark Plugs'] = 4;

// using foreach() loop
echo "<p><strong>Using a foreach() loop.</strong><br/>";
foreach ($prices as $key => $value){
    echo $key . " - " . $value . "<br />";
}
echo "</p>";

echo "<p><strong>Using a while() loop and each() function.</strong><br/>";

// using while loop and each construct
while ($element = each($prices)){
    echo $element['key'] . " - " . $element['value'] . "<br />";
}

echo "</p>";

echo "<p><strong>Using a while() loop, a list() construct and each() function.</strong><br/>";

reset($prices); // resetting the last access element of the array from the each() function.
while(list($product, $price) = each($prices)){
    echo $product . " - " . $price . "<br />";
}
echo "</p>";

?>