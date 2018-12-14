package cj.studio.gateway.examples.backend.usercenter.restfull;

import cj.studio.ecm.Scope;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.net.Circuit;
import cj.studio.ecm.net.CircuitException;
import cj.studio.ecm.net.Frame;
import cj.studio.ecm.net.IContentReciever;
import cj.studio.ecm.net.io.MemoryContentReciever;
import cj.studio.gateway.socket.app.IGatewayAppSiteResource;
import cj.studio.gateway.socket.app.IGatewayAppSiteWayWebView;
import cj.studio.gateway.socket.io.XwwwFormUrlencodedContentReciever;

@CjService(name = "/", scope = Scope.multiton)
public class HomeRF implements IGatewayAppSiteWayWebView {

	@Override
	public void flow(Frame f, Circuit c, IGatewayAppSiteResource ctx) throws CircuitException {
		f.content().accept(new XwwwFormUrlencodedContentReciever() {
			
			@Override
			protected void done(Frame f) {
				System.out.println(f);
			}
		});
		for(int i=0;i<100000;i++) {
		c.content().writeBytes("xxxxx<br>".getBytes());
		}
	}

}
