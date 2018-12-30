package cj.studio.gateway.examples.backend.usercenter.service;

import java.util.List;

import cj.studio.gateway.examples.backend.usercenter.bo.DeptmentBO;

public interface IDeptService {
	void save(DeptmentBO bo);
	List<DeptmentBO> getAll();
}
