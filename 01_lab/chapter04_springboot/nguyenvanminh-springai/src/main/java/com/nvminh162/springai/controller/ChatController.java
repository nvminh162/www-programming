package com.nvminh162.springai.controller;

import com.nvminh162.springai.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private AiService aiService;

    @PostMapping
    public ResponseEntity<String> chat(@RequestBody String userInput) {
        String response = aiService.processUserInput(userInput);
        return ResponseEntity.ok(response);
    }
}

