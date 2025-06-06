<!DOCTYPE html>
<html>

<head>
    <title>Uploading...</title>
</head>

<body>
    <h1>Uploading File...</h1>
    <?php
    if ($_FILES['the_file']['error'] > 0) {
        echo 'Problem: ';
        switch ($_FILES['the_file']['error']) {
            case 1:
                echo 'File exceeded upload_max_filesize.';
                break;
            case 2:
                echo 'File exceeded max_file_size.';
                break;
            case 3:
                echo 'File only partially uploaded.';
                break;
            case 4:
                echo 'No file uploaded.';
                break;
            case 6:
                echo 'Cannot upload file: No temp directory specified.';
                break;
            case 7:
                echo 'Upload failed: Cannot write to disk.';
                break;
        }
        exit();
    }

    if ($_FILES['the_file']['type'] != 'image/png') {
        echo 'Problem: file is not a PNG image.';
        exit();
    }

    $uploaded_file = '' . $_FILES['the_file']['name'];

    if (is_uploaded_file($_FILES['the_file']['tmp_name'])) {
        if (!move_uploaded_file($_FILES['the_file']['tmp_name'], $uploaded_file)) {
            echo 'Problem: Could not move file to destination directory.';
            exit();
        }
    } else {
        echo 'Problem: Possible file upload attack. Filename: ';
        echo $_FILES['the_file']['name'];
        exit();
    }

    echo 'File uploaded succesfully.';

    echo '<p>You uploaded the following image: <br />';
    echo '<img src = "' . $_FILES['the_file']['name'] . '"/>';
    echo '</p>';
    ?>
</body>

</html>