<%@ page import="kr.java.join.model.dto.UserLoginWithInfoDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>정보</title>
</head>
<body>
    <nav><a href="<%= request.getContextPath() %>/">메인</a></nav>
    <h1>정보</h1>
    <% UserLoginWithInfoDTO dto = (UserLoginWithInfoDTO) request.getAttribute("info"); %>
    <%--    <p> 유저네임 : <%= dto.username() %> </p>--%>
    <p> 유저네임 : <%= dto.getUsername() %> </p>
    <%--    <p> 별명 : <%= dto.userInfo().nickname() %> </p>--%>
    <p> 별명 : <%= dto.getUserInfo().getNickname() %> </p>
    <%--    <p> 이메일 : <%= dto.userInfo().email() %> </p>--%>
    <p> 이메일 : <%= dto.getUserInfo().getEmail() %> </p>
</body>
</html>