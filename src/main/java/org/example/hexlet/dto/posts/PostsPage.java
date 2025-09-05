package org.example.hexlet.dto.posts;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.hexlet.dto.BasePage;
import org.example.hexlet.model.Post;

@AllArgsConstructor
@Getter
public class PostsPage extends BasePage {
    private List<Post> posts;
}
