package pl.mg.drive.sessionsharing.testdoubles;

public class Article {

    private boolean isPublished;

    public PublishedArticleEvent readyToPublish() {
        return new PublishedArticleEvent(this);
    }

    public void published() {
        this.isPublished = true;
    }
}
