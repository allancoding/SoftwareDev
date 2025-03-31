<?php
// set date for calculations
$day = 29;
$month = 11;
$year = 1989;

// format birthday as an ISO 8601 date
$bdayISO = date("c", mktime(0,0,0, $month, $day, $year));

// use mysql query to calculate an age in days
$db = mysqli_connect('localhost', 'root', '');
$res = mysqli_query($db, "SELECT datediff(now(), '$bdayISO')");
$age = mysqli_fetch_array($res);

// convert age in days to age in years (approximately)
echo 'Current age is ' .floor($age[0]/365.25). '.';
?>