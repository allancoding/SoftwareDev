<html>
<body>

Welcome <?php echo $_POST["uname"]; ?><br>
Your password is: <?php echo $_POST["psw"]; ?><br>
Should I remember you? <?php 
if ($_POST["remember"] == "on") {
    echo "Yes";
} else {
    echo "No";
}
?>

</body>
</html>