package pl.mg.drive.sessionsharing.testdoubles;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StubQueueTest {

    private Store store;
    private Queue queue;

    @Before
    public void init() {
        store = mock(Store.class);
        queue = new StoredQueue(store);
    }

    @Test
    public void shouldProcessAll() {
        Event event1 = spiedEvent();
        Event event2 = spiedEvent();
        List<Event> list = new ArrayList<>();
        list.add(event1);
        list.add(event2);
        when(store.getAll()).thenReturn(list);
        queue.processAll();
        verify(event1).process();
        verify(event2).process();
    }

    private Event spiedEvent() {
        return mock(Event.class);
    }

}
