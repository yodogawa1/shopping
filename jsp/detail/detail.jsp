<%@ page contentType="text/html;charset=Shift_JIS"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp"%>
<html>
<head>
<title>���i�ڍ׉��</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/cart_header.jsp"%>
<div align="center" class="body">
<h2>���i�ڍ׉��</h2>
<table>
	<tr>
		<td><img src="../img/${item.pictureUrl}"></td>
		<td align="center">
		<table>
			<tr height="50">
				<td width="80">���i��</td>
				<td width="160">${item.itemName}</td>
			</tr>
			<tr height="50">
				<td width="80">���i</td>
				<td width="160">${item.price}�~</td>
			</tr>
			<tr height="50">
				<td width="80">�R�����g</td>
				<td width="160">${item.description}</td>
			</tr>
			<tr>
				<td colspan="2" align="center" width="230">
				<form action="../cart/cartAdd.html"><input type="hidden"
					name="itemId" value="${item.itemId}">
				<table>
					<tr>
						<td><select name="quantity">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
							<option>6</option>
							<option>7</option>
							<option>8</option>
							<option>9</option>
						</select>&nbsp;��</td>
						<td><input type="submit" value="�J�[�g�ɂ����"></td>
					</tr>
				</table>
				</form>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center" width="240"><a href="../index/index.html">���ꗗ�ɖ߂�</a></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</div>
</body>
</html>