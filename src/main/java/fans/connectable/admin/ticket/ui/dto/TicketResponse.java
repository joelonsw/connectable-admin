package fans.connectable.admin.ticket.ui.dto;

import fans.connectable.admin.ticket.domain.Ticket;
import fans.connectable.admin.utils.JsonConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponse {

    private Long id;
    private Integer price;
    private Map<String, Object> ticketMetadata;
    private String ticketSalesStatus;
    private Long tokenId;
    private String tokenUri;
    private Long eventId;

    public static TicketResponse of(Ticket ticket) {
        return new TicketResponse(
            ticket.getId(),
            ticket.getPrice(),
            JsonConverter.stringToJson(ticket.getTicketMetadata()).toMap(),
            ticket.getTicketSalesStatus(),
            ticket.getTokenId(),
            ticket.getTokenUri(),
            ticket.getEventId()
        );
    }
}
