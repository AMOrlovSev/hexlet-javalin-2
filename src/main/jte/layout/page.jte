@import gg.jte.Content
@import org.example.hexlet.NamedRoutes
@param Content content
@param Content footer = null

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hexlet Javalin Example</title>
</head>
<body>
<p>
    <a href="${NamedRoutes.coursesPath()}">Курсы</a>
    <a href="${NamedRoutes.usersPath()}">Пользователи</a>
</p>
${content}
@if (footer != null)
    <div class="footer">
        ${footer}
    </div>
@endif
</body>
</html>