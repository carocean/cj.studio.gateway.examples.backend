package cj.studio.gateway.examples.backend.usercenter.stub;

import java.util.ArrayList;
import java.util.List;

import cj.studio.gateway.examples.backend.usercenter.bo.UserBO;
import cj.studio.gateway.stub.annotation.CjStubInContent;
import cj.studio.gateway.stub.annotation.CjStubInHead;
import cj.studio.gateway.stub.annotation.CjStubInParameter;
import cj.studio.gateway.stub.annotation.CjStubMethod;
import cj.studio.gateway.stub.annotation.CjStubReturn;
import cj.studio.gateway.stub.annotation.CjStubService;

@CjStubService(bindService = "/user/", usage = "用户管理")
public interface IUserStub {
	@CjStubMethod(alias = "save", command = "get", protocol = "http/1.1", usage = "保存")
	void save(@CjStubInContent(usage = "用户实体UserBO") UserBO bo);

	@CjStubMethod(alias = "delete", command = "get", protocol = "http/1.1", usage = "保存")
	void delete(@CjStubInHead(key = "User-ID", usage = "用户标识") String id);

	@CjStubMethod(alias = "query", command = "get", protocol = "http/1.1", usage = "保存")
	@CjStubReturn(type = ArrayList.class, usage = "返回用户列表")
	List<UserBO> query();

	@CjStubMethod(alias = "getUser", protocol = "http/1.1", command = "get", usage = "获取用户")
	@CjStubReturn(usage = "xxx", type = String.class)
	UserBO getUser(@CjStubInParameter(key = "name", usage = "xx") String name);
}
