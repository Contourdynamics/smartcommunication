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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Realm generated by hbm2java
 */
@Entity
@Table(name = "Realm", catalog = "smartcommunication")
public class Realm implements java.io.Serializable {

	private Integer id;
	private StatusCode statusCode;
	private String description;
	private String domain;
	private Set<BpSysUser> bpSysUsers = new HashSet<BpSysUser>(0);

	public Realm() {
	}

	public Realm(StatusCode statusCode, String description, String domain,
			Set<BpSysUser> bpSysUsers) {
		this.statusCode = statusCode;
		this.description = description;
		this.domain = domain;
		this.bpSysUsers = bpSysUsers;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "StatusCode")
	public StatusCode getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(StatusCode statusCode) {
		this.statusCode = statusCode;
	}

	@Column(name = "description", length = 45)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "domain", length = 45)
	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "realm")
	public Set<BpSysUser> getBpSysUsers() {
		return this.bpSysUsers;
	}

	public void setBpSysUsers(Set<BpSysUser> bpSysUsers) {
		this.bpSysUsers = bpSysUsers;
	}

}
