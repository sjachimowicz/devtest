package com.build.devtest;

public class ChildView extends Person {

	private String childId;

	public ChildView(String firstName, String lastName, int age,
			String childId, ParentView parentView) {
		super(firstName, lastName, age);
		this.childId = childId;
	}

	public String getChildId() {
		return childId;
	}

	public void setChildId(String childId) {
		this.childId = childId;
	}

}
