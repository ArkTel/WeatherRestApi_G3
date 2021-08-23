package backend.connect;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Scanner;

public class AccuwetherConnection {

    public static String connect() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź nazwę lokalizacji, którą chcesz dodać:");
        String cityName = scanner.next();
        String BASE_URL = String.format("http://dataservice.accuweather.com/locations/v1/cities/search?apikey=2TJbRd3jpjuTtVYuqGxQSXp20sQkHpyG&q=" +
                "%s&language=pl&details=true", cityName);


        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();

        OkHttpClient client = new OkHttpClient();

        Call call = client.newCall(request);
        Response response;
        response = call.execute();

        return response.body().string();
    }
}
