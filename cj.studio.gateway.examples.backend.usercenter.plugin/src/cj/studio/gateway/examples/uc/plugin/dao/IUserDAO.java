package cj.studio.gateway.examples.uc.plugin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cj.studio.gateway.examples.backend.usercenter.bo.UserBO;

public interface IUserDAO {
	long save(UserBO bo);
	void delete(long id);
	List<UserBO> query();
	UserBO getUser(long id);
	List<UserBO> query2(@Param(value="name")String name, @Param(value="age")int age);
}
