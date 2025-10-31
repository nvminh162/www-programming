package com.nvminh162.springai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
    org.springframework.ai.autoconfigure.vectorstore.qdrant.QdrantVectorStoreAutoConfiguration.class
})
public class NguyenvanminhSpringaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NguyenvanminhSpringaiApplication.class, args);
    }

}
