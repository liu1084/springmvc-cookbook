<%--
  Created by IntelliJ IDEA.
  User: jim
  Date: 2017/1/5
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Book create page</title>
</head>
<body>
<div id="jim-page">
  <form>
    <label for="name"><input type="text" value="" id="name"></label>
    <label for="description"><textarea id="description"></textarea></label>
    <label for="cover"><input type="text" value="" id="cover"></label>
    <label for="author"><input type="text" value="" id="author"></label>
    <label for="isbn"><input type="text" value="" id="isbn"></label>
    <label for="year"><input type="text" value="" id="year"></label>
    <label for="pages"><input type="text" value="" id="pages"></label>
    <label for="language"><input type="text" value="" id="language"></label>
    <label for="size"><input type="text" value="" id="size"></label>
    <label for="format"><input type="text" value="" id="format"></label>
    <label for="category">
      <select id="category">
        <option value=""></option>
        <option value=""></option>
        <option value=""></option>
        <option value=""></option>
      </select>
    </label>
    <button>Add</button>
  </form>
</div>
</body>
</html>