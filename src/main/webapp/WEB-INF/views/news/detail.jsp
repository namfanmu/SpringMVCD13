<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>News - Detail</title>
</head>
<body>
	<h1>${news.title}</h1>
	<div>
		<div>
			<p><span>Created by - </span> <fmt:formatDate value="${news.createdBy}" pattern="yyyy-MM-dd hh:mm"/>  <span></span></p>
		</div>
		${news.detail}
	</div>
</body>
</html>