
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Customer Portal</title> 
    <style>
    .ddiv{
    margin-top:20px;
   margin-left: 230px;
    }
    h2{
    text-align:center;
    color: red;
    }
    h3{
    margin-top:20px;
    text-align:center;
    color: blue;
    }
    </style>
     <style>
  .carousel-item{
  height: 25rem;
  background: #777;
  color: white;
  position: relative;
  background-position: center;
  background-size: cover;
  }
  .container{
  position: absolute;
  bottom:0;
  right:0;
  left:0;
  padding-bottom: 50px;
  }
  </style>
  </head>
  <body>
  <!-- As a link -->
<nav class="navbar navbar-light bg-light">
  <a class="navbar-brand" href="logout">Logout</a>
 <b> <span  style="margin-right: 650px;color: red" class="navbar-brand mb-0 h1">Wel-Come ${name }</span></b>
</nav>
  <div style="background-color: aqua;" id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
  </ol>
  <div class="carousel-inner">
 <div class="carousel-item active" >
 <img class="d-block w-100" src="1.jpg" alt="First slide">
 <div class="container">
 <h3>Please select any Service</h3>
  <div class="ddiv">
  <div  class="btn-toolbar ml-3" role="toolbar" aria-label="Toolbar with button groups">
  <div class="btn-group mr-3" role="group" aria-label="First group">
  <form action="withdrawal">
  <button id="bw" type="submit" class="btn btn-primary">Withdrawal</button>
   </form>
  </div>
  <div class="btn-group mr-3" role="group" aria-label="Second group">
    <form action="deposit">
  <button id="bd" type="submit" class="btn btn-primary">Deposit</button><br>
  </form>
  </div>
  <div class="btn-group mr-3" role="group" aria-label="Third group">
   <form action="pinchange">
  <button id="bp" type="submit" class="btn btn-primary">ATM PIN Change</button><br>
  </form>
  </div>
  <div class="btn-group mr-3" role="group" aria-label="Fourth group">
   <form action="balance">
  <button id="bb" type="submit" class="btn btn-primary">Check Balance</button><br>
  </form>
  </div>
  <div class="btn-group mr-2" role="group" aria-label="Fourth group">
   <form action="transfer">
<button id="bt" type="submit" class="btn btn-primary">Transfer</button><br>  </form>
</div>
 </div>
 </div>
 </div>
 </div>
 </div>
 </div>
 <nav style="height: 120px; text-align: center;" class="navbar navbar-light bg-light">
  <span  class="navbar-text" style="color:black;align-content: center;">
    <b>About</b><br>
    We are providing a secure and most reliable
  service for online banking.We kept security on top so that you can use our website 
  without any fear.We will never
   send you an email, SMS, or phone call to acquire your personal details, 
   password, or one-time SMS (high security) password. Any such e-mail, SMS, o
   r phone call is an intention to use your Internet Banking account to take money 
   fraudulently. Never reply to such email, text message, or phone call. 
   If you have inadvertently disclosed your credentials,
    please instantly lock your user access.
  </span>
  <p>
  </p>
</nav>
  <nav  class="navbar navbar-light bg-light">
  <p class="navbar-text">by Akshay, Aniket, Kapil
  </p>
</nav>
 
 
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>