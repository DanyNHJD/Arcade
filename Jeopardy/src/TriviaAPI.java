import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class TriviaAPI {
    private final HttpClient client = HttpClient.newHttpClient();

    public List<String> fetchData() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://opentdb.com/api.php?amount=1&type=multiple"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            JSONObject jsonResponse = new JSONObject(response.body());
            JSONArray results = jsonResponse.getJSONArray("results");
            return parseTriviaQuestions(results.getJSONObject(0));
        } else {
            throw new RuntimeException("Failed to fetch data. Status code: " + response.statusCode());
        }
    }

    private List<String> parseTriviaQuestions(JSONObject question) {
        List<String> triviaData = new ArrayList<>();

        triviaData.add(question.getString("question")
                .replace("&quot;", "\"")
                .replace("&#039;", "'")
                .replace("&amp;", "&"));

        triviaData.add(question.getString("correct_answer")
                .replace("&quot;", "\"")
                .replace("&#039;", "'")
                .replace("&amp;", "&"));

        JSONArray incorrectAnswers = question.getJSONArray("incorrect_answers");
        for (int i = 0; i < incorrectAnswers.length(); i++) {
            triviaData.add(incorrectAnswers.getString(i)
                    .replace("&quot;", "\"")
                    .replace("&#039;", "'")
                    .replace("&amp;", "&"));
        }

        return triviaData;
    }
}
