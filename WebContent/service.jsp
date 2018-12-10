<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="com.fdmgroup.model.User"%>   
<%@ page import ="com.fdmgroup.model.Seating"%>   
<%@ page import ="com.fdmgroup.model.Booking"%>   

<%@ page import ="com.fdmgroup.dao.BookingDao"%>   
<%@ page import ="com.fdmgroup.dao.SeatingDao"%>   

<%@ page import ="java.util.ArrayList"%>  
<%@ page import ="java.util.List"%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>User Center</title>
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400">       
		<link rel="stylesheet" href="css/bootstrap.min.css">                                          
		<link rel="stylesheet" href="css/fontawesome-all.min.css">                                     
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
		<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
		<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
		<style>
			table {
				border-collapse: collapse;
				margin-left:auto; 
    			margin-right:auto;
			}
			
			table th {
				text-align: left;
				background-color: #3a6070;
				color: #FFF;
				padding: 4px 30px 4px 8px;
			}
			
			table tr {
				border: 1px solid #e3e3e3;
				padding: 4px 8px;
			}
			
			table tr:nth-child(odd) td {
				background-color: #e7edf0;
			}
		</style>
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
	<h3>Your personal info</h3>
		<div>
			<%User u = (User)session.getAttribute("loggedInUser");%>
			<h4>UserID:<%=u.getId() %></h4>
			<h4>UserName:<%=u.getUsername() %></h4>
			<h4>Password:<%=u.getPassword() %></h4>
			<h4>Firstname:<%=u.getFirstname() %></h4>
			<h4>Lastname:<%=u.getLastname() %></h4>
			<h4><a href="modify.jsp" style="color:blue">Modify Your Profile</a></h4>
		</div>
	<h3>Your movie tickets</h3>
		<div>
			<table>
			    		<tr>
			    			<th>Screen Number</th>
			    			<th>Show Time</th>
			    			<th>Type</th>
			    			<th>Price</th>
			    			<th>Quantity</th>
			    		
			    		</tr>
			    		<% 
			    		BookingDao bdao = new BookingDao();
			    		SeatingDao sdao = new SeatingDao();
			    		List<Booking> bookingList = bdao.findByUserId(u.getId()); 
			    		for (Booking b: bookingList) {
			    		%>
				              <tr>
				              <%Seating s = sdao.findById(b.getSeatingid()); %>
				              <td> <%=s.getScreennum() %></td>
				              <td> <%=s.getShowtime()%></td>
				              <td> <%=s.getType()%></td>
				              <td> <%=s.getPrice()%></td>
				              <td> <%=b.getQuantity() %></td>
				              </tr>
				         <%}%>
			    	</table>
		</div>
	
	
	<h3>Contact Us</h3>
	<div>
			<h4><a href="#" style="color:blue">Call Us</h4>
						<h4><a href="#" style="color:blue">Live Chat</h4>
						<h4><a href="#" style="color:blue">Facebook Messenger</h4>
						
	</div>
	
	
	</div>
	  
	
	  
	</div> 
	
	</div> 		
</body>
</html>