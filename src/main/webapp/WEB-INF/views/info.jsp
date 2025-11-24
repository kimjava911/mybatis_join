<%@ page import="kr.java.join.model.dto.UserLoginWithInfoDTO" %>
<%@ page import="kr.java.join.model.domain.Post" %>
<%@ page import="kr.java.join.model.dto.PostByUserDTO" %>
<%@ page import="kr.java.join.model.dto.PostByUserRecommendDTO" %>
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
    <%-- 유저가 작성한 글 목록 --%>
    <%
        PostByUserRecommendDTO recommend = (PostByUserRecommendDTO) request.getAttribute("recommend");
        if (recommend != null) {
    %>
    유저네임 : <%= recommend.getUsername() %><br>
    별명 : <%= recommend.getNickname() %><br>
    이메일 : <%= recommend.getEmail() %><br>
    <hr>
    <% for (Post p : recommend.getPosts()) { %>
    게시글ID : <%= p.getPostId() %><br>
    제목 : <%= p.getTitle() %><br>
    내용 : <%= p.getContent() %><br>
    <hr>
    <% } } %>
</body>
</html>