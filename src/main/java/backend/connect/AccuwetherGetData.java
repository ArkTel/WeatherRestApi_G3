package backend.connect;

import backend.repository.LocationRepository;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Scanner;

public class AccuwetherGetData {

    public static String getDate(LocationRepository locationRepository) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę miasta");
        String cityName = scanner.next();
        String cityKey = locationRepository.findKeyByName(cityName);
        String BASE_URL = String.format("http://dataservice.accuweather.com/currentconditions/v1/%s?apikey=ZybsuHWa9riITVEkvvp5yK8K5rudrPYm&details=true", cityKey);


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
