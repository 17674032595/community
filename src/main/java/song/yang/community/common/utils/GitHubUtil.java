package song.yang.community.common.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import song.yang.community.dto.GitHubAccessToken;
import song.yang.community.dto.GitHubUser;

import java.io.IOException;

/**
 * @Auther: song
 * @Date: 2019/8/8 15:23
 * @Description:
 */
@Service
public class GitHubUtil {

    @Value("${github.getAccessTokenUrl}")
    private  String accessTokenUrl;
    @Value("${github.getUserInfoUrl}")
    private  String userInfoUrl;

    public  String getAccessToken(GitHubAccessToken gitHubAccessToken) {
        try {
            String s = OkHttpClientUtil.postSend(accessTokenUrl, JSON.toJSONString(gitHubAccessToken));
            s=s.split("&")[0];
            System.out.println(s);
            return s;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public  GitHubUser getUser(String accessToken) {
        userInfoUrl=userInfoUrl+accessToken;
        try {
            String send = OkHttpClientUtil.getSend(userInfoUrl);
            System.out.println(send);
            return JSON.parseObject(send, GitHubUser.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
