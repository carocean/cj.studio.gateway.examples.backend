package cj.studio.gateway.examples.backend.usercenter.service;

import java.util.List;

import cj.studio.gateway.examples.backend.usercenter.bo.UserBO;

public interface IUserService {
	long save(UserBO bo);

	void delete(long id);

	List<UserBO> query();

	UserBO getUser(long id);

	List<UserBO> query(String name, int age);
}
