<%@ page import="java.util.List" %>
<%@ page import="kr.java.join.model.dto.PostWithNicknameDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>메인</title>
</head>
<body>
    <h1>메인</h1>
    <div>
        <% if (request.getAttribute("msg") != null) { %>
            <p><%= request.getAttribute("msg") %></p>
        <% } %>
        <% if (session.getAttribute("username") != null) { %>
            <p><%= session.getAttribute("username") %></p>
        <% } %>
    </div>

    <% if (session.getAttribute("username") == null) { %>
        <h2>로그인</h2>
        <form method="post">
            <input name="username" placeholder="유저네임"> <br>
            <input name="password" type="password" placeholder="비밀번호"> <br>
            <button>로그인</button>
        </form>
    <% } else { %>
    <h2>무엇을 하러 오셨나요?</h2>
    <section>
        <a href="<%= request.getContextPath()%>/info">정보 보기</a>
        <a href="<%= request.getContextPath()%>/post">글 쓰기</a>
    </section>
    <section>
        <%-- 전체 글 목록 --%>
        <%
            List<PostWithNicknameDTO> posts = (List<PostWithNicknameDTO>) request.getAttribute("posts");
            for (PostWithNicknameDTO p : posts) { %>
            별명 : <%= p.nickname() %><br>
            게시글ID : <%= p.postId() %><br>
            제목 : <%= p.title() %><br>
            내용 : <%= p.content() %><br>
            추천수 : <%= p.recommendCnt() %><br>
            나의 추천 : <%= p.myRecommend() %><br>
        <hr>
        <% } %>
    </section>
    <% } %>
</body>
</html>
