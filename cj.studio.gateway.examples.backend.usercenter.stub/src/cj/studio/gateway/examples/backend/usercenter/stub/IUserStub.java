package cj.studio.gateway.examples.backend.usercenter.stub;

import java.util.ArrayList;
import java.util.List;

import cj.studio.gateway.examples.backend.usercenter.bo.UserBO;
import cj.studio.gateway.stub.annotation.CjStubInContentKey;
import cj.studio.gateway.stub.annotation.CjStubInHead;
import cj.studio.gateway.stub.annotation.CjStubInParameter;
import cj.studio.gateway.stub.annotation.CjStubMethod;
import cj.studio.gateway.stub.annotation.CjStubReturn;
import cj.studio.gateway.stub.annotation.CjStubService;

@CjStubService(bindService = "/user/", usage = "用户管理")
public interface IUserStub {
	@CjStubMethod(alias = "save", command = "post", protocol = "http/1.1", usage = "保存")
	@CjStubReturn(type=Long.class,usage="返回自增长标识")
	long save(@CjStubInContentKey(key="bo",usage = "用户实体UserBO") UserBO bo);

	@CjStubMethod(alias = "delete", command = "get", protocol = "http/1.1", usage = "保存")
	void delete(@CjStubInHead(key = "User-ID", usage = "用户标识") long id);

	@CjStubMethod(alias = "query", command = "get", protocol = "http/1.1", usage = "保存")
	@CjStubReturn(type = ArrayList.class, usage = "返回用户列表")
	List<UserBO> query();

	@CjStubMethod(alias = "query2", command = "get", protocol = "http/1.1", usage = "保存")
	@CjStubReturn(type = ArrayList.class, usage = "返回用户列表")
	List<UserBO> query(@CjStubInParameter(key = "name", usage = "姓名") String name,
			@CjStubInParameter(key = "age", usage = "年龄") int age);

	@CjStubMethod(alias = "getUser", protocol = "http/1.1", command = "get", usage = "获取用户")
	@CjStubReturn(usage = "xxx", type = UserBO.class)
	UserBO getUser(@CjStubInParameter(key = "id", usage = "xx") long id);
}
