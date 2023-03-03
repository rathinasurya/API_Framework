package PojoClass;

public class PojoClass {
	String createdBy;
	String projectName;
	String status;
	int teamSize;
	
	public PojoClass(String createdBy, String projectName, String status, int teamSize) {
		super();
		this.createdBy = createdBy;
		this.projectName = projectName;
		this.status = status;
		this.teamSize = teamSize;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getStatus() {
		return status;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
	

}
