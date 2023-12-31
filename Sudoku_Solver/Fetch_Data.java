package AZ_Visualizer.Sudoku_Solver;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Fetch_Data {
    static JSONArray matrix;

    public static void main(String[] args) {
        String apiUrl = "https://sudoku-api.vercel.app/api/dosuku?query={newboard(limit:1){grids{value}}}";
        matrix= new JSONArray();

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                scanner.close();

                //Using the JSON simple library parse the string into a json object
                JSONParser parser = new JSONParser();
                JSONObject data_obj1 = (JSONObject) parser.parse(inline);

                JSONObject data_obj2 = (JSONObject) parser.parse( String.valueOf(data_obj1.get("newboard")) );
                JSONArray arr = (JSONArray) parser.parse( String.valueOf(data_obj2.get("grids")) );
                JSONObject data_obj3 = (JSONObject) parser.parse( String.valueOf(arr.get(0)) );
                matrix = (JSONArray) parser.parse( String.valueOf(data_obj3.get("value")) );

                System.out.println(matrix);
            } else {
                System.out.println("GET request failed. Response Code: " + responseCode);
            }
        } catch (Exception e) {
            System.out.println("Error Occurred: "+ e);
        }

        Sudoku obj= new Sudoku();
        String s= matrix.toString();
        String delay= args[0];

        if (s.length() != 0){
            String[] arr= {matrix.toString(), delay};
            obj.main(arr);
        }
        else{
            System.out.println("Could not fetch array!");
        }
    }
}
