<%@ page contentType="text/html;charset=Shift_JIS"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp"%>
<html>
<head>
<title>���[�U�[�o�^���</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/cart_header.jsp"%>
<div align="center" class="body">
<h2>���[�U�[�o�^���</h2>
<form:form modelAttribute="user" method="post" action="../userentryform/userEntry.html">
	<spring:hasBindErrors name="user">
		<font color="red"><c:forEach items="${errors.globalErrors}"
			var="error">
			<spring:message code="${error.code}" />
		</c:forEach> </font>
	</spring:hasBindErrors>
	<table>
		<tr height="40px">
			<td>���[�U�[ID</td>
			<td><form:input path="userId" maxlength="20" cssClass="userId" /><font
				color="red"><form:errors path="userId" /></font></td>
		</tr>
		<tr height="40px">
			<td>�p�X���[�h</td>
			<td><form:password path="password" maxlength="20" cssClass="password" /><font
				color="red"><form:errors path="password" /></font></td>
		</tr>
		<tr height="40px">
			<td>���O</td>
			<td><form:input path="userName" maxlength="20" cssClass="userName" /><font
				color="red"><form:errors path="userName" /></font></td>
		</tr>
		<tr height="40px">
			<td>�X�֔ԍ�</td>
			<td><form:input path="postCode" maxlength="8" cssClass="postCode" /><font
				color="red"><form:errors path="postCode" /></font></td>
		</tr>
		<tr height="40px">
			<td>�Z��</td>
			<td><form:input path="address" maxlength="50" cssClass="address" /><font
				color="red"><form:errors path="address" /></font></td>
		</tr>
		<tr height="40px">
			<td>E-MAIL</td>
			<td><form:input path="email" maxlength="50" cssClass="email" /><font color="red"><form:errors
				path="email" /></font></td>
		</tr>
		<tr height="40px">
			<td>���d��</td>
			<td><form:select path="job" cssClass="jobs">
				<form:option value="�Љ�l" label="�Љ�l" />
				<form:option value="��w" label="��w" />
				<form:option value="�w��" label="�w��" />
				<form:option value="���̑�" label="���̑�" />
			</form:select></td>
		</tr>
		<tr height="40px">
			<td>�</td>
			<td><form:input path="hobby" maxlength="10" cssClass="hobby" />
				<font color="red"><form:errors path="hobby" /></font></td>
		</tr>
		<tr height="40px">
			<td>���N����</td>
			<td><form:input path="birthDay" maxlength="10" cssClass="birthDay" /><font
				color="red"><form:errors path="birthDay" /></font></td>
		</tr>
	</table>
	<table>
		<tr>
			<td height="40px" align="center"><input type="submit"
				name="btnSubmit" value="�o�^"></td>
			<td height="40px" align="center"><input type="reset"
				name="btnReset" value="���Z�b�g"></td>
		</tr>
	</table>
</form:form> <a href="index.html">���ꗗ�ɖ߂�</a></div>
</body>
</html>