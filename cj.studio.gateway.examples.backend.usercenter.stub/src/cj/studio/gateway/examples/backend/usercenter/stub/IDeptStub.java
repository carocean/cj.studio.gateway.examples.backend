package cj.studio.gateway.examples.backend.usercenter.stub;

import java.util.ArrayList;
import java.util.List;

import cj.studio.gateway.examples.backend.usercenter.bo.DeptmentBO;
import cj.studio.gateway.stub.annotation.CjStubInContentKey;
import cj.studio.gateway.stub.annotation.CjStubMethod;
import cj.studio.gateway.stub.annotation.CjStubReturn;
import cj.studio.gateway.stub.annotation.CjStubService;

@CjStubService(bindService = "/dept/", usage = "部门管理")
public interface IDeptStub {
	@CjStubMethod(usage = "xx",command="post")
	void save(@CjStubInContentKey(key="bo",usage = "xx") DeptmentBO bo);

	@CjStubMethod(usage = "xx")
	@CjStubReturn(type = ArrayList.class,elementType=DeptmentBO.class, usage = "xx")
	List<DeptmentBO> getAll();
	
	@CjStubMethod(usage = "xx",command="post")
	@CjStubReturn(type=Integer.class,usage="xx")
	int testArg(@CjStubInContentKey(key="bo",usage="json格式")DeptmentBO bo);
}
