package fans.connectable.admin.event.ui;

import fans.connectable.admin.auth.AuthRequired;
import fans.connectable.admin.event.application.EventService;
import fans.connectable.admin.event.ui.dto.EventResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @AuthRequired
    @GetMapping("/events")
    public ResponseEntity<List<EventResponse>> findAllEvents() {
        List<EventResponse> events = eventService.findAllEvents();
        return ResponseEntity.ok(events);
    }
}
