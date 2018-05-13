package com.etnetera.hr.data;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Etnetera
 *
 */
@Entity
public class Version {

	@EmbeddedId
	private VersionId id;

	@NotNull
	@Size(min = 5, message = "Codename must have at least 10 characters")
	private String codeName;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "framework_id")
	private JavaScriptFramework framework;

	public Version() {
	}

	public Version(VersionId id) {
		this.id = id;
	}

	public VersionId getId() {
		return id;
	}

	public void setId(VersionId id) {
		this.id = id;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public JavaScriptFramework getFramework() {
		return framework;
	}

	public void setFramework(JavaScriptFramework framework) {
		this.framework = framework;
	}
}
