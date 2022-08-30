// author: Priscilla Tham
// Date: 29/8/2022

package com.example.ticketing.repository;

import com.example.ticketing.model.Counter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// encapsulates the counter database, get and search behaviour
@Repository
public class CounterAccess implements CounterRepository {

    // list of available counters
    private List<Counter> available = new ArrayList<Counter>();
    // list of busy counters
    private List<Counter> serving = new ArrayList<Counter>();

    /**
     * Make the counter available when done serving
     * @param id The counter's id
     */
    @Override
    public void makeAvailable(int id) {
        Optional<Counter> found = serving.stream().filter(counter -> counter.getId() == id).findFirst();
        available.add(found.orElse(null));
        serving.remove(found.orElse(null));
    }

    /**
     * Make counter serve when available
     * @param id The counter's id
     */
    @Override
    public void makeServing(int id) {
        Optional<Counter> found = available.stream().filter(counter -> counter.getId() == id).findFirst();
        serving.add(found.orElse(null));
        available.remove(found.orElse(null));
    }

    /**
     * Make counter online when offline
     * Assumes offline counters as non-existing, and create a new counter of ID = [id] to go online
     * @param id The counter's id
     */
    @Override
    public void goOnline(int id) {
        available.add(new Counter(id));
    }

    /**
     * Make counter offline when online
     * Assumes online counters as existing, and removes them from the database to go offline
     * @param id The counter's id
     */
    @Override
    public void goOffline(int id) {
        Optional<Counter> removable = available.stream().filter(counter -> counter.getId() == id).findFirst();
        available.remove(removable.orElse(null));
        if (!removable.isPresent()) {
            removable = serving.stream().filter(counter -> counter.getId() == id).findFirst();
            serving.remove(removable.orElse(null));
        }
    }


}
