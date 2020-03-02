<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
<title>掲示板</title>
</head>
<body>
<h2>小林掲示板</h2>
  <table border="1">
    <tbody>
      <tr>
        <th>id</th>
        <th>名前</th>
        <th>メッセージ</th>
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
    <label for="name">名前</label><br />
    <input type="text" name="name"/>
    <br /><br />
    <label for="content">メッセージ</label><br />
    <textarea name="content"></textarea>
    <br /><br />
    <button type="submit">投稿</button>
  </form>

</body>
</html>