<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>News - Add</title>
</head>
<body>

	<div class="container">
		<h1>News - Add</h1>

		<form action="${pageContext.request.contextPath}/news/add"
			method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="exampleFormControlInput1">Title</label> <input
					type="text" class="form-control" id="title"
					placeholder="Please enter the title" name="title">
			</div>
			<div class="form-group">
				<label for="exampleFormControlInput1">Author</label> <input
					type="text" class="form-control" id="author"
					placeholder="Please enter the author" name="author">
			</div>
			<div class="form-group">
				<label for="exampleFormControlSelect1">Status</label> <select
					class="form-control" id="status" name="status">
					<option value="1" selected="selected">Active</option>
					<option value="0">De-Active</option>
				</select>
			</div>
			<div class="form-group">
				<label for="exampleFormControlTextarea1">Detail</label>
				<textarea class="form-control" id="detail" rows="3" name="detail"></textarea>
			</div>
			<div class="form-group">
				<label for="exampleFormControlTextarea1">Upload file</label>
				<input type="file" class="form-control" name="pic" >
			</div>
			<div class="form-group">
				<input type="submit" class="btn btn-primary" value="Submit">
				<input type="reset" class="btn btn-secondary" value="Reset">
				<a href="javascript:window.history.back()" class="btn btn-secondary">Back</a>
			</div>
		</form>
	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>