// author: Priscilla Tham
// Date: 29/8/2022

package com.example.ticketing.service;

import com.example.ticketing.model.Ticket;
import com.example.ticketing.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket queueTicket() {
        return ticketRepository.queueTicket();
    }

    public Ticket dequeueTicket() {
        return ticketRepository.dequeueTicket();
    }

    public int getTicketCount() {
        return ticketRepository.getTicketCount();
    }
}
