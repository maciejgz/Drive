package pl.mg.drive.sessionsharing.testdoubles;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SpyTests {

    @Spy
    private Article article;

    @Test
    public void shouldPublishArticle() {
        PublishedArticleEvent event = new PublishedArticleEvent(article);

        event.process();

        //verify if the method was executed only once
        verify(article).published();
    }
}
