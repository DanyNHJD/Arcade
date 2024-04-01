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
    private static String word = "debug"; // Random word
    private static char[] letters = new char[5]; // Random word in char[]
    private static char[] userGuess = new char[5]; // User guessed word
    private static boolean[] guessTracker = new boolean[5]; // Keep track of letters used

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
            word = word.substring(2, word.length() - 2).toUpperCase();
            letters = word.toCharArray();
        } 
        catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void guess(char[] c) {
        // Check if any of the guessed letters are in the correct spot
        for (int i = 0; i < 5; i++) {
            if (userGuess[i] == letters[i]) {

            }
        }

        // Check if any of the guessed letters are in the random word.
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                
            }
        }
        
    }
    
    public static void resetGame() {
        newWord();

        for (int i = 0; i < 5; i++) {
            guessTracker[i] = false;
        }
    }


    public static String getWord() {
        return word;
    }
}
