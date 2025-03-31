<?php

define('DB_SERVER', 'localhost');
define('DB_USERNAME', '600');
define('DB_PASSWORD', 'schoolisdumb');
define('DB_NAME', '600_db');
 
$link = mysqli_connect(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);

 
if($link === false){
    die("ERROR: Could not connect. " . mysqli_connect_error());
} else{
}

// Processing form data when form is submitted
$starttime = microtime(true);
if(isset($_GET['name'])){
    $_POST["name"] = $_GET['name'];
    $a = "a";
}
if(isset($_GET['email'])){
    $_POST["email"] = $_GET['email'];
    $a = "a";
}
if(isset($_GET['export'])){
    if($_GET['export'] == "0"){
        $_POST["export"] = false;
    } else if($_GET['export'] == "0"){
        $_POST["export"] = true;
    } else {
        $_POST["export"] = "invalid";
    }
    $a = "a";
}

if($_SERVER["REQUEST_METHOD"] == "POST" || isset($a)){
 
    if(empty(filter_var(trim($_POST["name"]), FILTER_SANITIZE_STRING))){
        $name_err = " ";
    } else{
        $name = filter_var($_POST["name"], FILTER_SANITIZE_STRING);
        if(!preg_match('/^[a-zA-Z0-9_ ]+$/', $_POST["name"])){
            $name_err = "Invalid charecter";
            echo "<h3>[Error: search term ".$_POST["name"]." is invalid (Code Injection Filter)]</h3>";
        }
    }
    
    if(isset($_POST["email"])){
        $_POST["sixhundred"] = $_POST["email"];
    }
    if(empty(filter_var(trim($_POST["sixhundred"]), FILTER_SANITIZE_STRING))){
        $sixhundred_err = " ";
    } else{
        $sixhundred = filter_var(trim($_POST["sixhundred"]), FILTER_SANITIZE_STRING);
        if ((str_contains($sixhundred, '?>')) || (str_contains($sixhundred, '<?')) || (str_contains($sixhundred, '\'')) || (str_contains($sixhundred, '"')) || (str_contains($sixhundred, ';'))) {
            $sixhundred_err = "Invalid charecter";
        } else{
        }
    }
    
    if(empty($name_err) && empty($sixhundred_err)){
        $sql = "SELECT Name, Email, About FROM `600` WHERE Email = ?";
        
        if($stmt = mysqli_prepare($link, $sql)){
            mysqli_stmt_bind_param($stmt, "s", $param_email);
            
            $param_email = $sixhundred."@ironschools.org";
            
            if(mysqli_stmt_execute($stmt)){
                // Store result
                mysqli_stmt_store_result($stmt);
                
                // Check if username exists, if yes then verify
                if(mysqli_stmt_num_rows($stmt) > 0){      
                    // Bind result variables
                    mysqli_stmt_bind_result($stmt, $param_name, $email, $about);
                    if(mysqli_stmt_fetch($stmt)){
                        if(strtolower($name) == strtolower($param_name)){
                            $results = "Valid!";
                            if(!isset($_SESSION['valid'])){
                                header("refresh:0;url=#valid");
                                $_SESSION['valid'] = "done";
                            } else{
                                unset($_SESSION['valid']);
                            }
                            
                        } else{
                            $results = "Invalid!";
                            if(!isset($_SESSION['valid'])){
                                header("refresh:0;url=#invalid");
                                $_SESSION['valid'] = "done";
                            } else{
                                unset($_SESSION['valid']);
                            }
                        }
                        $rows = 1;
                        $search = "Validation";
                    } else{
                        echo "Invalid!";
                    }
                } else{
                    echo "Invalid!";
                }
            } else{
                echo "Error!";
            }
        } else{
            echo "Error!";
        }
    } else{
        if(!empty($name_err)){
            $search = $sixhundred;
            // Prepare a select statement
            $param_email="%".$sixhundred."%";
            $sql = "SELECT Name, Email, About FROM `600` WHERE Email LIKE ?";
            
            if($stmt = mysqli_prepare($link, $sql)){
                // Bind variables to the prepared statement as parameters
                mysqli_stmt_bind_param($stmt, "s", $param_email);
                
                // Set parameters
                $param_email = "%".$sixhundred."%";
                
                // Attempt to execute the prepared statement
                if(mysqli_stmt_execute($stmt)){
                    // Store result
                    mysqli_stmt_store_result($stmt);
                    mysqli_stmt_bind_result($stmt, $param_name, $email, $about);
                    if(mysqli_stmt_num_rows($stmt) > 0){   
                        $rows = mysqli_stmt_num_rows($stmt);
                        if(mysqli_stmt_fetch($stmt)){
                            $i = 0;
                            $results = "";
                            while($i < $rows){
                                $stmt->data_seek($i);
                                $stmt->fetch();
                                if(!empty($about)){
                                    $results = $results."Name: ".$param_name." | Email: ".$email." | About: ".$about."<br>\n";
                                }else{
                                    $results = $results."Name: ".$param_name." | Email: ".$email."<br>\n";
                                }
                                $i++;
                            }
                        }
                    } else{
                        $rows = 0;
                    }
                }
            }
            #if(!isset($_SESSION['valid'])){
             #   header("refresh:0;url=#valid");
              #  $_SESSION['valid'] = "done";
            #} else{
             #   unset($_SESSION['valid']);
            #}
        } else if(!empty($sixhundred_err) && !empty($_POST["pfp"])){
            $search = $name;
            // Prepare a select statement
            $sql = "SELECT Name, Email, About, Avatar FROM `600` WHERE Name LIKE ? and (Name NOT LIKE '%@%')";
            
            if($stmt = mysqli_prepare($link, $sql)){
                // Bind variables to the prepared statement as parameters
                mysqli_stmt_bind_param($stmt, "s", $param_name);
                
                // Set parameters
                if($name != "_"){
                    $param_name = "%".$name."%";
                }else{
                    $param_name = "%";
                }
                // Attempt to execute the prepared statement
                if(mysqli_stmt_execute($stmt)){
                    // Store result
                    mysqli_stmt_store_result($stmt);
                    mysqli_stmt_bind_result($stmt, $param_name, $email, $about, $pro_pic);
                    if(mysqli_stmt_num_rows($stmt) > 0){   
                        $rows = mysqli_stmt_num_rows($stmt);
                        if(mysqli_stmt_fetch($stmt)){
                            $i = 0;
                            $results = "";
                            while($i < $rows){
                                $stmt->data_seek($i);
                                $stmt->fetch();
                                if(!empty($about)){
                                    $results = "$results <ins><img src=$pro_pic style='width:2%;height:2%;' style='vertical-align:0%'></img>Name: $param_name | Email: $email | About: $about</ins><br>\n";
                                }else{
                                    $results = "$results <ins><img src=$pro_pic style='width:2%;height:2%;' style='vertical-align:0%'></img>Name: $param_name | Email: $email</ins><br>\n";
                                }
                                $i++;
                            }
                        }
                    } else{
                        $rows = 0;
                    }
                }
            }
        } else if(!empty($sixhundred_err)){
            $search = $name;
            // Prepare a select statement
            $sql = "SELECT Name, Email, About FROM `600` WHERE Name LIKE ? and (Name NOT LIKE '%@%')";
            
            if($stmt = mysqli_prepare($link, $sql)){
                // Bind variables to the prepared statement as parameters
                mysqli_stmt_bind_param($stmt, "s", $param_name);
                
                // Set parameters
                if($name != "_"){
                    $param_name = "%".$name."%";
                }else{
                    $param_name = "%";
                }
                // Attempt to execute the prepared statement
                if(mysqli_stmt_execute($stmt)){
                    // Store result
                    mysqli_stmt_store_result($stmt);
                    mysqli_stmt_bind_result($stmt, $param_name, $email, $about);
                    if(mysqli_stmt_num_rows($stmt) > 0){   
                        $rows = mysqli_stmt_num_rows($stmt);
                        if(mysqli_stmt_fetch($stmt)){
                            $i = 0;
                            $results = "";
                            while($i < $rows){
                                $stmt->data_seek($i);
                                $stmt->fetch();
                                if(!empty($about)){
                                    $results = "$results <ins>Name: $param_name | Email: $email | About: $about</ins><br>\n";
                                }else{
                                    $results = "$results <ins>Name: $param_name | Email: $email</ins><br>\n";
                                }
                                $i++;
                            }
                        }
                    } else{
                        $rows = 0;
                    }
                }
            }
        }
    }
    if(isset($_POST['export'])){
        if($_POST['export'] == true && empty($sixhundred_err)){
            //open file to write
            $fp = fopen("export.txt", "r+");
            // clear content to 0 bits
            ftruncate($fp, 0);
            //close file
            fclose($fp);
            file_put_contents('export.txt', str_replace("<br>", "",$exp_results), FILE_APPEND | LOCK_EX);
            header("refresh:0;url=download.php?path=export.txt");
            $_POST['export'] = false;
        }
    }
}

//time taken
$endtime = microtime(true);
$duration = $endtime - $starttime; //calculates total time taken
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Email Validation</title>
    <!--
    <style>
  body {
    font-family: Arial, sans-serif;
    background-color: lightblue;
  }
  form {
    max-width: 500px;
    margin: auto;
    background-color: white;
    padding: 20px;
    border: 1px solid gray;
    border-radius: 5px;
  }
  h1 {
    text-align: left;
    color: blue;
  }
  label {
    display: block;
    margin-bottom: 5px;
  }
  input, textarea {
    width: 100%;
    box-sizing: border-box;
    border: 1px solid gray;
    border-radius: 5px;
    padding: 5px;
  }
  input[type="submit"] {
    background-color: blue;
    color: white;
    font-weight: bold;
    cursor: pointer;
  }
  .error {
    color: red;
  }
</style>
-->
</head>
<body>
    <div class="wrapper">
        <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post">
            <div class="form-group">
                <label>Name</label>
                <input type="text" name="name" class="form-control <?php echo (!empty($name_err)) ? 'is-invalid' : ''; ?>">
                <span class="invalid-feedback"><?php echo $name_err; ?></span>
            </div>    
            <div class="form-group">
                <label>Email</label>
                <input type="text" name="sixhundred" class="form-control <?php echo (!empty($sixhunderd_err)) ? 'is-invalid' : ''; ?>">
                <span class="invalid-feedback"><?php echo $sixhundred_err; ?></span>
            </div>
            </div>
            <div class="form-group">
                <input type="submit" class="btn check" value="check">
            </div>
            <div class="form-group">
                <input type="checkbox" name="export">Export as TXT file</input>
                <input type="checkbox" name="pfp">Load profile Pictures</input>
            </div>
        </form>
        <h1><?php echo "Searched for: ".$search; ?></h1>
        <h2><?php echo $rows." result(s) found in ".round($duration, 3)." second(s)"; ?></h2>
    </div>
<?php
no:
echo $results;
?>