package cj.studio.gateway.examples.backend.usercenter;

import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.net.Circuit;
import cj.studio.ecm.net.CircuitException;
import cj.studio.ecm.net.Frame;
import cj.studio.gateway.socket.app.IGatewayAppSiteResource;
import cj.studio.gateway.socket.app.IGatewayAppSiteWayWebView;

@CjService(name = "/")
public class Home implements IGatewayAppSiteWayWebView{

	@Override
	public void flow(Frame arg0, Circuit c, IGatewayAppSiteResource arg2) throws CircuitException {
		System.out.println("----home");
		c.content().writeBytes("xxxx".getBytes());
	}

}
