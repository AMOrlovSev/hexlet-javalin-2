@import org.example.hexlet.dto.users.UserPage
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
    <p>Thanks for visiting, come again soon!</p>
`
)