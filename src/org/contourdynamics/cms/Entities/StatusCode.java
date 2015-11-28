package org.contourdynamics.cms.Entities;

// Generated Nov 28, 2015 11:11:51 PM by Hibernate Tools 3.4.0.CR1

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
 * StatusCode generated by hbm2java
 */
@Entity
@Table(name = "StatusCode", catalog = "smartcommunication")
public class StatusCode implements java.io.Serializable {

	private Integer id;
	private String description;
	private Set<BpRoles> bpRoleses = new HashSet<BpRoles>(0);
	private Set<BpContactAccount> bpContactAccounts = new HashSet<BpContactAccount>(
			0);
	private Set<BpMain> bpMains = new HashSet<BpMain>(0);

	public StatusCode() {
	}

	public StatusCode(String description, Set<BpRoles> bpRoleses,
			Set<BpContactAccount> bpContactAccounts, Set<BpMain> bpMains) {
		this.description = description;
		this.bpRoleses = bpRoleses;
		this.bpContactAccounts = bpContactAccounts;
		this.bpMains = bpMains;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "statusCode")
	public Set<BpRoles> getBpRoleses() {
		return this.bpRoleses;
	}

	public void setBpRoleses(Set<BpRoles> bpRoleses) {
		this.bpRoleses = bpRoleses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "statusCode")
	public Set<BpContactAccount> getBpContactAccounts() {
		return this.bpContactAccounts;
	}

	public void setBpContactAccounts(Set<BpContactAccount> bpContactAccounts) {
		this.bpContactAccounts = bpContactAccounts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "statusCode")
	public Set<BpMain> getBpMains() {
		return this.bpMains;
	}

	public void setBpMains(Set<BpMain> bpMains) {
		this.bpMains = bpMains;
	}

}