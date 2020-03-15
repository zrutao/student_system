<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form id="itemForm" action="images.html" enctype="multipart/form-data" method="post">
    <table>
      <tr>
        <td>请选择照片</td>
        <td>
          <c:if test="${item.img_url !=null}">
			<img src="/CSS/${item.img_url}" width=100 height=100/>
			<br/>
		  </c:if>
          <input type="file" name="pictureFile"/>
        </td>
        <td>
          <input type="submit" value="提交" />
        </td>
      </tr>
    </table>
  </form>
</body>
</html>