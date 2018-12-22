package cj.studio.gateway.examples.backend.usercenter.stub;

import java.util.List;

import cj.studio.ecm.Scope;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.gateway.examples.backend.usercenter.bo.UserBO;
import cj.studio.gateway.examples.backend.usercenter.service.IUserService;
import cj.studio.gateway.stub.GatewayAppSiteRestStub;

@CjService(name = "/user/", scope = Scope.multiton)
public class UserStub extends GatewayAppSiteRestStub implements IUserStub {
	@CjServiceRef(refByName = "ucplugin.user")
	IUserService user;
	
	@Override
	public UserBO getUser(long name) {
		UserBO bo= user.getUser(name);
		return bo;
	}

	@Override
	public long save(UserBO bo) {
		return user.save(bo);
	}
	@Override
	public List<UserBO> query(String name, int age) {
		return user.query(name,age);
	}
	@Override
	public void delete(long id) {
		user.delete(id);
	}

	@Override
	public List<UserBO> query() {
		return user.query();
	}

}
