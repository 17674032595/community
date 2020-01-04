package song.yang.community.common.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * @Auther: song
 * @Date: 2019/8/8 15:17
 * @Description:

*/
public class HttpClientUtil {

    static CloseableHttpClient httpclient = HttpClients.createDefault();

    public static String getSend(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response1 = httpclient.execute(httpGet);

        try {
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            EntityUtils.consume(entity1);
            System.out.println(entity1);
            return entity1.toString();
        } finally {
            response1.close();
        }
    }

    public static void main(String[] args) throws IOException {
        postSend();
    }
   public static String postSend() throws IOException{
        HttpPost httpPost = new HttpPost("https://github.com/login/oauth/access_token");
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("client_id", "81c6c3ff78fe367cbde3"));
        nvps.add(new BasicNameValuePair("client_secret", "d64e9028b8676fe1a0732d0f59c43fa9b223582e"));
        nvps.add(new BasicNameValuePair("code", "e2a187db1d929e6d2dd6"));
        nvps.add(new BasicNameValuePair("redirect_uri", "http://localhost:8080/callback"));
        nvps.add(new BasicNameValuePair("state", "1"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        CloseableHttpResponse response2 = httpclient.execute(httpPost);

    try {
            System.out.println(response2.getStatusLine());
            HttpEntity entity2 = response2.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            EntityUtils.consume(entity2);
        } finally {
            response2.close();
    }
    return null;

    }
}
