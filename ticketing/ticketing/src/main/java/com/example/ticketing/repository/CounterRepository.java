// author: Priscilla Tham
// Date: 29/8/2022

package com.example.ticketing.repository;

public interface CounterRepository {

    /**
     * Make the counter available when done serving
     * @param id The counter's id
     */
    void makeAvailable(int id);

    /**
     * Make counter serve when available
     * @param id The counter's id
     */
    void makeServing(int id);

    /**
     * Make counter online when offline
     * Assumes offline counters as non-existing, and create a new counter of ID = [id] to go online
     * @param id The counter's id
     */
    void goOnline(int id);

    /**
     * Make counter offline when online
     * Assumes online counters as existing, and removes them from the database to go offline
     * @param id The counter's id
     */
    void goOffline(int id);
}
