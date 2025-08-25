@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>${page.getCourse().getName()}</h1>
            <p>${page.getCourse().getDescription()}</p>
        </main>
    </div>
`
)