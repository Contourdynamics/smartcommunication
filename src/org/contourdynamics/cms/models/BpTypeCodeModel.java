package org.contourdynamics.cms.models;

import java.util.List;
import javax.inject.Inject;
import javax.enterprise.inject.Model;
import org.contourdynamics.cms.Entities.BpTypeCode;
import org.contourdynamics.cms.repository.BpTypeCodeRepos;

@Model
public class BpTypeCodeModel {
	@Inject
	BpTypeCodeRepos Repos;
	
	public String Save(BpTypeCode type)
	{
		Repos.save(type);
		return "Saved";
	}
	public List<BpTypeCode> ReadAll()
	{
		return Repos.findAll();
	}

}
