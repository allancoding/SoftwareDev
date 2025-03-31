<?php
$a = 56;
echo $a . "<br/>";
echo gettype($a) . "<br/>";
settype($a, "float");
echo $a . "<br/>";
echo gettype($a) . "<br/>";
?>