// author: Priscilla Tham
// Date: 29/8/2022

package com.example.ticketing.service;

import com.example.ticketing.repository.CounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CounterService {

    private final CounterRepository counterRepository;

    @Autowired
    public CounterService(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    public void completeCurrent(int id) {
        counterRepository.makeAvailable(id);
    }

    public void callNext(int id) {
        counterRepository.makeServing(id);
    }

    public void goOnline(int id) {
        counterRepository.goOnline(id);
    }

    public void goOffline(int id) {
        counterRepository.goOffline(id);
    }
}
