import com.google.gson.Gson;
import model.ChampionListDTO;
import model.Shaco;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Main {

    public static String url = "https://br1.api.riotgames.com/lol/static-data/v3/champions";
    public static String api_key = "?api_key=RGAPI-84396386-928f-4d2a-a612-bdd7d0f4c1cb";

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

        String retorno = run(url+api_key, client);

        Gson gson = new Gson();


        ChampionListDTO dto = gson.fromJson(retorno, ChampionListDTO.class);

        System.out.println(dto.getData().getShaco().getTitle());

    }

    public static String run(String url, OkHttpClient client) throws IOException {

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response =  client.newCall(request).execute();

        return response.body().string();
    }


}
