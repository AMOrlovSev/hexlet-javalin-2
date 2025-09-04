@import org.example.hexlet.dto.MainPage
@param MainPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>Здорова!</h1>
            @if(!page.isVisited())
                Это сообщение показывается только один раз. Если вы хотите увидеть его снова, сотрите куки
            @endif
        </main>
    </div>
`,
footer = @`
    <p>Thanks for visiting, come again soon!</p>
`
)