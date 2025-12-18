public interface DynamicPriceRecordRepository extends
JpaRepository<DynamicPriceRecord, Long>{
    List<DynamicPriceRecord> findByEventId(Long eventId);
}