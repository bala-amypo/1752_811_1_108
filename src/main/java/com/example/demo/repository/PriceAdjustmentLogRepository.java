public interface PriceAdjustmentLogRepository extends
JpaRepository<PriceAdjustmentLogRepository, Long>{
    List<PriceAdjustmentLog> findByEventId(Long eventId);
}