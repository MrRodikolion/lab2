package edu.rodlam;

import java.io.IOException;
import java.util.List;

public class WikiApp {
    private boolean running;
    private WikiClient wikiClient;
    private ConsoleUI cui;
    private BrowserLaunch browser;

    WikiApp() {
        running = true;
        wikiClient = new WikiClient();
        cui = new ConsoleUI();
        browser = new BrowserLaunch();
    }

    private void mainLoop() throws IOException {
        while (running) {
            String userQuery = cui.getUserQuery();
            wikiClient.search(userQuery);

            List<SearchResult> results = wikiClient.getResults();
            if (results == null || results.isEmpty()) {
                System.out.println("Нет результатов для этого запроса.");
            } else {
                cui.displayResults(results);

                Integer choice = cui.getUserChoice();
                if (choice == null || choice < 0 || choice >= results.size()) {
                    System.out.println("Такого номера нет в списке результатов.");
                } else {
                    browser.open(results.get(choice).getUrl());
                }
            }

            running = cui.askContinue();
        }
    }

    public void run() throws IOException {
        mainLoop();
    }
}