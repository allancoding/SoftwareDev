<!DOCTYPE html>
<html>
<head>
	<title>Book-O-Rama Search Results</title>
</head>
<body>
	<h1>Book-O-Rama Search Results</h1>
    <?php
    // create short variable names.
    $searchtype = $_POST['searchtype'];
//    $searchterm = trim("%{$_POST['searchterm']}%");
    $searchterm = trim($_POST['searchterm']);
    
    if(!isset($searchtype) && !isset($searchterm)){
        echo '<p>You have not entered search details.<br/>
       Please go back and try again.</p>';
        exit();
    }
    
    // whitelist the searchtype
    switch($searchtype){
        case 'Author':
        case 'Title':
        case 'ISBN':
            break;
        default:
            echo '<p>That is not a valid search type. <br/>
            Please go back and try again.</p>';
            exit();
    }
    
    $db = new mysqli(NULL, 'bookorama', 'bookorama123', 'books');
    
    if(mysqli_connect_errno()){
        echo '<p>Error: Could not connect to database.<br/>
        Please try again later.</p>';
        exit();
    }
    
    // Original version of the codes
    $query = "SELECT ISBN, Author, Title, Price FROM books WHERE $searchtype = ?";
    $stmt = $db->prepare($query);
    $stmt->bind_param('s', $searchterm);
    $stmt->execute();
    $stmt->store_result();
    
    /**
    // [EDITED] When showing all the results.
    $query = "SELECT ISBN, Author, Title, Price FROM books";
    $stmt = $db->prepare($query);
    $stmt->execute();
    $stmt->store_result();
    **/
    
    $stmt->bind_result($isbn, $author, $title, $price);
    
    echo "<p>Number of books found: " .$stmt->num_rows;
    echo '</p>';
    
    while($stmt->fetch()){
        echo "<p><strong>Title: " .$title. "</strong>";
        echo "<br />Author: " .$author;
        echo "<br />ISBN: " .$isbn;
        echo "<br />Price: \$" .number_format($price, 2);
        echo "</p>";
    }
    
    $stmt->free_result();
    $db->close();
    ?>
</body>
</html>