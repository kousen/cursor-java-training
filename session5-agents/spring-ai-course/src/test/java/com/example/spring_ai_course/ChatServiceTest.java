package com.example.spring_ai_course;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ChatServiceTest {

    private static final Logger log = LoggerFactory.getLogger(ChatServiceTest.class);

    @Autowired
    private ChatService chatService;

    @Test
    void chat_ShouldReturnResponse() {
        String result = chatService.chat("Say hello in one sentence");
        
        assertThat(result)
            .isNotNull()
            .isNotEmpty()
            .startsWith("Hello");
    }

    @Test
    void chat_messages_are_stateless() throws IOException {
        String result1 = chatService.chat("My name is Jean-Luc Picard");
        String result2 = chatService.chat("What is my name?");
        
        // Print to console (visible in Gradle output)
        System.out.println("\n=== First Response ===");
        System.out.println(result1);
        System.out.println("\n=== Second Response ===");
        System.out.println(result2);
        System.out.println();
        
        // Log output (visible in IDE console if configured)
        log.info("=== First Response ===");
        log.info(result1);
        log.info("=== Second Response ===");
        log.info(result2);
    
        // Assertions to verify statelessness - second response should NOT know the name
        assertThat(result2)
            .as("Second response should not know the name from first message (stateless): %s", result2)
            .doesNotContain("Jean-Luc", "Picard");
    }
}

