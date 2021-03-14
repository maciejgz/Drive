package pl.mg.drive.sessionsharing.testdoubles;

public class PublishedArticleEvent implements Event {

    private final Article article;

    public PublishedArticleEvent(Article article) {
        this.article = article;
    }


    public void process() {
        article.published();
    }
}
