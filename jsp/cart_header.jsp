<%@ page contentType="text/html;charset=Shift_JIS"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center">
<table class="header">
	<tr>
		<td width="160"><a href="../index/index.html">���ꗗ�ɖ߂�</a></td>
		<td width="160"><a href="../checkout/checkout.html">�����Z��ʂ֐i��</a></td>
		<td width="160"><a href="../cart/cartConfirm.html">���J�[�g���m�F����</a></td>
		<td width="160"><a href="../cart/cartClear.html">���J�[�g����ɂ���</a></td>
		<td width="160"><c:choose>
			<c:when test="${not empty loginUser}">
				<font color="red">�悤�����A<br>
				<c:out value="${loginUser.userId}" />����</font>
			</c:when>
			<c:when test="${empty loginUser}">
				<font color="red"><a href="../loginform/login.html">�����O�C������</a></font>
			</c:when>
		</c:choose></td>
	</tr>
</table>
</div>
<hr>