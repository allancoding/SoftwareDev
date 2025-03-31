<?php
$document_root = $_SERVER['DOCUMENT_ROOT'];
?>
<!DOCTYPE html>
<html>
    <head>
    	<title>Bob's Auto Parts - Order Results</title>
    </head>
    <body>
		<h1>Bob's Auto Parts</h1>
		<h2>Customer Orders</h2>
		<?php 
            $fp = fopen("C:\\xampp\\htdocs\\phpandmysql\\Chapter02\\orders\\orders.txt", 'rb');
            flock($fp, LOCK_SH); // lock file for reading.
            
            if(!$fp){
                echo '<p><strong>No orders pending.<br />
                        Please try again later.</strong></p>';
                exit();
            }
           
            while(!feof($fp)){
                $order = fgets($fp);
                echo htmlspecialchars($order) . '<br />';
            }
            
            flock($fp, LOCK_UN); // release read lock.
            fclose($fp);
            
            ## using the fread() function to simplify the process.
            if(file_exists("C:\\xampp\\htdocs\\phpandmysql\\Chapter02\\orders\\orders.txt")){
                echo "<p><strong>Files Exists using the fread() function.</strong></p>";
                
                $fp = fopen("C:\\xampp\\htdocs\\phpandmysql\\Chapter02\\orders\\orders.txt", 'rb');
                rewind($fp);
                echo nl2br(fread($fp, filesize("C:\\xampp\\htdocs\\phpandmysql\\Chapter02\\orders\\orders.txt")));
                fclose($fp);
            }
            
            // Using a per character output
            
            $fp = fopen("C:\\xampp\\htdocs\\phpandmysql\\Chapter02\\orders\\orders.txt", 'rb');
            flock($fp, LOCK_SH); // lock file for reading.
            
            if(!$fp){
                echo "<p><strong>No orders pending.<br />
                        Please try again later.</strong>.</p>";
                exit();
            }
            else echo '<p><strong>Using a per character output.</strong></p>';
            
            rewind($fp);
            while(!feof($fp)){
                $char = fgetc($fp);
##                if(!foef($fp)){
                    echo ($char=="\n" ? "<br />" : $char);
##                }
            }
            
            flock($fp, LOCK_UN); // release read lock.
            fclose($fp);
            
		?>
    </body>
</html>