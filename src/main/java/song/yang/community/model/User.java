package song.yang.community.model;

import lombok.Data;

/**
 * @Auther: song
 * @Date: 2019/8/13 17:16
 * @Description:
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String token;
    private String accountId;
    private Long createTime;
    private Long updateTime;


}
