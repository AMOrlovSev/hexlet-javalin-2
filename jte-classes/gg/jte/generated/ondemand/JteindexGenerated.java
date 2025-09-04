package gg.jte.generated.ondemand;
import org.example.hexlet.dto.MainPage;
@SuppressWarnings("unchecked")
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,1,3,3,6,6,10,10,12,12,15,15,15,15,17,17,17,17,17,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"mx-auto p-4 py-md-5\">\r\n        <main>\r\n            <h1>Здорова!</h1>\r\n            ");
				if (!page.isVisited()) {
					jteOutput.writeContent("\r\n                Это сообщение показывается только один раз. Если вы хотите увидеть его снова, сотрите куки\r\n            ");
				}
				jteOutput.writeContent("\r\n        </main>\r\n    </div>\r\n");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <p>Thanks for visiting, come again soon!</p>\r\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage page = (MainPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
