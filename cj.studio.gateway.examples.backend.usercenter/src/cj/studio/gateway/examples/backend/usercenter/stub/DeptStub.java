package cj.studio.gateway.examples.backend.usercenter.stub;

import java.util.List;

import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.gateway.examples.backend.usercenter.bo.DeptmentBO;
import cj.studio.gateway.examples.backend.usercenter.service.IDeptService;
import cj.studio.gateway.stub.GatewayAppSiteRestStub;

@CjService(name = "/dept/")
public class DeptStub extends GatewayAppSiteRestStub implements IDeptStub {
	@CjServiceRef(refByName = "ucplugin.dept")
	IDeptService dept;

	@Override
	public void save(DeptmentBO bo) {
		dept.save(bo);
	}

	@Override
	public List<DeptmentBO> getAll() {
		return dept.getAll();
	}
	

}
