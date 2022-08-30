// author: Priscilla Tham
// Date: 29/8/2022

package com.example.ticketing.controller;

import com.example.ticketing.model.Ticket;
import com.example.ticketing.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("api/v1/ticket")
@RestController
public class TicketController {

    private final TicketService ticketService;

    // autowire relationships for dependency injection
    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    /**
     * Generates a ticket number
     * @return The ticket
     */
    @PostMapping
    public Ticket queueTicket() {
        // Last Number: the latest ticket number to be issued
        return ticketService.queueTicket();
    }

    /**
     * Removes ticket from the database
     * @return The ticket
     */
    @PostMapping("/dequeue")
    public Ticket dequeueTicket() {
        return ticketService.dequeueTicket();
    }

    @GetMapping
    public int getTicketCount() {
        return ticketService.getTicketCount();
    }
}
