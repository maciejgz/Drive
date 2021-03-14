package pl.mg.drive.sessionsharing.testdoubles;

public interface Queue {

    void add(Event event);

    void processAll();

    void processAll(EventPredicate eventPredicate);
}
