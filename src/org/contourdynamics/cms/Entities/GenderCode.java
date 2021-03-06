package org.contourdynamics.cms.Entities;

// Generated Dec 2, 2015 6:46:44 AM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * GenderCode generated by hbm2java
 */
@Entity
@Table(name = "GenderCode", catalog = "smartcommunication")
public class GenderCode implements java.io.Serializable {

	private Integer id;
	private String description;
	private Set<BpIndv> bpIndvs = new HashSet<BpIndv>(0);

	public GenderCode() {
	}

	public GenderCode(String description, Set<BpIndv> bpIndvs) {
		this.description = description;
		this.bpIndvs = bpIndvs;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "description", length = 45)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genderCode")
	public Set<BpIndv> getBpIndvs() {
		return this.bpIndvs;
	}

	public void setBpIndvs(Set<BpIndv> bpIndvs) {
		this.bpIndvs = bpIndvs;
	}

}
