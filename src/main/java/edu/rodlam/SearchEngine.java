package edu.rodlam;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SearchEngine {
    private HttpClient httpClient;
    private HttpResponse<String> lastResponse;

    SearchEngine() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public void search(String query) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(java.net.URI.create("https://en.wikipedia.org/w/api.php?action=query&list=search&format=json&srsearch=" + query))
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            this.lastResponse = response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public String getResults() {
        return this.lastResponse.statusCode() == 200 ? this.lastResponse.body() : "";
    }
}
