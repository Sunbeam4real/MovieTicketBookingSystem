<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="com.fdmgroup.model.Movie"%>   
<%@ page import ="com.fdmgroup.model.Seating"%>   
<%@ page import ="java.util.ArrayList"%>  
<%@ page import ="java.util.List"%>   
 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Godfather</title>
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400">       
		<link rel="stylesheet" href="css/bootstrap.min.css">                                          
		<link rel="stylesheet" href="css/fontawesome-all.min.css">                                     
		<link rel="stylesheet" href="css/style.css">                                           
		<style>
		
			#moviepage {
				background-color: #001f3f;
			}
			#movieinfo {
	  			display: table;
	 			margin: 0 auto;
			}
			.tm-movie-section {
			    height: 83vh;
			    display: flex;
			    flex-direction: column;
			    align-items: center;
			    justify-content: center;
			    background-color: #E7A7C0;
			    background-image: url('img/sub.jpg');
			    background-repeat: no-repeat;
			    background-size: cover;
			    background-position: center center;
			    color: white;
			    max-height: 700px;
			    min-height: 400px;
			}
			
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
			
			#subbtn {
				text-align:center;
				    background-color: #black;
				
			}
		</style>
	</head>
	<body>
		 <div class="tm-movie-section">
		      <div class="container tm-navbar-container">
		        <div class="row">
		          <div class="col-xl-12">
		            <nav class="navbar navbar-expand-sm">
		              <ul class="navbar-nav ml-auto">
		                <li class="nav-item active">
		                  <a href="index.jsp" class="nav-link tm-nav-link tm-text-white active">Home</a>
		                </li>
		                <li class="nav-item">
		                  <a href="register.jsp" class="nav-link tm-nav-link tm-text-white">Register</a>
		                </li>
		                <li class="nav-item">
		                  <a href="login.jsp" class="nav-link tm-nav-link tm-text-white">Login</a>
		                </li>
		              </ul>
		            </nav>
		          </div>
		        </div>
		      </div>
			<div class="container text-center tm-welcome-container">
		        <div id="movieinfo">
					<h3>Name:<% Movie m = (Movie)session.getAttribute("m");%>
								<%= m.getMoviename() %></h3>
					<h3>Length:<%= m.getLength() %></h3>
					<h3>Director:<%= m.getDirector() %></h3>
					<h3>Stars:<%= m.getStars() %></h3>
					<h3>Category:<%= m.getCatagory() %></h3>
				</div>
		      </div>
		    </div>
		    <div class="movietable">
		    	<form method ="get" action="purchase">
			    	<table>
			    		<tr>
			    			<th>Screen Number</th>
			    			<th>Show Time</th>
			    			<th>Type</th>
			    			<th>Price</th>
			    			<th>Tickets Left</th>
			    			<th>Quantity</th>
			    			
			    		</tr>
			    		<%
			    			List<Seating> seatingList = (ArrayList<Seating>)session.getAttribute("s");
			              for (Seating s : seatingList) {
				        %>
				              <tr>
				              <td> <%=s.getScreennum()%></td>
				              <td> <%=s.getShowtime()%></td>
				              <td> <%=s.getType()%></td>
				              <td> <%=s.getPrice()%></td>
				              <td> <%=s.getTicketsleft()%></td>
				              <td> 
				              	
				              <input type="text" placeholder="0" name="<%=s.getId() %>"/></td>
				              </tr>
				              
				              <%}%>
				          <tr>
				          
				          </tr>
			    	</table>
			    	<input id="subbtn" type="submit" value="Book" />
		    	</form>
		    </div>
		    
	</body>
</html>