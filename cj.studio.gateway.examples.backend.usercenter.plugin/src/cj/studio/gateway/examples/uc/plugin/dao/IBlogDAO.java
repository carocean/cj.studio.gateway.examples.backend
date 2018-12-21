package cj.studio.gateway.examples.uc.plugin.dao;

import org.apache.ibatis.annotations.Insert;

import cj.studio.gateway.examples.backend.usercenter.bo.BlogBO;

public interface IBlogDAO {
	@Insert("insert into blog(id,name) values(#{id},#{name})")
	void save(BlogBO bo);
	
}