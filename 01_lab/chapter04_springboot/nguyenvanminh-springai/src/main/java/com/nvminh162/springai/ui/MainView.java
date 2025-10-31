package com.nvminh162.springai.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import org.springframework.web.client.RestTemplate;

@Route("")
public class MainView extends VerticalLayout {

    private final RestTemplate restTemplate = new RestTemplate();
    private final TextArea inputArea = new TextArea("Nhập câu hỏi:");
    private final Button sendButton = new Button("Gửi");
    private final TextArea responseArea = new TextArea("Phản hồi từ AI:");

    public MainView() {
        // UI Configuration
        inputArea.setWidthFull();
        responseArea.setWidthFull();
        responseArea.setReadOnly(true);

        // Event listener for send button
        sendButton.addClickListener(e -> {
            String prompt = inputArea.getValue();
            if (prompt != null && !prompt.trim().isEmpty()) {
                try {
                    String response = restTemplate.postForObject(
                            "http://localhost:8090/chat",
                            prompt,
                            String.class
                    );
                    responseArea.setValue(response != null ? response : "Không có phản hồi từ server.");
                } catch (Exception ex) {
                    responseArea.setValue("Lỗi: " + ex.getMessage());
                }
            }
        });

        // Layout assembly
        add(new H1("Flight Booking Assistant"));
        add(inputArea, sendButton, responseArea);
        setPadding(true);
        setSpacing(true);
        setSizeFull();
    }
}

