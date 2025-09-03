@import org.example.hexlet.dto.users.UserPage
@import org.example.hexlet.NamedRoutes
@param UserPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h2>${page.getUser().getName()}</h2>
            <div>${page.getUser().getEmail()}</div>
        </main>
    </div>
`,
footer = @`
    <div>
        <a href="${NamedRoutes.editUserPath(page.getUser().getId())}">Редактировать</a> |
        <form action="${NamedRoutes.userPath(page.getUser().getId())}" method="post" style="display: inline;" id="deleteForm">
            <button type="button" onclick="confirmDelete()">Удалить</button>
        </form>
    </div>

    <script>
        function confirmDelete() {
            if (confirm('Вы уверены, что хотите удалить пользователя?')) {
                // Отправляем DELETE запрос напрямую
                fetch('${NamedRoutes.userPath(page.getUser().getId())}', {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                }
            }).then(response => {
                if (response.redirected) {
                    window.location.href = response.url;
                }
            });
        }
    }
    </script>
`
)