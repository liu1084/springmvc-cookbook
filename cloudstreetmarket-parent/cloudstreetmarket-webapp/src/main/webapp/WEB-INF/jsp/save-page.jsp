<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String appPath = request.getContextPath();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
test
<button id="save">save page</button>
<a href="<%=appPath%>/page/saveHtml">download</a>
<script src="<%=appPath%>/static/vendor/jquery/dist/jquery.min.js"></script>
<script>
    var appPath = '<%=appPath%>';
    $(function () {
        $('#save').on('click', function () {
            $.get(appPath + '/page/saveHtml', function () {
                console.log('saved!');
			})
		})
	})
</script>
</body>
</html>
