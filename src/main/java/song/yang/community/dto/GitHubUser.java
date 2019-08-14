package song.yang.community.dto;

/**
 * @Auther: song
 * @Date: 2019/8/12 16:01
 * @Description:
 */
public class GitHubUser {
    private String login;
    private Long id;
    private String name;
    private String bio;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
