package com.nvminh162.springai.service;

import com.nvminh162.springai.model.BookingDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AiService {

    private static final Logger logger = LoggerFactory.getLogger(AiService.class);

    @Autowired
    private ChatClient chatClient;

    @Autowired
    private BookingService bookingService;

    @Autowired(required = false)
    private VectorStore vectorStore;

    public String processUserInput(String input) {
        logger.info("Processing user input: {}", input);
        
        try {
            // Dùng AI để extract booking number và tên từ user input
            String extractPrompt = String.format(
                """
                Từ câu hỏi sau, hãy extract:
                1. Booking number (mã booking) - thường là chuỗi 6-12 ký tự chữ số/chữ hoa như ABC123, XYZ789
                2. Tên khách hàng (first name và last name)
                
                Câu hỏi: %s
                
                Trả về theo format JSON:
                {
                    "bookingNumber": "ABC123" hoặc null nếu không có,
                    "firstName": "Nguyen" hoặc null nếu không có,
                    "lastName": "Van A" hoặc null nếu không có
                }
                
                CHỈ trả về JSON, không có text khác.
                """, input
            );
            
            String aiResponse = chatClient.prompt()
                    .user(extractPrompt)
                    .call()
                    .content();
            
            logger.info("AI extraction response: {}", aiResponse);
            
            // Parse JSON response từ AI
            String bookingNumber = extractJsonValue(aiResponse, "bookingNumber");
            String firstName = extractJsonValue(aiResponse, "firstName");
            String lastName = extractJsonValue(aiResponse, "lastName");
            
            logger.info("Extracted - Booking: {}, FirstName: {}, LastName: {}", bookingNumber, firstName, lastName);
            
            // Nếu có đủ thông tin thì tìm trong database
            if (bookingNumber != null && firstName != null && lastName != null) {
                BookingDetails booking = bookingService.getBookingDetails(bookingNumber, firstName, lastName);
                
                if (booking != null) {
                    // Có booking - trả về chi tiết
                    return String.format(
                        "Thông tin booking:\n\n" +
                        "Mã booking: %s\n" +
                        "Hành khách: %s %s\n" +
                        "Từ: %s\n" +
                        "Đến: %s\n" +
                        "Ngày: %s",
                        booking.getNumber(),
                        booking.getFirstName(),
                        booking.getLastName(),
                        booking.getFrom(),
                        booking.getTo(),
                        booking.getDate()
                    );
                } else {
                    // Không có booking
                    return "Không tìm thấy booking với mã " + bookingNumber + " cho hành khách " + firstName + " " + lastName;
                }
            }
            
            // Nếu không extract được đủ thông tin, dùng AI để trả lời
            return chatClient.prompt()
                    .user(input)
                    .call()
                    .content();
                    
        } catch (Exception e) {
            logger.error("Error processing user input: {}", e.getMessage(), e);
            return "Xin lỗi, đã xảy ra lỗi khi xử lý yêu cầu của bạn. Vui lòng thử lại sau.";
        }
    }
    
    private String extractJsonValue(String json, String key) {
        try {
            // Đơn giản parse JSON: tìm "key": "value"
            Pattern pattern = Pattern.compile("\"" + key + "\"\\s*:\\s*\"([^\"]+)\"|null");
            Matcher matcher = pattern.matcher(json);
            if (matcher.find()) {
                String value = matcher.group(1);
                if (value != null && !value.equals("null")) {
                    return value;
                }
            }
        } catch (Exception e) {
            logger.warn("Error parsing JSON for key {}: {}", key, e.getMessage());
        }
        return null;
    }

    public void ingestDocument(String content) {
        // Ingest document vào vector store
        // Note: This requires EmbeddingModel to create embeddings
        // Currently disabled because we're using Gemini directly without EmbeddingModel
        if (vectorStore != null) {
            try {
                Document document = new Document(content);
                vectorStore.add(List.of(document));
            } catch (Exception e) {
                logger.warn("Failed to ingest document into vector store: {}", e.getMessage());
            }
        } else {
            logger.debug("VectorStore not available, skipping document ingestion");
        }
    }
}

