package cj.studio.gateway.examples.backend.usercenter.ws;

import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.net.Circuit;
import cj.studio.ecm.net.CircuitException;
import cj.studio.ecm.net.Frame;
import cj.studio.ecm.net.io.MemoryContentReciever;
import cj.studio.ecm.net.io.MemoryInputChannel;
import cj.studio.gateway.socket.app.IGatewayAppSiteResource;
import cj.studio.gateway.socket.app.IGatewayAppSiteWayWebView;

@CjService(name = "/tcp/")
public class TestTcp implements IGatewayAppSiteWayWebView {

	@Override
	public void flow(Frame f, Circuit c, IGatewayAppSiteResource ctx) throws CircuitException {
		System.out.println("-----frame is---");
		if(f.content().isAllInMemory()) {
			System.out.println(new String(f.content().readFully()));
		}
		System.out.println("-----frame end---");
		
		//向客户端打印
		
		MemoryInputChannel input=new MemoryInputChannel(8192);
		Frame f1=new Frame(input,"put /website/ws/reciever g/1.0");
		f1.parameter("dept","铁道部");
		f1.head("My-Head","haha");
		MemoryContentReciever r=new MemoryContentReciever();
		f1.content().accept(r);
		input.begin(f1);
		
		for(int i=0;i<10;i++) {
			byte[] b=("\r\n......"+i).getBytes();
			input.writeBytes(b);
		}
		
		byte[] b=new byte[0];
		input.done(b, 0, b.length);
		
		sendFrame(f1,c);
	}
	private void sendFrame(Frame f1,Circuit circuit) throws CircuitException {
		byte[] b=f1.toBytes();
		circuit.content().writeBytes(b);
	}

}
