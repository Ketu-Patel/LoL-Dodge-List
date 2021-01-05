import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.URLConnection;
import java.net.HttpURLConnection;
public class RequestHandler{

//create client
public RequestHandler(){
    try {
        URL url = new URL("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    } catch (Exception e) {
        System.out.println("Can not get URL");
    }


}















}