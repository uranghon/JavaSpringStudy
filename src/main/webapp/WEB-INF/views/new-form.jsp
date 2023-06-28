<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
    </head>
<body>
<!-- 상대경로 사용, [현재 URL이 속한 계층 경로 + /save] -->
<!-- action="/save" 인거랑 action="save" 인거랑 경로가 다르다 -->
<!-- action="/save" 일경우 url 뒤에 바로 /save 가 붙고 -->
<!-- action="save" 일경우 url 뒤에 save를 호출한 페이지와 같은 상위경로가 붙고 그 뒤에 /save 가 붙는다 -->
<!-- 이번 예제에서는 "/servlet-mvc/members/new-form" 에서 호출한거라 "/servlet-mvc/members/save" 가 된다 -->
<!-- action 이 경로
     거기에 /로 시작하면 절대경로
     바로 리소스부터 시작하면 상대경로
     상대경로일경우 현재 페이지와 같은 레벨에서 호출
     근데 어지간한 상황에서는 절대경로로 호출하는게 좋다고 한다 -->
<form action="save" method="post">
    username: <input type="text" name="username" />
    age: <input type="text" name="age" />
    <button type="submit">전송</button>
</form>
</body>
</html>