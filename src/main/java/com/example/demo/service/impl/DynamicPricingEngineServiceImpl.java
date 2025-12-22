package com.example.demo.service.impl;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.entity.DynamicPriceRecord;
import com.example.demo.entity.EventRecord;
import com.example.demo.entity.PriceAdjustmentLog;
import com.example.demo.entity.PricingRule;
import com.example.demo.entity.SeatInventoryRecord;

import com.example.demo.repository.DynamicPriceRecordRepository;
import com.example.demo.repository.EventRecordRepository;
import com.example.demo.repository.PriceAdjustmentLogRepository;
import com.example.demo.repository.PricingRuleRepository;
import com.example.demo.repository.SeatInventoryRecordRepository;

import com.example.demo.service.DynamicPricingEngineService;
