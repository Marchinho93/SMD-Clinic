<%@ page import="model.*" %>
<% Administrator admin = (Administrator) session.getAttribute("admin");
/*if(session.getAttribute("loginSucceed")	!= null){
		return;
	}
	else if(session.getAttribute("loginError") !=null){
	   	out.clear();
		RequestDispatcher rd = application.getRequestDispatcher("/fallimento.jsp");
	    rd.forward(request, response);
	}
	return;*/
%>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>SMDClinic</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="css/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="js/ie-emulation-modes-warning.js"></script>

    <link rel="prerender" href="home.html">
    <link rel="prefetch" href="home.html">
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
  	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-animate.min.js"></script>
  	<!-- navbar and carousel behaviour -->
	<script src="js/app/navbar.js"></script>
    <!-- Custom styles for this template -->
    <link href="css/carousel.css" rel="stylesheet">
  </head>
<!-- NAVBAR
================================================== -->
  <body ng-app = "navbar"  style="background-color:#e6e6e6">
    <div class="navbar-wrapper">
      <div class="container">
        <nav class="navbar navbar-inverse navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <div class="navbar-brand" >SMDClinic</div>
            </div>
            <div id="navbar" ng-controller="navbarC" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li  ng-class="{'active':urlActive === 'home'}"><a href="" ng-click="update('home');">Home</a></li>
                <li  ng-class="{'active':urlActive === 'theClinic'}"><a href="" ng-click="update('theClinic');">The Clinic</a></li>
                <li class="dropdown">
                <a href="" class="dropdown-toggle" data-menuid="1" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Our Services<span class="caret"></span></a>
                <ul id="1" class="dropdown-menu">
                  <li ng-class="{'active':urlActive === 'exams'}"><a href="" ng-click="update('exams');">Exams</a></li>
                  <li ng-class="{'active':urlActive === 'doctors'}"><a href="" ng-click="update('doctors');">Doctors</a></li>
                  <li role="separator" class="divider"></li>
                  <li class="dropdown-header">Our patients</li>
                  <li ng-class="{'active':urlActive === 'feedbacks'}"><a href="" ng-click="update('feedbacks');">Feedbacks</a></li>
                </ul>
                </li>
                <li  ng-class="{'active':urlActive === 'contacts'}"><a href="" ng-click="update('contacts');">Contacts</a></li>
              </ul>
              <ul class="nav navbar-nav navbar-right">
	                <li class="dropdown">
	                <a href='' class="dropdown-toggle" data-menuid="navig" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" ><% if(admin!=null) out.print("Hello, "+ admin.getName()); else out.print("Login"); %><span class="caret"></span></a>
	              		<div id="navig" class="dropdown-menu">
	              			<form role="form" class="form container-fluid" action="login" method="POST">
	              				<div align="center" class="form-group">
	              					<label for="user">Username:</label>
	              					<input type="text" class="form-control input-sm" id="user" name="username" required>
	              				</div>
	              				<div align="center" class="form-group">
	              					<label for="password">Password:</label>
	              					<input type="password" class="form-control input-sm" id="password" name="password" required>
	              				</div>
	              				<li role="separator" class="divider"></li>
	              				<button type="submit" class="btn btn-default">Enter</button>
	              			</form>
	              		</div>
	              	</li>
	              </ul>
            </div>
          </div>
        </nav>

      </div>
    </div>


    <!-- Carousel
    ================================================== -->
    <div id="myCarousel" ng-model="carousel" class="carousel slide carouselAnimDown" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img class="first-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Example headline.</h1>
              <p>Note: If you're viewing this page via a <code>file://</code> URL, the "next" and "previous" Glyphicon buttons on the left and right might not load/display properly due to web browser security rules.</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up today</a></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="second-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Another example headline.</h1>
              <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="third-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Third slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>One more for good measure.</h1>
              <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- /.carousel -->


    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <div id="HTMLContainer" class="container marketing">





      <!-- FOOTER -->
     

    </div><!-- /.container -->
 	<footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2015 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.2.3.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="js/bootstrap.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
   <!-- <script src="js/ie10-viewport-bug-workaround.js"></script>-->
   <script src="js/holder.min.js"></script>
  </body>
</html>