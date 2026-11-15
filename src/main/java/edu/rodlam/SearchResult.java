package edu.rodlam;

public record SearchResult(String title, int pageId) {
    public String getUrl(){
        return "https://ru.wikipedia.org/w/index.php?curid=" + pageId;
    }
    public String getTitle(){
        return title();
    }
}
