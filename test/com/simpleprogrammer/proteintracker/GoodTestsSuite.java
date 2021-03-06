package com.simpleprogrammer.proteintracker;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(GoodTestsCategory.class)
@ExcludeCategory(BadCategory.class)
@SuiteClasses({
	HelloJUnitTest.class, 
	TrackingServiceTests.class
	})
public class GoodTestsSuite {

}
