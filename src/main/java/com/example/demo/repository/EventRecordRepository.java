Public interface EventRecordRepository extends
JpaRepository<EventRecord, Long>{
    boolean existsByEventCode(String eventCode);
    Optional<EventRecord>findByEventCode(String eventCode);
}