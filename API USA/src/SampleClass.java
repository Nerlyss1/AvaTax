import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class SampleClass {

    public SampleClass() {

    }

    public void connect() throws FileNotFoundException, UnirestException {
        String filename = "C:/Users/stagiaireit/IdeaProjects/transaction.json";

        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(filename));
        SampleClass data = gson.fromJson(reader, SampleClass.class);

        Unirest.setTimeouts(0, 0);
        Unirest.setHttpClient(org.apache.http.impl.client.HttpClients.custom()
                .disableRedirectHandling()
                .build());

        String requestBody = gson.toJson(data);

         HttpResponse<String> response = Unirest.post("https://sandbox-rest.avatax.com/api/v2/transactions/create")
        .header("X-Avalara-Client", "{X-Avalara-Client}")
        .header("Authorization", "Basic <aHR0cHdhdGNoOmY=")
        .header("Content-Type", "application/json")
        .body(requestBody)
        .asString();


        System.out.println(response.getBody());

    }
}

