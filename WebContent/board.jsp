<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
<title>�f����</title>
</head>
<body>
<h2>���ьf����</h2>
  <table border="1">
    <tbody>
      <tr>
        <th>id</th>
        <th>���O</th>
        <th>���b�Z�[�W</th>
      </tr>
      <c:forEach var="message" items="${list}" varStatus="status">
        <tr>
          <td><c:out value="${message.id}" /></td>
          <td><c:out value="${message.name}" /></td>
          <td><textarea><c:out value="${message.content}" /></textarea></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <br /><br />

  <form method="POST" action="<c:url value='/insert' />">
    <label for="name">���O</label><br />
    <input type="text" name="name"/>
    <br /><br />
    <label for="content">���b�Z�[�W</label><br />
    <textarea name="content"></textarea>
    <br /><br />
    <button type="submit">���e</button>
  </form>

</body>
</html>