package fans.connectable.admin.ticket.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Ticket {
    private final Long id;
    private final Integer price;
    private final String ticketMetadata;
    private final String ticketSalesStatus;
    private final Long tokenId;
    private final String tokenUri;
    private final Long eventId;

    @Builder
    public Ticket(Long id, Integer price, String ticketMetadata, String ticketSalesStatus, Long tokenId, String tokenUri,
                  Long eventId) {
        this.id = id;
        this.price = price;
        this.ticketMetadata = ticketMetadata;
        this.ticketSalesStatus = ticketSalesStatus;
        this.tokenId = tokenId;
        this.tokenUri = tokenUri;
        this.eventId = eventId;
    }
}
