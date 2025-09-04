package gg.jte.generated.ondemand.posts;
import org.example.hexlet.dto.posts.PostsPage;
import org.example.hexlet.NamedRoutes;
@SuppressWarnings("unchecked")
public final class JteindexGenerated {
	public static final String JTE_NAME = "posts/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,2,4,4,6,6,12,12,12,12,12,12,12,12,12,16,16,19,19,19,22,22,22,22,22,22,22,22,22,22,22,22,25,25,25,28,28,32,32,32,33,33,33,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, PostsPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"mx-auto p-4 py-md-5\">\r\n        <main>\r\n            <h1>Все посты</h1>\r\n\r\n            <div class=\"mb-3\">\r\n                <a");
				var __jte_html_attribute_0 = NamedRoutes.buildPostPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">Create new post</a>\r\n            </div>\r\n\r\n            <table class=\"table table-striped\">\r\n                ");
				for (var post : page.getPosts()) {
					jteOutput.writeContent("\r\n                    <tr>\r\n                        <td>\r\n                            ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(post.getId());
					jteOutput.writeContent("\r\n                        </td>\r\n                        <td>\r\n                            <a");
					var __jte_html_attribute_1 = NamedRoutes.postPath(post.getId());
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_1);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(post.getName());
					jteOutput.writeContent("</a>\r\n                        </td>\r\n                        <td>\r\n                            ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(post.getBody());
					jteOutput.writeContent("\r\n                        </td>\r\n                    </tr>\r\n                ");
				}
				jteOutput.writeContent("\r\n            </table>\r\n        </main>\r\n    </div>\r\n");
			}
		}, null);
		jteOutput.writeContent("\r\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		PostsPage page = (PostsPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
