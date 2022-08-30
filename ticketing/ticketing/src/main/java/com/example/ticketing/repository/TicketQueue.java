// author: Priscilla Tham
// Date: 29/8/2022

package com.example.ticketing.repository;

import com.example.ticketing.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// encapsulates the ticket database, get and search behaviour
@Repository
public class TicketQueue implements TicketRepository {

    private int itemCount = 0;

    // ticket database
    private List<Ticket> queue = new ArrayList<Ticket>();

    /**
     * Adds ticket to queue (database) when generated
     * @return The ticket
     */
    @Override
    public Ticket queueTicket() {
        Ticket ticket = new Ticket(UUID.randomUUID());
        queue.add(ticket);
        itemCount += 1;
        return ticket;
    }

    /**
     * Removes ticket from queue (database) when served
     * @return The ticket
     */
    @Override
    public Ticket dequeueTicket() {
        Ticket servedTicket = queue.remove(0);
        itemCount -= 1;
        return servedTicket;
    }

    /**
     * Gets the total number of tickets in queue (database)
     * @return Total number of tickets
     */
    @Override
    public int getTicketCount() {
        return itemCount;
    }
}
