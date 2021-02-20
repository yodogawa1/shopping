<%@ page contentType="text/html;charset=Shift_JIS"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp"%>
<html>
<head>
<title>w“ü—š—ğ‰æ–Ê</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/cart_header.jsp"%>
<div align="center" class="body">
<h2>w“ü—š—ğ‰æ–Ê</h2>
<table border="1">
	<tr class="header">
		<th align="center" width="320">w“ü“ú</th>
		<th align="center" width="100">¤•iID</th>
		<th align="center" width="200">¤•i–¼</th>
		<th align="center" width="100">ŒÂ”</th>
		<th align="center" width="100">‰¿Ši</th>
	</tr>
	<c:forEach items="${ordersList}" var="orders">
		<tr class="record">
			<td align="left">${orders.updateTime}</td>
			<td align="center">${orders.itemId}</td>
			<td align="left">${orders.itemName}</td>
			<td align="right">${orders.quantity}</td>
			<td align="right">${orders.itemPrice}‰~</td>
		</tr>
	</c:forEach>
</table>
</div>
<div align="center">
<a href="../index/index.html">¡ˆê——‚É–ß‚é</a><br>
</div>
</body>
</html>