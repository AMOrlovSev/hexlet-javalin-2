package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.NamedRoutes;
@SuppressWarnings("unchecked")
public final class JtebuildGenerated {
	public static final String JTE_NAME = "users/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,3,5,5,7,7,10,10,13,13,14,14,15,15,15,16,16,17,17,20,20,22,22,22,22,22,22,22,22,22,25,25,25,25,25,25,25,25,25,30,30,30,30,30,30,30,30,30,44,44,44,44,44,44,44,44,44,46,46,46,46,46,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildUserPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <h1>Создание пользователя</h1>\r\n\r\n    ");
				if (page.getErrors() != null) {
					jteOutput.writeContent("\r\n        <div class=\"alert alert-danger\">\r\n            <ul class=\"mb-0\">\r\n                ");
					for (var entry : page.getErrors().entrySet()) {
						jteOutput.writeContent("\r\n                    ");
						for (var error : entry.getValue()) {
							jteOutput.writeContent("\r\n                        <li>");
							jteOutput.setContext("li", null);
							jteOutput.writeUserContent(error.getMessage());
							jteOutput.writeContent("</li>\r\n                    ");
						}
						jteOutput.writeContent("\r\n                ");
					}
					jteOutput.writeContent("\r\n            </ul>\r\n        </div>\r\n    ");
				}
				jteOutput.writeContent("\r\n\r\n    <form");
				var __jte_html_attribute_0 = NamedRoutes.usersPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\r\n        <div class=\"mb-3\">\r\n            <label class=\"form-label\">Имя</label>\r\n            <input type=\"text\" class=\"form-control\" name=\"name\"");
				var __jte_html_attribute_1 = page.getName() != null ? page.getName() : "";
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" required>\r\n        </div>\r\n\r\n        <div class=\"mb-3\">\r\n            <label class=\"form-label\">Email</label>\r\n            <input type=\"email\" class=\"form-control\" name=\"email\"");
				var __jte_html_attribute_2 = page.getEmail() != null ? page.getEmail() : "";
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_2);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" required>\r\n        </div>\r\n\r\n        <div class=\"mb-3\">\r\n            <label class=\"form-label\">Пароль</label>\r\n            <input type=\"password\" class=\"form-control\" name=\"password\" required>\r\n        </div>\r\n\r\n        <div class=\"mb-3\">\r\n            <label class=\"form-label\">Подтверждение пароля</label>\r\n            <input type=\"password\" class=\"form-control\" name=\"passwordConfirmation\" required>\r\n        </div>\r\n\r\n        <button type=\"submit\" class=\"btn btn-primary\">Создать</button>\r\n        <a");
				var __jte_html_attribute_3 = NamedRoutes.usersPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_3);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" class=\"btn btn-secondary\">Отмена</a>\r\n    </form>\r\n");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildUserPage page = (BuildUserPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
