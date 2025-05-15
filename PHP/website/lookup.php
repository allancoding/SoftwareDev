<?php
$url = "https://jsonplaceholder.typicode.com/todos/1";

$response = file_get_contents($url);

$data = json_decode($response, true);

if ($data) {
    echo "<h1>JSON Data Retrieved</h1>";
    echo "<table border='1'>";
    foreach ($data as $key => $value) {
        echo "<tr>";
        echo "<th>" . htmlspecialchars($key) . "</th>";
        echo "<td>" . htmlspecialchars($value) . "</td>";
        echo "</tr>";
    }
    echo "</table>";
} else {
    echo "<p>Failed to retrieve or decode JSON data.</p>";
}
?>