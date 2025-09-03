package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.NamedRoutes;
@SuppressWarnings("unchecked")
public final class JteshowGenerated {
	public static final String JTE_NAME = "courses/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,2,4,4,7,7,10,10,10,11,11,11,14,14,14,14,16,16,16,16,16,16,16,16,16,17,17,17,17,17,17,17,17,17,25,26,26,26,39,39,39,39,39,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursePage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"mx-auto p-4 py-md-5\">\r\n        <main>\r\n            <h1>");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getCourse().getName());
				jteOutput.writeContent("</h1>\r\n            <p>");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(page.getCourse().getDescription());
				jteOutput.writeContent("</p>\r\n        </main>\r\n    </div>\r\n");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div>\r\n        <a");
				var __jte_html_attribute_0 = NamedRoutes.editCoursePath(page.getCourse().getId());
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">Редактировать</a> |\r\n        <form");
				var __jte_html_attribute_1 = NamedRoutes.coursePath(page.getCourse().getId());
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\" style=\"display: inline;\" id=\"deleteForm\">\r\n            <button type=\"button\" onclick=\"confirmDelete()\">Удалить</button>\r\n        </form>\r\n    </div>\r\n\r\n    <script>\r\n        function confirmDelete() {\r\n            if (confirm('Вы уверены, что хотите удалить пользователя?')) {\r\n                ");
				jteOutput.writeContent("\n                fetch('");
				jteOutput.setContext("script", null);
				jteOutput.writeUserContent(NamedRoutes.coursePath(page.getCourse().getId()));
				jteOutput.writeContent("', {\r\n                method: 'DELETE',\r\n                headers: {\r\n                    'Content-Type': 'application/x-www-form-urlencoded',\r\n                }\r\n            }).then(response => {\r\n                if (response.redirected) {\r\n                    window.location.href = response.url;\r\n                }\r\n            });\r\n        }\r\n    }\r\n    </script>\r\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursePage page = (CoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
