package pl.mg.drive.sessionsharing.testdoubles;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class QueueTests {

    private FakeStore store;
    private Queue queue;

    @Before
    public void init() {
        store = new FakeStore();
        queue = new StoredQueue(store);
    }

    @Test
    public void shouldAddEvent() {
        queue.add(dummyEvent());
        queue.add(dummyEvent());

        assertEquals(store.size(), 2);
    }

    private Event spiedEvent() {
        return mock(Event.class);
    }

    @Test
    public void shouldProcessAll() {
        Event event1 = spiedEvent();
        Event event2 = spiedEvent();
        store.add(event1);
        store.add(event2);

        when(event1.getText()).thenReturn("bbb");
        System.out.println(event1.getText());

        queue.processAll();
        verify(event1).getText();
        verify(event1).process();
        verify(event2).process();
    }

    @Test
    public void spyEventBehaviour() {
        PublishedArticleEvent event = new PublishedArticleEvent(getDummyArticle());
        PublishedArticleEvent eventSpy = Mockito.spy(event);
        assertEquals("sss", eventSpy.getText());
        verify(eventSpy).getText();
    }

    private static Article getDummyArticle() {
        return new Article();
    }


    private Event dummyEvent() {
        return mock(Event.class);
    }


    /**
     * Fake object with dumb implementation of the real functionality.
     */
    private class FakeStore implements Store {
        private final List<Event> events = new ArrayList<>();

        @Override
        public void add(Event event) {
            events.add(event);
        }

        @Override
        public List<Event> getAll() {
            return events;
        }

        public int size() {
            return events.size();
        }
    }
}
