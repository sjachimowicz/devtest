package com.build.devtest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RowViewTest {
	
	private List<ParentRow> parentRows;
	private List<ChildRow> childRows;
	private ParentViewMapper parentViewMapper = new ParentViewMapperImpl();
	
	@Before
	public void doSetup() {
		parentRows = Arrays.asList(
				new ParentRow("John", "Doe", 30, "Parent1"),
				new ParentRow("Jane", "Doe", 27, "Parent2"),
				new ParentRow("James", "Smith", 45, "Parent3"));
		
		childRows = Arrays.asList(
				new ChildRow("Billy", "Doe", 10, "Child1", "PARENT1"),
				new ChildRow("Billy", "Doe", 10, "Child1", "PARENT2"),
				new ChildRow("Sally", "Doe", 4, "Child2", "PARENT1"),
				new ChildRow("Sally", "Doe", 4, "Child2", "PARENT2"),
				new ChildRow("Bobby", "Smith", 15, "Child3", "PARENT3")
				);
		
		
	}
	
	@Test
	public void testMapRowsToViews() throws Exception {
		List<ParentView> parentViews = parentViewMapper.mapRowsToViews(parentRows, childRows);
		
		Assert.assertThat(parentViews, notNullValue());
		Assert.assertThat(parentViews.size(), is(3));
		
		ParentView parent1 = null;
		ParentView parent2 = null;
		ParentView parent3 = null;
		for (ParentView parentView : parentViews) {
			String parentId = parentView.getParentId();
			if (parentId.equals("Parent1")) {
				parent1 = parentView;
			} else if (parentId.equals("Parent2")) {
				parent2 = parentView;
			} else if (parentId.equals("Parent3")) {
				parent3 = parentView;
			} else {
				Assert.fail("Unexpected parent ID found: " + parentId);
			}
		}
		
		Assert.assertThat(parent1, notNullValue());
		Assert.assertThat(parent1.getChildViews(), notNullValue());
		Assert.assertThat(parent1.getChildViews().size(), is(2));
		
		Assert.assertThat(parent2, notNullValue());
		Assert.assertThat(parent2.getChildViews(), notNullValue());
		Assert.assertThat(parent2.getChildViews().size(), is(2));
		
		Assert.assertThat(parent3, notNullValue());
		Assert.assertThat(parent3.getChildViews(), notNullValue());
		Assert.assertThat(parent3.getChildViews().size(), is(1));
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
		objectMapper.writeValue(System.out, parentViews);
	}

}
