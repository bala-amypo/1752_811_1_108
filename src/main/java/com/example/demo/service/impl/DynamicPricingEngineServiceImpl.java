package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DynamicPricingEngineServiceImpl {

    public void process(List<Integer> numbers) {
        // make 'sum' final / effectively final by using array or wrapper
        final int[] sum = {0};

        numbers.forEach(n -> sum[0] += n);

        System.out.println("Total sum: " + sum[0]);
    }
}
