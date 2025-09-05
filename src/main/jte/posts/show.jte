@import org.example.hexlet.dto.posts.PostPage
@import org.example.hexlet.util.NamedRoutes
@param PostPage page

@template.layout.page(
content = @`
    <main>
        <div class="mx-auto p-4 py-md-5">
            <h1>${page.getPost().getName()}</h1>
        </div>

        <div class="mx-auto p-4 py-md-5">
            ${page.getPost().getBody()}
        </div>
        <!-- BEGIN (write your solution here) -->
        <a href="${NamedRoutes.editPostPath(page.getPost().getId())}">Редактировать</a>
        <!-- END -->
    </main>
`
)
