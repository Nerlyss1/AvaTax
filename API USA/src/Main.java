import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {
        String filename = "C:/Users/stagiaireit/IdeaProjects/transaction.json";

        SampleClass sc = new SampleClass();
        try {
            sc.connect();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }


        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(filename));
        SampleClass data = gson.fromJson(reader, SampleClass.class);

        URL url = new URL("https://sandbox-rest.avatax.com/api/v2/transactions/create");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("X-Avalara-Client", "{X-Avalara-Client}");
        connection.setRequestProperty("Authorization", "Basic codeàmettre");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        String requestBody = gson.toJson(data);

        try (OutputStream outputStream = connection.getOutputStream()) {
            outputStream.write(requestBody.getBytes());
            outputStream.flush();
        }

        try (InputStream inputStream = connection.getInputStream();
             InputStreamReader responseReader = new InputStreamReader(inputStream)) {
            StringBuilder response = new StringBuilder();
            char[] buffer = new char[1024];
            int bytesRead;
            while ((bytesRead = responseReader.read(buffer)) != -1) {
                response.append(buffer, 0, bytesRead);
            }
            System.out.println(response.toString());
        } finally {
            connection.disconnect();
        }
    }
}
