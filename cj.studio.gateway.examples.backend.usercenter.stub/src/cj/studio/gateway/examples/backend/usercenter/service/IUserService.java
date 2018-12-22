package cj.studio.gateway.examples.backend.usercenter.service;

import java.util.List;

import cj.studio.gateway.examples.backend.usercenter.bo.UserBO;

public interface IUserService {
	void save(UserBO bo);

	void delete(String id);

	List<UserBO> query();

	UserBO getUser(String id);

	List<UserBO> query(String name, int age);
}
