package com.esmasuyolu.composite.entity;

import java.io.Serializable;
import java.util.Objects;

public class ParticipantId implements Serializable {

	private static final long serialVersionUID = 1L;

	private long employeeId;
	
	private long projectId;

	public ParticipantId() {}
	
	public ParticipantId(long employeeId, long projectId) {
		this.employeeId = employeeId;
		this.projectId = projectId;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(employeeId, projectId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParticipantId other = (ParticipantId) obj;
		return employeeId == other.employeeId && projectId == other.projectId;
	}

	@Override
	public String toString() {
		return "ParticipantId [employeeId=" + employeeId + ", projectId=" + projectId + "]";
	}

}
