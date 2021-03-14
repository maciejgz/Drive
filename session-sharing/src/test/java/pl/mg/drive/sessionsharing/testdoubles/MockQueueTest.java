package pl.mg.drive.sessionsharing.testdoubles;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MockQueueTest {

    @Mock
    private EventPredicate predicate;

    @Mock private Store store;
    private Queue queue;

    @Before
    public void init() {
        queue = new StoredQueue(store);
    }

    @Test
    public void shouldProcessOnlyThoseWhichSatisfiesPredicate() {
        Event event1 = spiedEvent();
        Event event2 = spiedEvent();
        Event event3 = spiedEvent();
        when(store.getAll()).thenReturn(asList(event1, event2, event3));
        when(predicate.isSatisfiedBy(event1)).thenReturn(true);
        when(predicate.isSatisfiedBy(event2)).thenReturn(false);
        when(predicate.isSatisfiedBy(event3)).thenReturn(true);

        queue.processAll(predicate);

        then(event1).should().process();
        then(event2).should(never()).process();
        then(event3).should().process();
    }

    private Event spiedEvent() {
        return mock(Event.class);
    }

}
