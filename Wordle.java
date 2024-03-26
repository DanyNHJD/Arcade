/*
 *  Class to get a 5 letter word from an API and sort it
 *  to a char format for users to guess.
 *  To make it a char array, use word.toCharArray();
 */

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Wordle {
    private static String word;
    
    public Wordle() {
        newWord();
    }

    public static void newWord() {
        // Call for a 5 letter word
        System.out.println("Calling for a random word... Please wait.");
        try {
            HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .uri(URI.create("https://random-word-api.herokuapp.com/word?length=5"))
            .build();
        
            HttpResponse<String> response = HttpClient.newHttpClient()
	            .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) { // If request doesn't succeed
                System.out.println("Unable to fetch a random word! Are you connected to the internet?");
            }
            // Save response 
            word = response.body();
            word = word.substring(2, word.length() - 2);
        } 
        catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getWord() {
        return word;
    }
}
