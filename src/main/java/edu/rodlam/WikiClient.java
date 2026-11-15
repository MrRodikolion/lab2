package edu.rodlam;

import java.util.List;

public class WikiClient {
    private SearchEngine searchEngine;
    private Parser jparser;

    private List<SearchResult> results;

    WikiClient() {
        this.searchEngine = new SearchEngine();
        this.jparser = new Parser();
    }

    public void search(String query) {
        searchEngine.search(query);
        String results = searchEngine.getResults();
        if (results.isEmpty()) {
            System.out.println("No results found.");
            return;
        }

        jparser.parse(results);
        this.results = jparser.getResults();
    }

    public List<SearchResult> getResults() {
        return results;
    }

}
