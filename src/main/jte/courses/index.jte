@import org.example.hexlet.util.NamedRoutes
@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(
page = page,
content = @`
    <h1>Курсы</h1>
    @if(page.getFlash() != null)
        <p>${page.getFlash()}</p>
    @endif
    <form action="${org.example.hexlet.util.NamedRoutes.coursesPath()}" method="get">
        <input type="search" name="term" value="${page.getTerm()}" />
        <input type="submit" value="Search" />
    </form>
    @if(page.getCourses().isEmpty())
        <p>Пока не добавлено ни одного курса</p>
    @else
        @for(var course : page.getCourses())
            <div>
                <h2><a href="${NamedRoutes.coursePath(course.getId())}">${course.getName()}</a></h2>
                <p>${course.getDescription()}</p>
            </div>
        @endfor
    @endif
    <div>
        <a href="${org.example.hexlet.util.NamedRoutes.buildCoursePath()}">Добавить курс</a>
    </div>
`
)