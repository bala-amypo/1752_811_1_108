public interface DynamicPricingEngineService{
    DynamicPriceRecord computeDynamicPrice(Long eventId);
    List<DynamicPriceRecord> getPriceHistory(Long eventId);
    DynamicPriceRecord getLatestPrice(Long eventId);
    List<DynamicPriceRecord>getAllComputedPrices();
}