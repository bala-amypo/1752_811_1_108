package com.example.demo;

import com.example.demo.model.EventRecord;
import com.example.demo.model.SeatInventory;
import com.example.demo.repository.EventRecordRepository;
import com.example.demo.repository.SeatInventoryRepository;
import com.example.demo.service.impl.EventRecordServiceImpl;
import com.example.demo.service.impl.SeatInventoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class DynamicEventTicketPricingEngineApplicationTests {

    @Autowired
    private EventRecordServiceImpl eventService;

    @Autowired
    private SeatInventoryServiceImpl seatService;

    @Test
    void testCreateEventAndSeats() {
        EventRecord event = new EventRecord("EVT123", "Spring Conference", "Auditorium A", true, 100);
        event = eventService.saveEvent(event);

        SeatInventory inventory = new SeatInventory(event, 500, 500);
        seatService.saveInventory(inventory);

        int availableSeats = seatService.calculateAvailableSeats(event);
        assert availableSeats == 500;
    }
}
