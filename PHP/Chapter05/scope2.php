<?php
function fun() {
  global $var;
  $var = 'contents';
  echo 'inside the function, $var = '.$var.'<br />';
}

fun();
echo 'outside the function, $var = '.$var;
?>