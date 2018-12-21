package cj.studio.gateway.examples.backend.usercenter.bo;

public class BlogBO {
	String id;
	String name;
	public BlogBO() {
		// TODO Auto-generated constructor stub
	}
	
	public BlogBO(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
