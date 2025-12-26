package com.example.demo.repository;

import com.example.demo.model.DynamicPriceRecord;
import java.util.*;

public interface DynamicPriceRecordRepository {
    DynamicPriceRecord save(DynamicPriceRecord rec);
    Optional<DynamicPriceRecord> findFirstByEventIdOrderByComputedAtDesc(Long eventId);
    List<DynamicPriceRecord> findByEventIdOrderByComputedAtDesc(Long eventId);
    List<DynamicPriceRecord> findAll();
}
