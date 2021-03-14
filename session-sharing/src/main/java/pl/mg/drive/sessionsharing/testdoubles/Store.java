package pl.mg.drive.sessionsharing.testdoubles;

import java.util.List;

public interface Store {

    void add(Event event);

    List<Event> getAll();
}
