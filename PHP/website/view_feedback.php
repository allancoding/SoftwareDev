<?php
$file = 'feedback.txt';
$feedbackEntries = file_exists($file) ? file($file, FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES) : [];
?>

<!DOCTYPE html>
<html>
<head>
    <title>View Feedback</title>
    <style>
        select {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
        }
        .feedback-box {
            border: 1px solid #ddd;
            padding: 10px;
            background: #f9f9f9;
            margin-top: 10px;
            white-space: pre-wrap;
        }
    </style>
    <script>
        function showFeedback() {
            var feedback = document.getElementById("feedbackDropdown").value;
            if (feedback) {
                var parts = feedback.split(" - ");
                var formattedText = "Date: " + parts[0] + "\nName: " + parts[1] + "\nEmail: " + parts[2] + "\n\n" + parts.slice(3).join(" - ");
                document.getElementById("feedbackDisplay").innerText = formattedText;
            } else {
                document.getElementById("feedbackDisplay").innerText = "";
            }
        }
    </script>
</head>
<body>

<h1>View Feedback</h1>

<?php if (!empty($feedbackEntries)): ?>
    <label for="feedbackDropdown">Select feedback:</label>
    <select id="feedbackDropdown" onchange="showFeedback()">
        <option value="">-- Choose Feedback --</option>
        <?php foreach ($feedbackEntries as $entry): 
            $parts = explode(" - ", $entry);
            if (count($parts) >= 3): ?>
                <option value="<?php echo htmlspecialchars($entry); ?>">
                    <?php echo $parts[0] . " | " . $parts[1] . " | " . $parts[2]; ?>
                </option>
            <?php endif; ?>
        <?php endforeach; ?>
    </select>

    <pre class="feedback-box" id="feedbackDisplay"></pre>

<?php else: ?>
    <p>No feedback available.</p>
<?php endif; ?>

</body>
</html>
