@import org.example.hexlet.util.NamedRoutes
@import org.example.hexlet.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
page = page,
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <div class="text-success">
                @if(page.getFlash() != null)
                    <p>${page.getFlash()}</p>
                @endif
            </div>
            <h1>Пользователи</h1>
            <form action="${org.example.hexlet.util.NamedRoutes.usersPath()}" method="get">
                <input type="search" name="term" value="${page.getTerm()}" />
                <input type="submit" value="Search" />
            </form>
            <table class="table table-striped">
                @for(var user : page.getUsers())
                    <tr>
                        <td>
                            ${user.getId()}
                        </td>
                        <td>
                            <a href="${NamedRoutes.userPath(user.getId())}">${user.getName()} ${user.getEmail()}</a>
                        </td>
                    </tr>
                @endfor
            </table>
        </main>
    </div>
    <div>
        <a href="${NamedRoutes.buildUserPath()}">Добавить пользователя</a>
    </div>
`,
footer = @`
    <p>Thanks for visiting, come again soon!</p>
`
)