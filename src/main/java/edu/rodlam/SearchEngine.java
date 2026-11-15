package edu.rodlam;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SearchEngine {
    private HttpClient httpClient;
    private String lastResponse;

    SearchEngine() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public void search(String query) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(java.net.URI.create(
                        "https://ru.wikipedia.org/w/api.php?action=query&list=search&format=json&srsearch=" + query))
                .header("User-Agent", "Lab2WikiSearch/1.0")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response status code: " + response.statusCode());
            if (response.statusCode() == 200) {
                this.lastResponse = response.body();
            }
            else{
                this.lastResponse = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getResults() {
        return this.lastResponse != null ? this.lastResponse : "";
    }
}
