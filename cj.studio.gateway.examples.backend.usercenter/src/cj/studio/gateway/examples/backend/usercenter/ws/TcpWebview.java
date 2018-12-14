package cj.studio.gateway.examples.backend.usercenter.ws;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import cj.studio.ecm.Scope;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.net.Circuit;
import cj.studio.ecm.net.CircuitException;
import cj.studio.ecm.net.Frame;
import cj.studio.ecm.net.IContentReciever;
import cj.studio.ecm.net.IInputChannel;
import cj.studio.gateway.socket.app.IGatewayAppSiteResource;
import cj.studio.gateway.socket.app.IGatewayAppSiteWayWebView;
import cj.studio.gateway.socket.io.IFeedback;
import cj.studio.gateway.socket.io.DefaultFeedback;

@CjService(name = "/tcp2/", scope = Scope.multiton)
public class TcpWebview implements IGatewayAppSiteWayWebView {

	@Override
	public void flow(Frame frame, Circuit circuit, IGatewayAppSiteResource resource) throws CircuitException {
		System.out.println("------tcp---");
//		MemoryContentReciever reciever=new MemoryContentReciever() {
//			@Override
//			public void done(byte[] b, int pos, int length) {
//				super.done(b, pos, length);
//				byte[] data=readFully();
//				System.out.println("-------data is\r\n"+new String(data));
//			}
//		};

		frame.content().accept(new FileContentReciever());

		// 发送头侦,头侦无内容
		IFeedback feedback = new DefaultFeedback(circuit);
		Frame first = feedback.createFirst("get /website/tcp/reciever/ net/1.0");
		first.head("test", "1323233");
		feedback.commitFirst(first);

		// 发送内容侦，可以发送无限多次内容侦
		IInputChannel incnt = feedback.createContent();
		incnt.writeBytes("弑母少年被带离原生活环境 由相关部门管束\r\n".getBytes());
		incnt.writeBytes("未成年人保护法修订 相关部门到湖南调研\r\n".getBytes());
		incnt.writeBytes("醉酒男子抢夺出租车方向盘 被判刑3年\r\n".getBytes());
		feedback.commitContent(incnt);

		// 发送结束侦
		IInputChannel inlast = feedback.createLast();
		inlast.writeBytes("1弑母少年被带离原生活环境 由相关部门管束\r\n".getBytes());
		inlast.writeBytes("2未成年人保护法修订 相关部门到湖南调研\r\n".getBytes());
		inlast.writeBytes("3醉酒男子抢夺出租车方向盘 被判刑3年\r\n".getBytes());
		feedback.commitLast(inlast);

	}

	class FileContentReciever implements IContentReciever {
		private FileOutputStream out;

		@Override
		public void recieve(byte[] b, int pos, int length) throws CircuitException {
			try {
				out.write(b, pos, length);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void done(byte[] b, int pos, int length) throws CircuitException {
			try {
				out.write(b, pos, length);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		@Override
		public void begin(Frame frame) {
			try {
				out = new FileOutputStream("/Users/caroceanjofers/" + frame.parameter("destFileName"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
