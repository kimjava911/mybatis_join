<%@ page import="kr.java.join.model.dto.PostByUserDTO" %>
<%@ page import="kr.java.join.model.domain.Post" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시물</title>
</head>
<body>
    <h1>게시물</h1>
    <form method="post">
        <input name="title" placeholder="제목"> <br>
        <textarea name="content" placeholder="내용"></textarea> <br>
        <button>작성</button>
    </form>

    <%-- 유저가 작성한 글 목록 --%>
    <%
        PostByUserDTO dto = (PostByUserDTO) request.getAttribute("posts");
        if (dto != null) {
    %>
        <%= dto.getUsername() %><br>
        <%= dto.getNickname() %><br>
        <%= dto.getEmail() %><br>
        <hr>
    <% for (Post p : dto.getPosts()) { %>
        <%= p.getPostId() %><br>
        <%= p.getTitle() %><br>
        <%= p.getContent() %>
    <% } } %>
</body>
</html>
