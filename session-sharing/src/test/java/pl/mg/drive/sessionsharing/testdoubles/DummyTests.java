package pl.mg.drive.sessionsharing.testdoubles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Dummy article is returned as it is not implemented yey and is not subject of the tests.
 */
public class DummyTests {

    @Test
    public void shouldReturnZeroIfNoArticles() {
        Blog blog = new Blog();
        assertEquals(blog.numberOfArticles(), 0);
    }

    @Test
    public void shouldReturnNumberOfArticlesOnBlog() {
        Blog blog = new Blog();
        blog.addArticle(getDummyArticle());
        blog.addArticle(getDummyArticle());
        blog.addArticle(getDummyArticle());

        assertEquals(blog.numberOfArticles(), 3);
    }

    private static Article getDummyArticle() {
        return new Article();
    }

}
