<%@ page contentType="text/html;charset=Shift_JIS"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp"%>
<html>
<head>
<title>�J�[�g�m�F���</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/cart_header.jsp"%>
<div align="center" class="body">
<h2>�J�[�g�m�F���</h2>
<div class="cart">
<table style="font-size: 10pt;">
	<tr>
		<td colspan="2"><font color="green">�J�[�g�ɂ͎��̏��i�������Ă��܂��B</font></td>
	</tr>
	<c:forEach items="${cart.itemList}" var="itemSet">
		<tr>
			<td>${itemSet.item.itemName}</td>
			<td>${itemSet.quantity}</td>
		</tr>
	</c:forEach>
</table>
</div>
<br>

${message}<br>
<br>
<a href="../index/index.html">���ꗗ�ɖ߂�</a><br>
<a href="../checkout/checkout.html">�����Z��ʂ֐i��</a></div>
</body>
</html>