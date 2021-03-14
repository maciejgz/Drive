package pl.mg.drive.sessionsharing.testdoubles;

public class StoredQueue implements Queue {

    private Store store;

    public StoredQueue(Store store) {
        this.store = store;
    }

    @Override
    public void add(Event event) {
        store.add(event);
    }

    @Override
    public void processAll() {
        for (Event event : store.getAll()) {

            event.process();
        }
    }

    @Override
    public void processAll(EventPredicate eventPredicate) {
        for (Event event : store.getAll()) {
            if (eventPredicate.isSatisfiedBy(event)) {
                event.process();
            }
        }
    }
}
