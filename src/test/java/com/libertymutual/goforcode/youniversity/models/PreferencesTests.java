package com.libertymutual.goforcode.youniversity.models;

import static org.junit.Assert.*;

import org.junit.Test;
import org.meanbean.test.BeanTester;

public class PreferencesTests {


	@Test
	public void test_all_gets_and_sets() {
		new BeanTester().testBean(Preferences.class);
	}

}
