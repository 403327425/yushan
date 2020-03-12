package com.gezi.GS.dao.sys;

import com.gezi.GS.vo.sys.UserList;
import com.gezi.GS.example.sys.UserListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserListMapper {
    long countByExample(UserListExample example);

    int deleteByExample(UserListExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(UserList record);

    int insertSelective(UserList record);

    List<UserList> selectByExample(UserListExample example);

    UserList selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") UserList record, @Param("example") UserListExample example);

    int updateByExample(@Param("record") UserList record, @Param("example") UserListExample example);

    int updateByPrimaryKeySelective(UserList record);

    int updateByPrimaryKey(UserList record);
}