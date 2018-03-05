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
package com.dwaiba.bdd.demo.aem;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.dwaiba.bdd.demo.GuiceModule;
import com.dwaiba.bdd.demo.po.feedback.FeedbackPage;
import com.dwaiba.qa.bb.aem.AemLogin;
import com.dwaiba.qa.bb.aem.ui.menu.AemContextMenu;
import com.dwaiba.qa.bb.aem.ui.menu.MenuOption;
import com.dwaiba.qa.bb.aem.ui.parsys.AemParsys;
import com.dwaiba.qa.bb.junit.Modules;
import com.dwaiba.qa.bb.junit.TestRunner;
import com.google.inject.Inject;

@RunWith(TestRunner.class)
@Modules(GuiceModule.class)
public class AemContextMenuTest {

  @Inject
  private AemLogin aemLogin;

  @Inject
  private FeedbackPage page;

  @Before
  public void before() {
    aemLogin.authorLogin();
    openPageToTest();
  }

  @Test
  public void aemContextMenuTest() {
    AemParsys parsys = page.getMainParsys();
    AemContextMenu aemContextMenu = parsys.openContextMenu(1);
    aemContextMenu.clickOption(MenuOption.EDIT);
  }

  private void openPageToTest() {
    page.open();
    assertTrue(page.isDisplayed());
  }
}
