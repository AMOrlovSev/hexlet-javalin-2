@import org.example.hexlet.dto.posts.PostsPage
@import org.example.hexlet.NamedRoutes
@param PostsPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>Все посты</h1>

            <div class="mb-3">
                <a href="${NamedRoutes.buildPostPath()}">Create new post</a>
            </div>

            <table class="table table-striped">
                @for(var post : page.getPosts())
                    <tr>
                        <td>
                            ${post.getId()}
                        </td>
                        <td>
                            <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
                        </td>
                        <td>
                            ${post.getBody()}
                        </td>
                    </tr>
                @endfor
            </table>
        </main>
    </div>
`
)
