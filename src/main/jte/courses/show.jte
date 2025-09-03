@import org.example.hexlet.dto.courses.CoursePage
@import org.example.hexlet.NamedRoutes
@param CoursePage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>${page.getCourse().getName()}</h1>
            <p>${page.getCourse().getDescription()}</p>
        </main>
    </div>
`,
footer = @`
    <div>
        <a href="${NamedRoutes.editCoursePath(page.getCourse().getId())}">Редактировать</a> |
        <form action="${NamedRoutes.coursePath(page.getCourse().getId())}" method="post" style="display: inline;" id="deleteForm">
            <button type="button" onclick="confirmDelete()">Удалить</button>
        </form>
    </div>

    <script>
        function confirmDelete() {
            if (confirm('Вы уверены, что хотите удалить пользователя?')) {
                // Отправляем DELETE запрос напрямую
                fetch('${NamedRoutes.coursePath(page.getCourse().getId())}', {
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