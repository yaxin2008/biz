package us.co.state.sos;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="hiBean")
@SessionScoped
public class HelloBean implements Serializable{
	private static final long serialVersionUID = 2013L;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
