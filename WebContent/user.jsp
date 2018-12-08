<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400">       
		<link rel="stylesheet" href="css/bootstrap.min.css">                                          
		<link rel="stylesheet" href="css/fontawesome-all.min.css">                                     
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
		<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
		<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
		<script>
		$(function() {
		$( "#accordion" ).accordion();
		});
</script>
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
			<div id="accordion">
	<h3>Section 1</h3>
	<div>
	<p>
	Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer
	ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit
	amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut
	odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
	</p>
	</div>
	<h3>Section 2</h3>
	<div>
	<p>
	Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet
	purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor
	velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In
	suscipit faucibus urna.
	</p>
	</div>
	<h3>Section 3</h3>
	<div>
	<p>
	Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis.
	Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero
	ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis
	lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.
	</p>
	<ul>
	<li>List item one</li>
	<li>List item two</li>
	<li>List item three</li>
	</ul>
	</div>
	<h3>Section 4</h3>
	<div>
	<p>
	Cras dictum. Pellentesque habitant morbi tristique senectus et netus
	et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in
	faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia
	mauris vel est.
	</p>
	<p>
	Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus.
	Class aptent taciti sociosqu ad litora torquent per conubia nostra, per
	inceptos himenaeos.
	</p>
	</div>
	</div>
		      
		
		      
		    </div> 
		
		  </div> 		
	</body>
</html>