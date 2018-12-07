<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta charset="utf-8">
 		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Movie Ticket Booking System</title>
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400">       
		<link rel="stylesheet" href="css/bootstrap.min.css">                                          
		<link rel="stylesheet" href="css/fontawesome-all.min.css">                                     
		<link rel="stylesheet" href="css/style.css">                                           
		
	</head>
	<body>
		
		  <div class="tm-main">
		
		    <div class="tm-welcome-section">
		      <div class="container tm-navbar-container">
		        <div class="row">
		          <div class="col-xl-12">
		            <nav class="navbar navbar-expand-sm">
		              <ul class="navbar-nav ml-auto">
		                <li class="nav-item active">
		                  <a href="index.jsp" class="nav-link tm-nav-link tm-text-white active">Home</a>
		                </li>
		            	<c:if test="${not empty loggedInUser}">
		                <li class="nav-item">		            
		                  <a href="service.jsp" class="nav-link tm-nav-link tm-text-white"><%=session.getAttribute("username")%></a>
		                </li>
		                <li class="nav-item">
		                  <a href="logout" class="nav-link tm-nav-link tm-text-white">Logout</a>
		                </li>
		                </c:if>
		         		<c:if test="${empty loggedInUser}">
		         		<li class="nav-item">	
		                  <a href="register.jsp" class="nav-link tm-nav-link tm-text-white">Register</a>
		                </li>
		                <li class="nav-item">
		                  <a href="login.jsp" class="nav-link tm-nav-link tm-text-white">Login</a>
		                </li>
		                </c:if>
		              </ul>
		            </nav>
		          </div>
		        </div>
		      </div>
		
		      <div class="container text-center tm-welcome-container">
		        <div class="tm-welcome">
		          <h1 class="mb-3 tm-site-name">Sunbeam Cinema</h1>
		          <p class="tm-site-description">Keeping it real!</p>
		        </div>
		      </div>
		
		    </div>
		
		    <div class="container">
		      <div class="tm-search-form-container">
		        <form action="index.html" method="GET" class="form-inline tm-search-form">
		          <div class="text-uppercase tm-new-release">Now playing</div>
		          <div class="form-group tm-search-box">
		            <input type="text" name="keyword" class="form-control tm-search-input" placeholder="Search for movies ...">
		            <input type="submit" value="Search" class="form-control tm-search-submit">
		          </div>
		          <div class="form-group tm-advanced-box">
		            <a href="sub.jsp" class="tm-text-white">Subscribe our updates!</a>
		          </div>
		        </form>
		      </div>
		
		      <div class="row tm-albums-container grid">
		        <div class="col-sm-6 col-12 col-md-6 col-lg-3 col-xl-3 tm-album-col">
		          <figure class="effect-sadie">
		          <a class="moviepic" href="movie?moviename=<%= "The Godfather" %>">
		            <img src="img/godfather.jpg" alt="Image" class="img-fluid">
		            <figcaption>
		              <h2> The Godfather</h2>
		              <p>The aging patriarch of an organized crime dynasty transfers control of his ...</p>
		            </figcaption>
				</a>
		          </figure>
		        </div>
		        <div class="col-sm-6 col-12 col-md-6 col-lg-3 col-xl-3 tm-album-col">
		          <figure class="effect-sadie">
		          <a class="moviepic" href="movie?moviename=<%= "The Grand Budapest Hotel" %>">
		            <img src="img/hotel.jpg" alt="Image" class="img-fluid">
		            <figcaption>
		              <h2>The Grand Budapest Hotel</h2>
		              <p>A legendary concierge at a famous European hotel between the wars and...</p>
		            </figcaption>
		            </a>
		          </figure>
		        </div>
		        <div class="col-sm-6 col-12 col-md-6 col-lg-3 col-xl-3 tm-album-col">
		          <figure class="effect-sadie">
		          <a class="moviepic" href="movie?moviename=<%= "Reservoir Dogs" %>">
		            <img src="img/dogs.jpg" alt="Image" class="img-fluid">
		            <figcaption>
		              <h2>Reservoir Dogs</h2>
		              <p>A botched robbery indicates a police informant, and the pressure mounts in the...</p>
		            </figcaption>
		            </a>
		          </figure>
		        </div>
		        <div class="col-sm-6 col-12 col-md-6 col-lg-3 col-xl-3 tm-album-col">
		          <figure class="effect-sadie">
		          <a class="moviepic" href="movie?moviename=<%= "Coco" %>">
		            <img src="img/coco2.jpg" alt="Image" class="img-fluid">
		            <figcaption>
		              <h2>Coco</h2>
		              <p>Aspiring musician Miguel, confronted with his family's ancestral ban on music...</p>
		            </figcaption>
		            </a>
		          </figure>
		        </div>
		      </div>
		
		
		      
		    </div> 
		
		  </div> 
		
		 
	</body>
</html>