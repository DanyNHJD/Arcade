import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class JeoperdyClass<JSONObject> {


    public static void main(String[] args) {

        Jeopardy frame = new Jeopardy();
         try {
                    URL url = new URL("https://opentdb.com/api.php?amount=10");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.connect();
                int responseCode = conn.getResponseCode();


                } catch (ProtocolException e) {
                    e.printStackTrace();

                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }



            /*for (int i = 0; i < results.length(); i++) {
        JSONObject question = results.getJSONObject(i);
            System.out.println("Question: " + question.getString("question"));
            System.out.println("Correct answer: " + question.getString("correct_answer"));
            System.out.println("Incorrect answers: " + question.getJSONArray("incorrect_answers").toString());
            System.out.println();

             */
    }



