<?php
require 'path.php';
?>
<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="icon" href="<?php echo path("img_avatar2.png"); ?>" type="image/png" />
    <title>Login Page</title>
    <style>
      body {
        font-family: Arial, Helvetica, sans-serif;
      }

      input[type="text"],
      input[type="password"] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        box-sizing: border-box;
      }

      button {
        background-color: #04aa6d;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
      }

      button:hover {
        opacity: 0.8;
      }

      .imgcontainer {
        text-align: center;
        margin: 24px 0 12px 0;
        position: relative;
      }

      img.avatar {
        width: 15%;
        border-radius: 50%;
      }

      .container {
        padding: 16px;
      }

      span.psw {
        float: right;
        padding-top: 16px;
      }

      .login {
        background-color: #fefefe;
        margin: 1% auto;
        border: 1px solid #888;
        width: 80%;
      }

      @media screen and (max-width: 300px) {
        span.psw {
          display: block;
          float: none;
        }
        .cancelbtn {
          width: 100%;
        }
      }

    .feedback {
      text-align: center;
      color: #04aa6d;
      padding: 14px 20px;
    }

    .center {
      text-align: center;
    }
    </style>
  </head>
  <body>
    <?php include 'header.php'; ?>
    <form class="login" action="login.php" method="post">
      <div class="imgcontainer">
        <img src="<?php echo path("img_avatar2.png"); ?>" alt="Avatar" class="avatar" />
      </div>
      <div class="container">
        <label for="uname"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="uname" required />

        <label for="psw"><b>Password</b></label>
        <input
          type="password"
          placeholder="Enter Password"
          name="psw"
          required
        />

        <button type="submit">Login</button>
        <label>
          <input type="checkbox" checked="checked" name="remember" /> Remember
          me
        </label>
      </div>
    </form>
    <?php include 'footer.php'; ?>
  </body>
</html>