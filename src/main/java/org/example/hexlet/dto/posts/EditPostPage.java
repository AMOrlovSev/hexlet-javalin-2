package org.example.hexlet.dto.posts;

import java.util.List;
import java.util.Map;
import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// BEGIN (write your solution here)
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EditPostPage {
    private Long id;
    private String name;
    private String body;
    private Map<String, List<ValidationError<Object>>> errors;
}
// END
