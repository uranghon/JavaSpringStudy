<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
    성공
    <%--
        <ul>
            <li>id=<%=((Member)request.getAttribute("member")).getId()%></li>
            <li>username=<%=((Member)request.getAttribute("member")).getUsername()%></li>
            <li>age=<%=((Member)request.getAttribute("member")).getAge()%></li>
        </ul>
    --%>
    <!-- 위 내용을 아래처럼 바꿀 수 있다. 프로퍼티 접근법 활용한다 -->
    <ul>
        <li>id=${member.id}</li>
        <li>username=${member.username}</li>
        <li>age=${member.age}</li>
    </ul>
    <a href="/index.html">메인</a>
</body>
</html>

