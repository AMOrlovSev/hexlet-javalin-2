@import org.example.hexlet.dto.users.BuildUserPage
@import org.example.hexlet.util.NamedRoutes

@param BuildUserPage page

@template.layout.page(
content = @`
    <h1>Создание пользователя</h1>

    @if(page.getErrors() != null)
        <div class="alert alert-danger">
            <ul class="mb-0">
                @for(var entry : page.getErrors().entrySet())
                    @for(var error : entry.getValue())
                        <li>${error.getMessage()}</li>
                    @endfor
                @endfor
            </ul>
        </div>
    @endif

    <form action="${org.example.hexlet.util.NamedRoutes.usersPath()}" method="post">
        <div class="mb-3">
            <label class="form-label">Имя</label>
            <input type="text" class="form-control" name="name" value="${page.getName() != null ? page.getName() : ""}" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="email" class="form-control" name="email" value="${page.getEmail() != null ? page.getEmail() : ""}" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Пароль</label>
            <input type="password" class="form-control" name="password" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Подтверждение пароля</label>
            <input type="password" class="form-control" name="passwordConfirmation" required>
        </div>

        <button type="submit" class="btn btn-primary">Создать</button>
        <a href="${org.example.hexlet.util.NamedRoutes.usersPath()}" class="btn btn-secondary">Отмена</a>
    </form>
`
)