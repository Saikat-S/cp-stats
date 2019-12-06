import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.AbstractMap;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Codeforces {
    public AbstractMap.SimpleEntry<Integer, String> get_user_rating(String handle) throws Exception{
        String url = "https://codeforces.com/api/user.rating?handle="+handle;

        // Send Http request:
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");

        //Add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // create JSONObject
        JSONObject obj1 = new JSONObject(response.toString());

        // Get array from JSONobject
        JSONArray arr = obj1.getJSONArray("result");

        int last_index = arr.length()-1;

        int rating  = arr.getJSONObject(last_index).getInt("newRating");

        //System.out.println("User Rating :::- " +rating);

        // Pair rating and name of the user
        AbstractMap.SimpleEntry<Integer, String> entry = new AbstractMap.SimpleEntry<>(rating, handle);
        //return rating;
        return entry;
    }

    public void save_user_rating(){

    }


}
