package edu.rodlam;

import java.io.IOException;

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


            cui.displayResults(wikiClient.getResults());

            int choice = cui.getUserChoice();

            browser.open(wikiClient.getResults().get(choice).getUrl());


            running = cui.askContinue();
        }
    }

    public void run() throws IOException {
        mainLoop();
    }
}