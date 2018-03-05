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
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import com.dwaiba.bdd.demo.GuiceModule;
import com.dwaiba.bdd.demo.po.feedback.FeedbackPage;
import com.dwaiba.bdd.demo.po.feedback.TextFieldComponent;
import com.dwaiba.bdd.demo.suite.SmokeTests;
import com.dwaiba.qa.bb.aem.ui.AemDialog;
import com.dwaiba.qa.bb.constants.Timeouts;
import com.dwaiba.qa.bb.aem.AemLogin;
import com.dwaiba.qa.bb.aem.dialog.classic.field.AemCheckbox;
import com.dwaiba.qa.bb.junit.Modules;
import com.dwaiba.qa.bb.junit.TestRunner;
import com.dwaiba.qa.bb.logging.ReportEntryLogger;
import com.dwaiba.qa.bb.utils.WebElementUtils;
import com.google.inject.Inject;

@RunWith(TestRunner.class)
@Modules(GuiceModule.class)
public class AemCheckboxTest {

  @Inject
  private ReportEntryLogger reportEntryLogger;

  @Inject
  private AemLogin aemLogin;

  @Inject
  private FeedbackPage feedbackPage;

  @Inject
  private WebElementUtils utils;

  @Before
  public void before() {
    aemLogin.authorLogin();
    openPageToTest();
  }

  @Category(SmokeTests.class)
  @Test
  public void checkboxTest() {
    final TextFieldComponent textFieldComponent = feedbackPage.getTextFieldComponent();
    final AemDialog dialog = textFieldComponent.getDialog();
    final boolean displayedBefore = textFieldComponent.isLabelVisible();
    dialog.open();
    handleCheckbox(textFieldComponent);
    dialog.ok();
    utils.isConditionMet(driver -> displayedBefore != textFieldComponent.isLabelVisible(),
        Timeouts.MEDIUM);

    boolean displayedAfter = textFieldComponent.isLabelVisible();
    boolean displayedChanged = displayedAfter != displayedBefore;
    assertTrue("Visibility of label should change", displayedChanged);
  }

  public void handleCheckbox(TextFieldComponent textFieldComponent) {
    AemCheckbox hideTitleCheckbox = textFieldComponent.getHideTitleCheckbox();
    boolean initialValue = hideTitleCheckbox.isChecked();
    reportEntryLogger.info("checkbox value before: '{}'", initialValue);
    hideTitleCheckbox.setCheck(!initialValue);
    boolean valueAfter = hideTitleCheckbox.isChecked();
    reportEntryLogger.info("checkbox value after: '{}'", valueAfter);
    boolean hasChanged = valueAfter != initialValue;
    assertTrue("checkbox value should have been changed", hasChanged);
  }

  private void openPageToTest() {
    feedbackPage.open();
    assertTrue(feedbackPage.isDisplayed());
  }
}
