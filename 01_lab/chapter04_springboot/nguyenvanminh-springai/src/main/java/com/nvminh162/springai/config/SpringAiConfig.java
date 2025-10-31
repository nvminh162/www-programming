package com.nvminh162.springai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Function;

@Configuration
public class SpringAiConfig {

    @Autowired(required = false)
    private List<Function<?, ?>> functions;

    @Bean
    public ChatClient chatClient(ChatModel chatModel) {
        ChatClient.Builder builder = ChatClient.builder(chatModel)
                .defaultSystem("""
                        You are a helpful flight assistant. Your main job is to help users view their booking details.
                        
                        When a user asks to view booking details and provides:
                        - Booking number (like ABC123, XYZ789, DEF456, GHI789, JKL012)
                        - Customer name (first name and last name, like "Nguyen Van A", "Tran Thi B", etc.)
                        
                        You MUST immediately call the getBookingDetails function with the booking number, first name, and last name provided.
                        Do NOT ask for additional information if the user has already provided booking number and name.
                        Extract the booking number and name from the user's message and call the function directly.
                        
                        Available function:
                        - getBookingDetails: Returns booking details when given bookingNumber (String), firstName (String), and lastName (String).
                        
                        When you get the booking details from the function, present them in a clear and friendly format in Vietnamese.
                        Format: "Mã booking: {number}, Hành khách: {firstName} {lastName}, Từ: {from}, Đến: {to}, Ngày: {date}"
                        
                        If no booking is found (function returns null), inform the user politely that the booking could not be found with the provided information.
                        """)
                .defaultAdvisors(new SimpleLoggerAdvisor());
        
        // Register functions nếu có
        if (functions != null && !functions.isEmpty()) {
            // Spring AI ChatClient sẽ tự động detect functions qua FunctionCallingAdvisor
            // Functions đã được register qua @Bean annotation
        }
        
        return builder.build();
    }
}

