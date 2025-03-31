<?php

$products = array(array('TIR', 'Tires', 100),
                  array('OIL', 'Oil', 10),
                  array('SPK', 'Spark Plugs', 4));
array_multisort($products);
print($products);
?>