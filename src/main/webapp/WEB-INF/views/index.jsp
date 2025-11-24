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
    </section>
    <% } %>
</body>
</html>
