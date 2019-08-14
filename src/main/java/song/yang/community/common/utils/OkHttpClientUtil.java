package song.yang.community.common.utils;

import okhttp3.*;

import java.io.IOException;

/**
 * @Auther: song
 * @Date: 2019/8/8 15:28
 * @Description:
 */
public class OkHttpClientUtil {
    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    static  OkHttpClient client = new OkHttpClient();
    public static String postSend(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static String getSend(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
