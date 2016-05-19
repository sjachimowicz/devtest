package com.build.devtest;

import java.util.ArrayList;
import java.util.List;

public class ParentViewMapperImpl implements ParentViewMapper {

	public List<ParentView> mapRowsToViews(List<ParentRow> parentRows, List<ChildRow> childRows) {
		List<ParentView> parentList = new ArrayList<ParentView>();
		List<ChildView> childList;
		ParentView parentView;

		for (ParentRow parent : parentRows) {
			childList = new ArrayList<ChildView>();
			parentView = new ParentView(parent.getFirstName(), parent.getLastName(), parent.getAge(),
					parent.getParentId(), null);

			for (ChildRow child : childRows) {
				if (child.getParentId().equalsIgnoreCase(parent.getParentId())) {
					childList.add(new ChildView(child.getFirstName(), child.getLastName(), child.getAge(),
							child.getChildId(), parentView));
				}

			}

			parentView.setChildViews(childList);
			parentList.add(parentView);

		}
		return parentList;
	}
}
