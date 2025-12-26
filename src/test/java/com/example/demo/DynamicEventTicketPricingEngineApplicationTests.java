package com.example.demo;

import com.example.demo.model.EventRecord;
import com.example.demo.model.SeatInventoryRecord;
import com.example.demo.repository.EventRecordRepository;
import com.example.demo.repository.SeatInventoryRecordRepository;
import com.example.demo.service.EventRecordService;
import com.example.demo.service.impl.EventRecordServiceImpl;
import com.example.demo.service.impl.SeatInventoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DynamicEventTicketPricingEngineApplicationTests {

    @Autowired
    private EventRecordRepository eventRepo;

    @Autowired
    private SeatInventoryRecordRepository seatInventoryRepo;

    private EventRecordService eventRecordService;
    private SeatInventoryServiceImpl seatInventoryService;

    @BeforeEach
    void setup() {
        eventRecordService = new EventRecordServiceImpl(eventRepo);
        seatInventoryService = new SeatInventoryServiceImpl(seatInventoryRepo);
    }

    @Test
    void testCreateEventAndInventory() {
        EventRecord event = new EventRecord("EVT123", "Spring Conference", "Auditorium A", true, 100);
        eventRecordService.saveEvent(event);

        SeatInventoryRecord inv = new SeatInventoryRecord(event, 200, 200);
        seatInventoryService.saveInventory(inv);

        Optional<EventRecord> foundEvent = eventRecordService.getEventByCode("EVT123");
        assertTrue(foundEvent.isPresent());
        assertEquals("Spring Conference", foundEvent.get().getEventName());

        int availableSeats = seatInventoryService.calculateAvailableSeats(event);
        assertEquals(200, availableSeats);
    }

    @Test
    void testUpdateEventStatusAndSeats() {
        EventRecord event = new EventRecord("EVT456", "Java Workshop", "Hall B", true, 150);
        eventRecordService.saveEvent(event);

        SeatInventoryRecord inv = new SeatInventoryRecord(event, 100, 100);
        seatInventoryService.saveInventory(inv);

        eventRecordService.updateEventStatus(event.getEventId(), false);
        EventRecord updated = eventRecordService.getEventByCode("EVT456").get();
        assertFalse(updated.isActive());

        seatInventoryService.updateRemainingSeats(event, 10);
        int remaining = seatInventoryService.calculateAvailableSeats(event);
        assertEquals(90, remaining);
    }
}
