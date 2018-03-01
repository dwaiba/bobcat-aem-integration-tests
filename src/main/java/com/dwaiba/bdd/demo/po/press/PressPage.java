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
package com.dwaiba.bdd.demo.po.press;

import org.openqa.selenium.support.FindBy;

import com.dwaiba.qa.bb.aem.page.AuthorPage;
import com.dwaiba.qa.bb.aem.ui.sidekick.AemSidekick;
import com.dwaiba.qa.bb.qualifier.Frame;
import com.dwaiba.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;

@PageObject
@Frame("$cq")
public class PressPage extends AuthorPage {

  private static final String URL = "/cf#/content/geometrixx/en/company/press.html";

  private static final String PAGE_TITLE = "Press Center";

  @FindBy(css = ".cq-element-actions_47lightbox")
  private LightBoxComponent lightboxComponent;

  @Inject
  private PagePropertiesComponent pageProperties;

  @Inject
  private AemSidekick sidekick;

  @Override
  public String getContentPath() {
    return URL;
  }

  @Override
  public String getPageTitle() {
    return PAGE_TITLE;
  }

  public LightBoxComponent getLightboxComponent() {
    return lightboxComponent;
  }

  public AemSidekick getSidekick() {
    return sidekick;
  }

  public PagePropertiesComponent getPageProperties() {
    return pageProperties;
  }

}
