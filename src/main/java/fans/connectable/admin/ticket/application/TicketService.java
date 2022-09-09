package fans.connectable.admin.ticket.application;

import fans.connectable.admin.ticket.dao.TicketDao;
import fans.connectable.admin.ticket.domain.Ticket;
import fans.connectable.admin.ticket.ui.dto.TicketResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketDao ticketDao;

    public TicketResponse findById(Long ticketId) {
        Optional<Ticket> ticket = ticketDao.findById(ticketId);
        if (ticket.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 티켓 id");
        }
        return TicketResponse.of(ticket.get());
    }
}
