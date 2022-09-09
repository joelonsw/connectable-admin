package fans.connectable.admin.ticket.ui;

import fans.connectable.admin.auth.AuthRequired;
import fans.connectable.admin.ticket.application.TicketService;
import fans.connectable.admin.ticket.ui.dto.TicketResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @AuthRequired
    @GetMapping("/tickets/{ticketId}")
    public ResponseEntity<TicketResponse> getTicket(@PathVariable Long ticketId) {
        TicketResponse ticketResponse = ticketService.findById(ticketId);
        return ResponseEntity.ok(ticketResponse);
    }
}
