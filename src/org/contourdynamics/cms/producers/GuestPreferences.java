package org.contourdynamics.cms.producers;
import java.io.Serializable;
import java.util.Map;


import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
@SessionScoped
public class GuestPreferences  implements Serializable {
	private String theme = "aristo"; //default

	public String getTheme() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if(params.containsKey("theme")) {
			theme = params.get("theme");
		}
		
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
}
