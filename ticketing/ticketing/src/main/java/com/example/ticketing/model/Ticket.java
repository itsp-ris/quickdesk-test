// author: Priscilla Tham
// Date: 29/8/2022

package com.example.ticketing.model;

import java.util.UUID;

// modelling a ticket as in the real world
// an entity called Ticket
public class Ticket {

    private UUID ticketNumber;

    public Ticket(UUID ticketNumber) {
        // UUID for unique representation
        // primary key of the Ticket Entity
        this.ticketNumber = ticketNumber;
    }

    public UUID getTicketNumber() {
        return ticketNumber;
    }
}
