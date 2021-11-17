<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>News - List</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>

	<h1>News - List</h1>
	<div style="margin: 20px;">
		<a href="${pageContext.request.contextPath}/news/add" type="button"
			class="btn btn-success">Add</a>
	</div>
	<c:if test="${not empty msg}">
		<div class="alert alert-success" role="alert">${msg}</div>
	</c:if>
	<%-- <c:if test="${datas ne null}">
		<ul>
			<c:forEach items="${datas}" var="news">
				<li><a href="${pageContext.request.contextPath}/news/detail?id=${news.id}">${news.title} - ${news.author}</a></li>
			</c:forEach>
		</ul>
	</c:if> --%>

	<c:choose>
		<c:when test="${not empty datas}">
			<ul class="list-group">
				<c:forEach items="${datas}" var="news">
					<li class="list-group-item" style="background: #bbb;"><img
						src="${pageContext.request.contextPath}/resource/${news.picture}"
						width="300p" height="200px" /><a
						href="${pageContext.request.contextPath}/news/detail/${news.id}/${news.author}" style="padding-left: 10px;">${news.title}
							- ${news.author}</a></li>
				</c:forEach>
			</ul>
		</c:when>

		<c:otherwise>
			<div>
				<p>Data is empty!</p>
			</div>
		</c:otherwise>
	</c:choose>

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