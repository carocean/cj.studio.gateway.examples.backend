package cj.studio.gateway.examples.backend.usercenter.restfull;

import cj.studio.ecm.Scope;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.net.Circuit;
import cj.studio.ecm.net.CircuitException;
import cj.studio.ecm.net.Frame;
import cj.studio.gateway.socket.app.IGatewayAppSiteResource;
import cj.studio.gateway.socket.app.IGatewayAppSiteWayWebView;
import cj.studio.gateway.socket.io.XwwwFormUrlencodedContentReciever;

@CjService(name = "/", scope = Scope.multiton)
public class HomeRF implements IGatewayAppSiteWayWebView {

	@Override
	public void flow(Frame f, Circuit c, IGatewayAppSiteResource ctx) throws CircuitException {
//		try {
//			Thread.sleep(Integer.MAX_VALUE);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		f.content().accept(new XwwwFormUrlencodedContentReciever() {

			@Override
			protected void done(Frame f) {
				String[] names = f.enumParameterName();
				for (String name : names) {
					String text=String.format("-----%s=%s<br>", name, f.parameter(name));
					System.out.println(text);
					c.content().writeBytes(text.getBytes());
				}
				for(int i=0;i<20000;i++) {
					c.content().writeBytes((i+"_双方之前已经正常建立了通信通道，也可能进行过了交互，当某一方在交互的过程中发生了异常<br>").getBytes());
				}
			}
		});
		c.content().writeBytes("xxxxx<br>".getBytes());
	}

}
