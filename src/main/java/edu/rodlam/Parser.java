package edu.rodlam;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.List;
import java.util.ArrayList;

public class Parser {

    private List<SearchResult> results = new ArrayList<>();

    public String parse(){

        <SearchResult> results = new ArrayList<>();
        
        JsonObject root = JsonParser.parseString(json).getAsJsonArray("search")
            Array results = root.getAsJsonObject("query").g
            (JsonElement element : articles) {
            JsonObject article = element.getAsJsonObject()
            String title = article.get("title").getAsString()
            int pageId = article.get("pageid").getAsInt();

             results.add(new SearchResult(title, pageId));

            }
    }
        
    public List<SearchResult> getResults() {
       return results;
    }
}
