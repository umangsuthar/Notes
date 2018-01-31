<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display</title>
</head>
<body>
<nav class="navbar navbar-light bg-light">
  <a class="navbar-brand">Notes</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
  		<span class="navbar-toggler-icon"></span>
  </button> 
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
	   <div class="navbar-nav">
	     <a class="nav-item nav-link" href="/Notes/">Home <span class="sr-only">(current)</span></a>
	     <a class="nav-item nav-link active" href="/Notes/display">Display</a>
	   </div>
  </div>
</nav>
	
	<c:if test="${not empty notes}">
		<div class= "row">
		<c:forEach var="x" items="${notes}">
			
			  <div class="col-sm-3">
				<div class="card text-white bg-dark border-dark mb-3" style="max-width: 18rem;">
				  <div class="card-header">${x.title}</div>
				  <div class="card-body">
				    <%-- <h5 class="card-title">${x.title}</h5> --%>
				    <p class="card-text">${x.text}</p>
				    <a href="/Notes/delete/${x.id}" class="card-link"><i class="fa fa-trash"></i></a>
				    <a href="/Notes/update/${x.id}" class="card-link"><i class="fa fa-edit"></i></a>
				  </div>
				</div>		
			  </div>
		
		</c:forEach>
		</div>
	</c:if>
		
</body>
</html>