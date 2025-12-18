public interface DynamicPriceRecordRepository extends
JpaRepository<DynamicPriceRecord, Long>{
    List<DynamicPriceRecord> findByEvent
}