package backend.connect;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Scanner;

public class WetherstackConnection {

    public static String connect(String cityName) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String BASE_URL = String.format("http://api.weatherstack.com/forecast" +
                "?access_key=265f4183f04e4ff29b09ad16dc205aaa" +
                "&query=%s" +
                "&forecast_days=1" +
                "&hourly=1", cityName);

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
