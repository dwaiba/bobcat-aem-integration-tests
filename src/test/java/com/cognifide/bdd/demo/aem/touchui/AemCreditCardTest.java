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
package com.dwaiba.bdd.demo.aem.touchui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import com.dwaiba.bdd.demo.GuiceModule;
import com.dwaiba.bdd.demo.po.touchui.CreditCardComponent;
import com.dwaiba.qa.bb.aem.AemLogin;
import com.dwaiba.qa.bb.aem.touch.data.componentconfigs.FieldType;
import com.dwaiba.qa.bb.aem.touch.data.components.Components;
import com.dwaiba.qa.bb.aem.touch.data.pages.Pages;
import com.dwaiba.qa.bb.aem.touch.pageobjects.pages.AuthorPage;
import com.dwaiba.qa.bb.aem.touch.pageobjects.pages.AuthorPageFactory;
import com.dwaiba.qa.bb.constants.Timeouts;
import com.dwaiba.qa.bb.expectedconditions.CommonExpectedConditions;
import com.dwaiba.qa.bb.junit.Modules;
import com.dwaiba.qa.bb.junit.TestRunner;
import com.dwaiba.qa.bb.provider.selenium.BobcatWait;
import com.google.inject.Inject;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsAnything.anything;
import static org.junit.Assert.*;

@RunWith(TestRunner.class)
@Modules(GuiceModule.class)
public class AemCreditCardTest {

  private static final String CONFIGURATION = "CreditCard - Update&Read";

  private static final String COMPONENT_NAME = "Credit Card Details";

  private static final String LABEL_TEXT = "Credit Card";

  private static final String CHECKED_CHECKBOX_CONFIGURATION =
      "Credit Card Details - Checked CheckBox";

  private static final String UNCHECKED_CHECKBOX_CONFIGURATION =
      "Credit Card Details - Unchecked CheckBox";

  @Inject
  private AemLogin aemLogin;

  @Inject
  private AuthorPageFactory authorPageFactory;

  @Inject
  private Pages pages;

  @Inject
  private Components components;

  @Inject
  private BobcatWait bobcatWait;

  private AuthorPage page;

  private String parsys;

  @Before
  public void setUp() {
    aemLogin.authorLogin();
    page = authorPageFactory.create(pages.getPath(CONFIGURATION));
    page.open();
    assertTrue("Page has not loaded", page.isLoaded());
    parsys = pages.getParsys(CONFIGURATION);
    page.clearParsys(parsys, COMPONENT_NAME);
    assertFalse(page.getParsys(parsys).isComponentPresent(COMPONENT_NAME));
    page.addComponent(parsys, COMPONENT_NAME);
    assertTrue(page.getParsys(parsys).isComponentPresent(COMPONENT_NAME));
  }

  @After
  public void tearDown() {
    page.clearParsys(parsys, COMPONENT_NAME);
    assertFalse(page.getParsys(parsys).isComponentPresent(COMPONENT_NAME));
  }

  @Test
  public void checkedCheckBoxTest() {
    page.configureComponent(parsys, COMPONENT_NAME, CHECKED_CHECKBOX_CONFIGURATION);

    processAssertsForCheckboxChecked();
  }

  @Test
  public void checkedCheckBoxConfBySingleFieldsTest() {
    page.getParsys(parsys).getComponent(COMPONENT_NAME)
        .openDialog()
        .setField("Element Name *", FieldType.TEXTFIELD.name(), "test")
        .setField("Only show non-editable summary", FieldType.CHECKBOX.name(), true)
        .confirm();

    processAssertsForCheckboxChecked();
  }

  @Test
  public void uncheckedCheckBoxTest() {
    page.configureComponent(parsys, COMPONENT_NAME, UNCHECKED_CHECKBOX_CONFIGURATION);

    CreditCardComponent component =
        (CreditCardComponent) page.getContent(components.getClazz(COMPONENT_NAME));

    assertThat(component.getLabelText(), is(LABEL_TEXT));
    assertThat(component.getCardTypeSelect(), anything());
  }

  private void processAssertsForCheckboxChecked() {
    CreditCardComponent component =
        (CreditCardComponent) page.getContent(components.getClazz(COMPONENT_NAME));

    assertThat(component.getLabelText(), is(LABEL_TEXT));

    bobcatWait.withTimeout(Timeouts.MINIMAL).until(
        CommonExpectedConditions
            .elementNotPresent(By.id(CreditCardComponent.CARD_TYPE_SELECT_ID)));
  }
}
