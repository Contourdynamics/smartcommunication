package org.contourdynamics.cms.producers;
import org.kie.internal.identity.IdentityProvider;

import java.util.ArrayList;
import java.util.List;

public class JBPMIDM implements IdentityProvider {
	private List<String> roles = new ArrayList<String>();
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "system";
	}

	@Override
	public List<String> getRoles() {
		// TODO Auto-generated method stub
		return roles;
	}

	@Override
	public boolean hasRole(String arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}
