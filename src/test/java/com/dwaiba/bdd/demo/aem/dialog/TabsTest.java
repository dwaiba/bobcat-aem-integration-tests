/*-
 * #%L
 * Bobcat
 * %%
 * Copyright (C) 2018 HCL Technologies Ltd.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.dwaiba.bdd.demo.aem.dialog;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.dwaiba.bdd.demo.GuiceModule;
import com.dwaiba.bdd.demo.aem.AemDialogTestBase;
import com.dwaiba.bdd.demo.po.summer.PopularArticlesComponent;
import com.dwaiba.qa.bb.aem.ui.AemDialog;
import com.dwaiba.qa.bb.junit.Modules;
import com.dwaiba.qa.bb.junit.TestRunner;

@RunWith(TestRunner.class)
@Modules(GuiceModule.class)
public class TabsTest extends AemDialogTestBase {
  private PopularArticlesComponent popularArticles;

  private AemDialog aemDialogForPopularArticles;

  @After
  public void after() {
    aemDialogForPopularArticles.closeIfVisible();
    popularArticles = null;
    aemDialogForPopularArticles = null;
  }

  @Test
  public void testTabs() {
    aemDialogForPopularArticles.openByContextMenu();

    // check the active tab
    String tab = aemDialogForPopularArticles.getActiveTabName();
    assertThat("Root page", is(tab));

    // switch to some other tab
    aemDialogForPopularArticles.clickTab("Defaults");
    tab = aemDialogForPopularArticles.getActiveTabName();
    assertThat(tab, is("Defaults"));

    // check the window title text
    if (webDriver.manage().window().getSize().getWidth() >= 975) {
      String titleText = aemDialogForPopularArticles.getTitle();
      assertThat(titleText, is("Edit Component"));
    }
  }

  @Override
  protected void initializeFields() {
    popularArticles = summerBlockbusterHitsPage.getPopularArticles();
    assertThat(popularArticles, is(notNullValue()));
    aemDialogForPopularArticles = findDialog(popularArticles);
  }
}
