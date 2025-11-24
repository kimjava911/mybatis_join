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
        유저네임 : <%= dto.getUsername() %><br>
        별명 : <%= dto.getNickname() %><br>
        이메일 : <%= dto.getEmail() %><br>
        <hr>
    <% for (Post p : dto.getPosts()) { %>
        게시글ID : <%= p.getPostId() %><br>
        제목 : <%= p.getTitle() %><br>
        내용 : <%= p.getContent() %><br>
        <hr>
    <% } } %>
</body>
</html>
