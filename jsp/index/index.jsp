<%@ page contentType="text/html;charset=Shift_JIS"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp"%>
<html>
<head>
<title>���i�ꗗ���</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/cart_header.jsp"%>
<div align="center" class="body">
<h2>���i�ꗗ���</h2>
<table border="1">
	<tr class="header">
		<th align="center" width="80">���iID</th>
		<th align="center" width="320">���i��</th>
		<th align="center" width="100">���i</th>
	</tr>
	<c:forEach items="${itemList}" var="item">
		<tr class="record">
			<td align="center">${item.itemId}</td>
			<td align="left"><a href="../detail/detail.html?itemId=${item.itemId}">${item.itemName}</a></td>
			<td align="right">${item.price}�~</td>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>