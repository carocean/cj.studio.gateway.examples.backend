package cj.studio.gateway.examples.backend.usercenter;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import cj.studio.ecm.IChipInfo;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.net.Circuit;
import cj.studio.ecm.net.Frame;
import cj.studio.gateway.socket.app.IGatewayAppSiteResource;
import cj.studio.gateway.socket.util.SocketContants;
import cj.studio.gateway.stub.annotation.CjStubInContent;
import cj.studio.gateway.stub.annotation.CjStubInHead;
import cj.studio.gateway.stub.annotation.CjStubInParameter;
import cj.studio.gateway.stub.annotation.CjStubMethod;
import cj.studio.gateway.stub.annotation.CjStubReturn;
import cj.studio.gateway.stub.annotation.CjStubService;
import cj.studio.gateway.stub.printer.PrintStubAppSiteWebView;

@CjService(name = "/")
public class Home extends PrintStubAppSiteWebView {


	@Override
	protected void onprintStubService(CjStubService ss, Class<?> c, Frame frame, Circuit circuit,
			IGatewayAppSiteResource resource) {
		circuit.content().writeBytes(String.format("<b>%s://%s%s%s</b><br>",frame.head(SocketContants.__frame_fromProtocol),frame.head("Host"),frame.rootPath(), ss.bindService()).getBytes());
		circuit.content().writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;%s<br>", c.getName()).getBytes());
		circuit.content().writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;用法:%s<br>", ss.usage()).getBytes());

		circuit.content().writeBytes("<br>".getBytes());

	}

	@Override
	protected void onprintStubMethod(CjStubMethod sm, CjStubReturn ret, Method m, Frame frame, Circuit circuit,
			IGatewayAppSiteResource resource) {
		circuit.content().writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;<b>%s</b><br>", m.getName()).getBytes());
		circuit.content().writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用法:%s<br>", sm.usage()).getBytes());
		if(ret!=null) {
			circuit.content().writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;返回值类型:%s,说明:%s<br>", ret.type().getName(),ret.usage()).getBytes());
		}
		circuit.content().writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;方法别名:%s<br>", sm.alias()).getBytes());
		circuit.content().writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;命令:%s<br>", sm.command()).getBytes());
		circuit.content().writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;协议:%s<br>", sm.protocol()).getBytes());
		circuit.content().writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;参数:<br>").getBytes());
	}

	@Override
	protected void onprintStubMethodArgInContent(CjStubInContent sic, Parameter p, Method m, Frame frame,
			Circuit circuit, IGatewayAppSiteResource resource) {
		circuit.content().writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;%s<br>", p.getName()).getBytes());
		circuit.content().writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类型:%s<br>", p.getType().getName()).getBytes());
		circuit.content().writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;方式：InContent<br>").getBytes());
		circuit.content().writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用法:%s<br>", sic.usage()).getBytes());

	}

	@Override
	protected void onprintStubMethodArgInParameter(CjStubInParameter sip, Parameter p, Method m, Frame frame,
			Circuit circuit, IGatewayAppSiteResource resource) {
		circuit.content().writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;%s<br>", p.getName()).getBytes());
		circuit.content().writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类型:%s<br>", p.getType().getName()).getBytes());
		circuit.content()
				.writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;方式：InParameter %s<br>", sip.key()).getBytes());
		circuit.content().writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用法:%s<br>", sip.usage()).getBytes());
	}

	@Override
	protected void onprintStubMethodArgInHead(CjStubInHead sih, Parameter p, Method m, Frame frame, Circuit circuit,
			IGatewayAppSiteResource resource) {
		circuit.content().writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;%s<br>", p.getName()).getBytes());
		circuit.content().writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类型:%s<br>", p.getType().getName()).getBytes());
		circuit.content()
				.writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;方式：InHeader %s<br>", sih.key()).getBytes());
		circuit.content().writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用法:%s<br>", sih.usage()).getBytes());
	}

	@Override
	protected void onprintEnd(Frame frame, Circuit circuit, IGatewayAppSiteResource resource) {
		// TODO Auto-generated method stub
		circuit.content().writeBytes("<br>".getBytes());
	}

	@Override
	protected void onprintStubServiceEnd(Frame frame, Circuit circuit, IGatewayAppSiteResource resource) {
		// TODO Auto-generated method stub
		circuit.content().writeBytes("<br>".getBytes());
	}

	@Override
	protected void onprintMethodEnd(Frame frame, Circuit circuit, IGatewayAppSiteResource resource) {
		// TODO Auto-generated method stub
		circuit.content().writeBytes("<br>".getBytes());
	}

	@Override
	protected void onprintChipInfo(IChipInfo info, Frame frame, Circuit circuit, IGatewayAppSiteResource resource) {
		circuit.content().writeBytes(String.format("******************************************************<br>").getBytes());
		circuit.content().writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;%s<br>", info.getName()).getBytes());
		circuit.content().writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;标识：%s<br>", info.getId()).getBytes());
		circuit.content().writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;版本：%s<br>", info.getVersion()).getBytes());
		circuit.content().writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;产品：%s<br>", info.getProduct()).getBytes());
		circuit.content().writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;公司：%s<br>", info.getCompany()).getBytes());
		circuit.content().writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;版权：%s<br>", info.getCopyright()).getBytes());
		circuit.content().writeBytes(String.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;描述：%s<br>", info.getDescription()).getBytes());
		circuit.content().writeBytes(String.format("******************************************************<br>").getBytes());
	}


}
