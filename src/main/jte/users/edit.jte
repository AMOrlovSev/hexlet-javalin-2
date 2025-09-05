@import org.example.hexlet.dto.users.EditUserPage
@import org.example.hexlet.util.NamedRoutes

@param EditUserPage page

@template.layout.page(
content = @`
    <h1>Редактирование пользователя</h1>

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

    <form id="editForm">
        <!-- убрать method="post" и action -->
        <div class="mb-3">
            <label class="form-label">Имя</label>
            <input type="text" class="form-control" name="name" value="${page.getUser().getName()}" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="email" class="form-control" name="email" value="${page.getUser().getEmail()}" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Пароль (оставьте пустым, если не хотите менять)</label>
            <input type="password" class="form-control" name="password">
        </div>

        <div class="mb-3">
            <label class="form-label">Подтверждение пароля</label>
            <input type="password" class="form-control" name="passwordConfirmation">
        </div>

        <button type="button" onclick="submitForm()" class="btn btn-primary">Обновить</button>
        <a href="${NamedRoutes.userPath(page.getUser().getId())}" class="btn btn-secondary">Отмена</a>
    </form>

    <script>
        function submitForm() {
            const form = document.getElementById('editForm');
            const formData = new FormData();

            formData.append('name', form.querySelector('[name="name"]').value);
            formData.append('email', form.querySelector('[name="email"]').value);
            formData.append('password', form.querySelector('[name="password"]').value);
            formData.append('passwordConfirmation', form.querySelector('[name="passwordConfirmation"]').value);

            fetch('${NamedRoutes.userPath(page.getUser().getId())}', {
        method: 'PATCH',
        body: new URLSearchParams(formData)
    }).then(response => {
        if (response.redirected) {
            window.location.href = response.url;
        }
    });
}
    </script>
`
)