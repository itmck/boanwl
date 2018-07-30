<%--
  User: Boan
  Date: 2018/7/30
  Time: 16:43
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form id="importFileForm" method="post" enctype="multipart/form-data"
      action="${pageContext.request.contextPath}/uploadImage">

    <td><input type="file" id="file" name="file" style="width:260px;"></td>

    <input type="submit" value="确认上传">
</form>

</body>
</html>
