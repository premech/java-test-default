package com.etnetera.hr.data;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author Etnetera
 *
 */
@Embeddable
public class VersionId implements Serializable {

	private static final long serialVersionUID = -7817612373389134449L;

	private Integer major;

	private Integer minor;

	private Integer bugfix;

	public VersionId() {
	}

	public VersionId(Integer major, Integer minor, Integer bugfix) {
		this.major = major;
		this.minor = minor;
		this.bugfix = bugfix;
	}

	public Integer getMajor() {
		return major;
	}

	public void setMajor(Integer major) {
		this.major = major;
	}

	public Integer getMinor() {
		return minor;
	}

	public void setMinor(Integer minor) {
		this.minor = minor;
	}

	public Integer getBugfix() {
		return bugfix;
	}

	public void setBugfix(Integer bugfix) {
		this.bugfix = bugfix;
	}

}
