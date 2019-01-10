package cj.studio.gateway.examples.backend.usercenter.stub;

import java.util.ArrayList;
import java.util.List;

import cj.studio.gateway.examples.backend.usercenter.bo.DeptmentBO;
import cj.studio.gateway.stub.annotation.CjStubInContent;
import cj.studio.gateway.stub.annotation.CjStubMethod;
import cj.studio.gateway.stub.annotation.CjStubReturn;
import cj.studio.gateway.stub.annotation.CjStubService;

@CjStubService(bindService = "/dept/", usage = "部门管理")
public interface IDeptStub {
	@CjStubMethod(usage = "xx",command="post")
	void save(@CjStubInContent(usage = "xx") DeptmentBO bo);

	@CjStubMethod(usage = "xx")
	@CjStubReturn(type = ArrayList.class, usage = "xx")
	List<DeptmentBO> getAll();
	
	@CjStubMethod(usage = "xx",command="post")
	void testArg(@CjStubInContent(usage="json格式")DeptmentBO bo);
}
