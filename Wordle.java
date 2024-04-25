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

import javax.swing.JOptionPane;

public class Wordle {
    private static String word; // Random word, defaults at debug for debugging purposes
    private static char[] letters = new char[5]; // Random word in char[]
    private static boolean[] guessTracker = new boolean[5]; // Keep track of letters used
    private static boolean[] validLetter = new boolean[5];

    public static void newWord() {
        // Call for a 5 letter word
        System.out.println("\nCalling for a random word... Please wait.");
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

    // Format the buttons to go green or yellow
    public static void guess(char[] c) {

        // Check if any of the guessed letters are in the correct spot
        for (int i = 0; i < 5; i++) {
            if (c[i] == letters[i]) {
                guessTracker[i] = true;
            }
        }

        // Check if any of the guessed letters are in the random word.
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                // Make sure the correct letter spot doesnt get marked again.
                if (guessTracker[i] != true) {
                    if (c[i] == letters[j]) {
                        validLetter[i] = true;
                    }
                }
                
            }
        }
        
        
    }
    // Check if player has won
    public static void checkWin() {
        // Check if player already guessed multiple times
        if (WordleGame.userGuessAmount() > 24) {
            int reply = JOptionPane.showConfirmDialog(null, 
            "Too bad! The word was: " + Wordle.getWord() +"\nWould you like to play again?",
             ":(!", JOptionPane.YES_NO_OPTION);
        
            if (reply == JOptionPane.YES_OPTION) {
                Wordle.resetGame(); // Reset game.
            } 
            else {
                System.exit(0); // Close game.
            }
            
        }
        
        boolean win = true;
        for (int i = 0; i < 5; i++) {
            if (guessTracker[i] != true) {
                win = false;
            } 
        }
        // If they win, ask if they would like to play again.
        if (win == true) {
            int reply = JOptionPane.showConfirmDialog(null, 
            "Congrats on guessing the word: " + word +"\nWould you like to play again?",
             "Congratulations!", JOptionPane.YES_NO_OPTION);
        
            if (reply == JOptionPane.YES_OPTION) {
                resetGame(); // Reset game.
            } 
            else {
                System.exit(0); // Close game.
            }
        }
    }

    // Reset game
    public static void resetGame() {
        newWord();
        for (int i = 0; i < 5; i++) {
            guessTracker[i] = false;
            validLetter[i] = false;
            
        }
        WordleGame.guessRestart();
        new WordleGame();

        if (WordleGame.debugStatus() == true) {
            System.out.println(Wordle.getWord());
        }
    }

    // Return values to program
    public static String getWord() {
        return word;
    }

    public static boolean[] getGuesses() {
        return guessTracker;
    }

    public static boolean[] getValidLetters() {
        return validLetter;
    }
}
