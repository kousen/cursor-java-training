package com.example.spring_ai_course;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatClient chatClient;

    @Value("classpath:/prompts/joke.st")
    private final Resource jokeTemplate;

    public ChatController(ChatClient.Builder chatClientBuilder,
                          @Value("classpath:/prompts/joke.st") Resource jokeTemplate) {
        this.chatClient = chatClientBuilder.build();
        this.jokeTemplate = jokeTemplate;
    }

    @GetMapping("/chat")
    public String chat(@RequestParam String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }

    @GetMapping("/expert")
    public String expertChat(@RequestParam String topic) {
        return chatClient.prompt()
                .system("""
                        You are an expert software architect
                        specializing in Spring Boot applications.
                        Provide concise, practical advice and
                        respond as though you were a pirate.
                        """)
                .user("How do I implement " + topic)
                .call()
                .content();
    }

    @GetMapping("/joke")
    public String joke(@RequestParam String topic, @RequestParam String style) {
        return chatClient.prompt()
                .user(u -> u.text(jokeTemplate)
                    .param("topic", topic)
                    .param("style", style))
                .call()
                .content();
    }

    @GetMapping("/chat/review")
    public BookReview review(@RequestParam String bookTitle) {
        return chatClient.prompt()
                .user("Write a book review for " + bookTitle + 
                      ". Include a title, a rating from 1 to 5, and a summary.")
                .call()
                .entity(BookReview.class);
    }
}
