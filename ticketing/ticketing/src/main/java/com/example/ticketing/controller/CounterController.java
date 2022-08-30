// author: Priscilla Tham
// Date: 29/8/2022

package com.example.ticketing.controller;

import com.example.ticketing.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// enabling cross origin to allow GET and POST calls from different local host
@CrossOrigin
@RequestMapping("api/v1/counter")
@RestController
public class CounterController {

    private final CounterService counterService;
    private final TicketController ticketController;

    // autowire relationships for dependency injection
    @Autowired
    public CounterController(CounterService counterService, TicketController ticketController) {
        this.counterService = counterService;
        this.ticketController = ticketController;
    }

    /**
     * Marks the current ticket being served as complete
     * Ticket will have already been dequeued (removed) from queue (database)
     * Upon marking, counter will be available
     * @param id The counter's id
     */
    @PostMapping("/complete-current/{id}")
    public void completeCurrent(@PathVariable("id") int id) {
        counterService.completeCurrent(id);
    }

    /**
     * Pick up the next first-in ticket from the waiting queue
     * Upon getting the ticket, counter will be busy and ticket will be dequeue (removed) from the queue (database)
     * @param id The counter's id
     * @return The ticket number as string or a message if no tickets in waiting queue
     */
    @PostMapping("call-next/{id}")
    public String callNext(@PathVariable("id") int id) {
        if (ticketController.getTicketCount() > 0) {
            counterService.callNext(id);
            // Now Serving: latest ticket number removed from the waiting queue
            // Current Number of Counter [id]: the ticket number the counter currently serving
            return ticketController.dequeueTicket().getTicketNumber().toString();
        } else {
            return "No tickets in the waiting queue";
        }
    }

    @PostMapping("go-online/{id}")
    public void goOnline(@PathVariable("id") int id) {
        counterService.goOnline(id);
    }

    @PostMapping("go-offline/{id}")
    public void goOffline(@PathVariable("id") int id) {
        counterService.goOffline(id);
    }
}
