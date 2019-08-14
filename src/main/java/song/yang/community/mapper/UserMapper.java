package song.yang.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import song.yang.community.model.User;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO USER (NAME, TOKEN, ACCOUNT_ID, CREATE_TIME, UPDATE_TIME)VALUES (#{name},#{token},#{accountId},#{createTime},#{updateTime})")
    public int insertUser(User user);
}
