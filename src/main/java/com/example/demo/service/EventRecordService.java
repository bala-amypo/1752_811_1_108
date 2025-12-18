public interface EventRecordService{
    EventRecord creatEvent(EventRecord event);
    EventRecord getEventById(Long id);
    EventRecord getEventByCode(String eventCode);
    List<EventRecord>getAllEvents();
    EventRecord UpdateEventStatus(Long id,boolean active);
}