import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;


public class RequestHandler{
    private static String apiKey = "RGAPI-b4f32cdd-d48c-4ead-a9dc-6b824eaf63b6";
    private static String matchID = "3722382651";
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public RequestHandler() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://na1.api.riotgames.com/lol/match/v4/matches/" + matchID + "?api_key=" + apiKey))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public String[] findsummonerID(String[] SummonerNames) throws IOException, InterruptedException, ParseException {
        String[] summonerIds = new String[5];
        for (int names = 0; names < SummonerNames.length; names++){
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("hhttps://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + SummonerNames[names] + "?api_key=" + apiKey))
                    .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                    .build();
            Path path = Paths.get("../Data");
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(response.body());
            summonerIds[names] = (String) obj.get("summonerID");
        }
        return summonerIds;
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://na1.api.riotgames.com/lol/match/v4/matches/" + matchID + "?api_key=" + apiKey))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // print response headers
        //HttpHeaders headers = response.headers();
        //headers.map().forEach((k, v) -> System.out.println(k + ":" + v));


        // print response body
        System.out.println(response.body());

    }



}









