package com.build.devtest;

import java.util.List;

public class ParentView extends Person {

	private String parentId;
	private List<ChildView> childViews;

	public ParentView(String firstName, String lastName, int age,
			String parentId, List<ChildView> childViews) {
		super(firstName, lastName, age);
		this.parentId = parentId;
		this.childViews = childViews;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public List<ChildView> getChildViews() {
		return childViews;
	}

	public void setChildViews(List<ChildView> childViews) {
		this.childViews = childViews;
	}

}
