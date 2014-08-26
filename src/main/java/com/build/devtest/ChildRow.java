package com.build.devtest;

public class ChildRow extends Person {

	private String childId;
	private String parentId;

	public ChildRow(String firstName, String lastName, int age, String childId,
			String parentId) {
		super(firstName, lastName, age);
		this.childId = childId;
		this.parentId = parentId;
	}

	public String getChildId() {
		return childId;
	}

	public void setChildId(String childId) {
		this.childId = childId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

}
