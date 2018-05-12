package com.etnetera.hr.data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * @author Etnetera
 *
 */
@Entity
public class JavaScriptFrameworkVersion {

	@EmbeddedId
	private VersionId id;

	private String releaseNotes;

	public JavaScriptFrameworkVersion() {
	}

	public JavaScriptFrameworkVersion(VersionId id, String releaseNotes) {
		this.id = id;
		this.releaseNotes = releaseNotes;
	}

	public VersionId getId() {
		return id;
	}

	public void setId(VersionId id) {
		this.id = id;
	}

	public String getReleaseNotes() {
		return releaseNotes;
	}

	public void setReleaseNotes(String releaseNotes) {
		this.releaseNotes = releaseNotes;
	}

}
