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
<a id="save2">save</a>
<script src="<%=appPath%>/static/vendor/jquery/dist/jquery.min.js"></script>
<script>
    var appPath = '<%=appPath%>';
    $(function () {
        //必须是完整的URL地址
        //downloadUrl = 'http://www.ifeng.com';
        var downloadUrl = window.location.href;
        var path = appPath + '/page/saveHtml?u=' + downloadUrl;
        $('#save2').attr('href', path);
	})
</script>
</body>
</html>
