package com.nvminh162.springai.config;

import com.nvminh162.springai.model.Booking;
import com.nvminh162.springai.repository.BookingRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    @Autowired
    private BookingRepository bookingRepository;

    @PostConstruct
    public void init() {
        try {
            // Xóa tất cả dữ liệu cũ để seed lại từ đầu
            bookingRepository.deleteAll();
            logger.info("Cleared existing booking data");

            // Seed sample booking data
            Booking booking1 = new Booking(
                "ABC123",
                "Nguyen",
                "Van A",
                "Hanoi",
                "Ho Chi Minh City",
                "2025-11-15",
                2,
                "Economy"
            );

            Booking booking2 = new Booking(
                "XYZ789",
                "Tran",
                "Thi B",
                "Ho Chi Minh City",
                "Tokyo",
                "2025-12-20",
                1,
                "Business"
            );

            Booking booking3 = new Booking(
                "DEF456",
                "Le",
                "Van C",
                "Da Nang",
                "Singapore",
                "2025-11-25",
                3,
                "Economy"
            );

            Booking booking4 = new Booking(
                "GHI789",
                "Pham",
                "Thi D",
                "Hanoi",
                "Bangkok",
                "2025-12-10",
                1,
                "Premium Economy"
            );

            Booking booking5 = new Booking(
                "JKL012",
                "Hoang",
                "Van E",
                "Ho Chi Minh City",
                "Seoul",
                "2025-12-05",
                2,
                "Business"
            );

            bookingRepository.save(booking1);
            bookingRepository.save(booking2);
            bookingRepository.save(booking3);
            bookingRepository.save(booking4);
            bookingRepository.save(booking5);

            logger.info("Successfully seeded {} booking records", bookingRepository.count());
        } catch (Exception e) {
            logger.error("Failed to seed booking data: {}", e.getMessage(), e);
        }
    }
}

