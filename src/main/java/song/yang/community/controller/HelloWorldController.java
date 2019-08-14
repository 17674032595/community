package song.yang.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import song.yang.community.common.utils.GitHubUtil;
import song.yang.community.dto.GitHubAccessToken;
import song.yang.community.dto.GitHubUser;
import song.yang.community.mapper.UserMapper;
import song.yang.community.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @Auther: song
 * @Date: 2019/7/26 15:50
 * @Description:
 */
@Controller
public class HelloWorldController {
    @Value("${github.clientId}")
    private String clientId;
    @Value("${github.redirectUri}")
    private String redirectUri;
    @Value("${github.clientSecret}")
    private String clientSecret;
    @Autowired
    private GitHubUtil gitHubUtil;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("clientId", clientId);
        model.addAttribute("redirectUri", redirectUri);
        return "index";
    }

    @GetMapping("/callback")
    public String callback(String code, String state, HttpServletRequest request) {
        GitHubAccessToken gitHubAccessToken=new GitHubAccessToken(clientId,clientSecret,code,redirectUri,state);
        String accessToken = gitHubUtil.getAccessToken(gitHubAccessToken);
        GitHubUser gitHubUser=gitHubUtil.getUser(accessToken);
        if(gitHubUser!=null){
            User user=new User();
            user.setAccountId(gitHubUser.getId().toString());
            user.setCreateTime(System.currentTimeMillis());
            user.setUpdateTime(user.getCreateTime());
            user.setToken(UUID.randomUUID().toString());
            user.setName(gitHubUser.getName());
            userMapper.insertUser(user);
            request.getSession().setAttribute("user", gitHubUser);
        }
        return "redirect:/";
    }
}
