import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.AbstractMap;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

public class UvaStats {

     public String get_id(String usrId) throws Exception{
        // get user id from user name
        //https://uhunt.onlinejudge.org/api/uname2uid/Add_2_Number

        // Create a request
        String id_info_url =  "https://uhunt.onlinejudge.org/api/uname2uid/"+usrId+"";
        URL url = new URL(id_info_url);
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

        // Optional default is GET
        con.setRequestMethod("GET");

        // Add request header
        con.setRequestProperty("User-Agent","Mozilla/5.0");
        int resCode = con.getResponseCode();
        System.out.println("Respons Code : " + resCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;

        StringBuffer response = new StringBuffer();

        while((inputLine = in.readLine()) != null){
            response.append(inputLine);
        }
        in.close();

        String ID = response.toString();
        return ID;
    }

    public AbstractMap.SimpleEntry<Integer, String> get_total_no_solve(String usr_id) throws Exception{
        // get user info
        //https://uhunt.onlinejudge.org/api/subs-user/825551

        String usrId = get_id(usr_id);

        // create a request
            String id_info_url1 =  "https://uhunt.onlinejudge.org/api/subs-user/"+usrId+"";

        URL url1 = new URL(id_info_url1);

        HttpsURLConnection con1 = (HttpsURLConnection) url1.openConnection();

        // optional default is GET
        con1.setRequestMethod("GET");

        // add request header
        con1.setRequestProperty("User-Agent","Mozilla/5.0");
        int resCode1 = con1.getResponseCode();
        System.out.println("Respons Code : " + resCode1);

        BufferedReader in1 = new BufferedReader(new InputStreamReader(con1.getInputStream()));

        String inputLine1;

        StringBuffer response1 = new StringBuffer();

        while((inputLine1 = in1.readLine()) != null){
            response1.append(inputLine1);
        }
        in1.close();

        // print json file in String
        // System.out.println(response1.toString());

        // create JSONObject
        JSONObject obj1 = new JSONObject(response1.toString());

        // Get array from JSONobject
        JSONArray ar = obj1.getJSONArray("subs");

        // Get name from JSONObject
        String name = obj1.optString("name");

        // Map for check unique solve
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();

        // Count total unique solve
        int cnt = 0;
        for(int i = 0; i<ar.length(); i++){

            int prob = ar.getJSONArray(i).getInt(1); // get problem id
            int ver = ar.getJSONArray(i).getInt(2); // get verdict id

            if(!map.containsKey(prob)){
                if(ver == 90){ // verdic id 90 is AC
                    map.put(prob,1);
                    cnt++;
                }
            }
        }
        //System.out.println("Your Url : " + id_info_url1);
        //System.out.println("Your Total AC : " + cnt);
        //System.out.println("Your Name : " + name);


        // Pair total AC problem and name of the user
        AbstractMap.SimpleEntry<Integer, String> entry = new AbstractMap.SimpleEntry<>(cnt, name);

        return entry;
    }

}
