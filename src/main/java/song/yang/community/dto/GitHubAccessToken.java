package song.yang.community.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Auther: song
 * @Date: 2019/8/12 15:29
 * @Description:
 */
@Data
@AllArgsConstructor
public class GitHubAccessToken {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;



}
