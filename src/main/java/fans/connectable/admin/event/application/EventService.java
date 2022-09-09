package fans.connectable.admin.event.application;

import fans.connectable.admin.event.dao.EventDao;
import fans.connectable.admin.event.domain.Event;
import fans.connectable.admin.event.ui.dto.EventResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventDao eventDao;

    public List<EventResponse> findAllEvents() {
        List<Event> events = eventDao.findAllEvents();
        return EventResponse.toList(events);
    }
}
