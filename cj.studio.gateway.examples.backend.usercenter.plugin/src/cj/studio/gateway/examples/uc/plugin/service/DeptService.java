package cj.studio.gateway.examples.uc.plugin.service;

import java.util.ArrayList;
import java.util.List;

import cj.lns.chip.sos.cube.framework.ICube;
import cj.lns.chip.sos.cube.framework.IDocument;
import cj.lns.chip.sos.cube.framework.IQuery;
import cj.lns.chip.sos.cube.framework.TupleDocument;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.gateway.examples.backend.usercenter.bo.DeptmentBO;
import cj.studio.gateway.examples.backend.usercenter.service.IDeptService;
@CjService(name="dept")
public class DeptService implements  IDeptService{
	@CjServiceRef(refByName="mongodb.cctv.home")
	ICube cube;
	@Override
	public void save(DeptmentBO bo) {
		cube.saveDoc("deptments", new TupleDocument<>(bo));
	}

	@Override
	public List<DeptmentBO> getAll() {
		IQuery<DeptmentBO> q=cube.createQuery("select {'tuple':'*'} from tuple deptments cj.studio.gateway.examples.backend.usercenter.bo.DeptmentBO where {}");
		List<DeptmentBO> list=new ArrayList<>();
		for(IDocument<DeptmentBO> doc:q.getResultList()) {
			list.add(doc.tuple());
		}
		return list;
	}

}
