package pl.mg.drive.sessionsharing.testdoubles;

import java.util.ArrayList;
import java.util.List;

public class Blog {
    private final List<Article> articles = new ArrayList<>();

    public void addArticle(Article article) {
        articles.add(article);
    }

    public int numberOfArticles() {
        return articles.size();
    }

}
