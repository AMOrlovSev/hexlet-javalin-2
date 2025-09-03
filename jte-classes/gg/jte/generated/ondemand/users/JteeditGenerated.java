package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.EditUserPage;
import org.example.hexlet.NamedRoutes;
@SuppressWarnings("unchecked")
public final class JteeditGenerated {
	public static final String JTE_NAME = "users/edit.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,3,5,5,7,7,10,10,13,13,14,14,15,15,15,16,16,17,17,20,20,23,26,26,26,26,26,26,26,26,26,31,31,31,31,31,31,31,31,31,45,45,45,45,45,45,45,45,45,58,58,58,68,68,68,68,68,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, EditUserPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <h1>Редактирование пользователя</h1>\r\n\r\n    ");
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
				jteOutput.writeContent("\r\n\r\n    <form id=\"editForm\">\r\n        ");
				jteOutput.writeContent("\r\n        <div class=\"mb-3\">\r\n            <label class=\"form-label\">Имя</label>\r\n            <input type=\"text\" class=\"form-control\" name=\"name\"");
				var __jte_html_attribute_0 = page.getUser().getName();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" required>\r\n        </div>\r\n\r\n        <div class=\"mb-3\">\r\n            <label class=\"form-label\">Email</label>\r\n            <input type=\"email\" class=\"form-control\" name=\"email\"");
				var __jte_html_attribute_1 = page.getUser().getEmail();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" required>\r\n        </div>\r\n\r\n        <div class=\"mb-3\">\r\n            <label class=\"form-label\">Пароль (оставьте пустым, если не хотите менять)</label>\r\n            <input type=\"password\" class=\"form-control\" name=\"password\">\r\n        </div>\r\n\r\n        <div class=\"mb-3\">\r\n            <label class=\"form-label\">Подтверждение пароля</label>\r\n            <input type=\"password\" class=\"form-control\" name=\"passwordConfirmation\">\r\n        </div>\r\n\r\n        <button type=\"button\" onclick=\"submitForm()\" class=\"btn btn-primary\">Обновить</button>\r\n        <a");
				var __jte_html_attribute_2 = NamedRoutes.userPath(page.getUser().getId());
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_2);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" class=\"btn btn-secondary\">Отмена</a>\r\n    </form>\r\n\r\n    <script>\r\n        function submitForm() {\r\n            const form = document.getElementById('editForm');\r\n            const formData = new FormData();\r\n\r\n            formData.append('name', form.querySelector('[name=\"name\"]').value);\r\n            formData.append('email', form.querySelector('[name=\"email\"]').value);\r\n            formData.append('password', form.querySelector('[name=\"password\"]').value);\r\n            formData.append('passwordConfirmation', form.querySelector('[name=\"passwordConfirmation\"]').value);\r\n\r\n            fetch('");
				jteOutput.setContext("script", null);
				jteOutput.writeUserContent(NamedRoutes.userPath(page.getUser().getId()));
				jteOutput.writeContent("', {\r\n        method: 'PATCH',\r\n        body: new URLSearchParams(formData)\r\n    }).then(response => {\r\n        if (response.redirected) {\r\n            window.location.href = response.url;\r\n        }\r\n    });\r\n}\r\n    </script>\r\n");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		EditUserPage page = (EditUserPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
