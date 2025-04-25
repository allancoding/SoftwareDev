<!DOCTYPE html>
<html>
<head>
   <title>Stock Quote From NASDAQ</title>
</head>
<body>

<?php
$symbol = 'GOOG';
echo '<h1>Stock Quote for '.$symbol.'</h1>';

$url = 'https://www.google.com';

if (!($contents = file_get_contents($url))) {
    die('Failed to open '.$url);
}

list($symbol, $quote, $date, $time) = explode(',', $contents);
$date = trim($date, '"');
$time = trim($time, '"');

echo '<p>'.$symbol.' was last sold at: $'.$quote.'</p>';
echo '<p>Quote current as of '.$date.' at '.$time.'</p>';

echo '<p>This information retrieved from <br /><a href="'.$url.'">'.$url.'</a>.</p>';

?>
</body>
</html>