// author: Priscilla Tham
// Date: 29/8/2022

package com.example.ticketing.repository;

import com.example.ticketing.model.Ticket;

public interface TicketRepository {

    /**
     * Adds ticket to queue (database) when generated
     * @return The ticket
     */
    Ticket queueTicket();

    /**
     * Removes ticket from queue (database) when served
     * @return The ticket
     */
    Ticket dequeueTicket();

    /**
     * Gets the total number of tickets in queue (database)
     * @return Total number of tickets
     */
    int getTicketCount();
}
