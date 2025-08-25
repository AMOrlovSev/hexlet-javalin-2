package gg.jte.generated.ondemand.courses;
@SuppressWarnings("unchecked")
public final class JtebuildGenerated {
	public static final String JTE_NAME = "courses/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,0,2,2,18,18,18,18,18,18,18,18};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <form action=\"/courses\" method=\"post\">\r\n        <div>\r\n            <label>\r\n                Название\r\n                <input type=\"text\" required name=\"name\" />\r\n            </label>\r\n        </div>\r\n        <div>\r\n            <label>\r\n                Описание\r\n                <input type=\"text\" name=\"description\" />\r\n            </label>\r\n        </div>\r\n        <input type=\"submit\" value=\"Добавить\" />\r\n    </form>\r\n");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
