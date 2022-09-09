package fans.connectable.admin.event.ui.dto;

import fans.connectable.admin.event.domain.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EventResponse {
    private Long id;
    private String eventName;
    private String description;
    private String contractAddress;
    private String contractName;

    public static EventResponse of(Event event) {
        return new EventResponse(
            event.getId(),
            event.getEventName(),
            event.getDescription(),
            event.getContractAddress(),
            event.getContractName()
        );
    }

    public static List<EventResponse> toList(List<Event> events) {
        return events.stream()
            .map(EventResponse::of)
            .collect(Collectors.toList());
    }
}
