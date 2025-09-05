@import gg.jte.Content
@import org.example.hexlet.dto.BasePage
@import org.example.hexlet.util.NamedRoutes
@param Content content
@param Content footer = null
@param BasePage page = null

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hexlet Javalin Example</title>
</head>
<body>
@if(page != null && page.getFlash() != null)
    <p>${page.getFlash()}</p>
@endif
<p>
    <a href="${NamedRoutes.coursesPath()}">Курсы</a>
    <a href="${NamedRoutes.usersPath()}">Пользователи</a>
    <a href="${NamedRoutes.postsPath()}">Посты</a>
    <a href="${NamedRoutes.buildSessionPath()}">Сессия</a>
</p>
${content}
@if (footer != null)
    <div class="footer">
        ${footer}
    </div>
@endif
</body>
</html>