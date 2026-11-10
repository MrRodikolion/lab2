package edu.rodlam;

import java.util.List;

public class WikiClient {
    private SearchEngine searchEngine;
    private JParser jparser;

    private List<String> results;

    WikiClient() {
        this.searchEngine = new SearchEngine();
        this.jparser = new JParser();
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

    public List<String> getResults() {
        return results;
    }

}
