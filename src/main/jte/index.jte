@import org.example.hexlet.dto.MainPage
@import org.example.hexlet.util.NamedRoutes
@param MainPage page

@template.layout.page(
content = @`
    @if (page.getCurrentUser() != null)
        <h1 class="mb-3"> Добро пожаловать, ${page.getCurrentUser()}</h1>
        <form action="${NamedRoutes.logoutPath()}" method="post">
            <input type="submit" value="Выйти">
        </form>
    @else
        <h1 class="mb-3"> Добро пожаловать, гость</h1>
        <form action="${NamedRoutes.buildSessionPath()}" method="get">
            <input type="submit" value="Войти">
        </form>
    @endif
`
)