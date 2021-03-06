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
package com.dwaiba.bdd.demo.po.product;

import org.openqa.selenium.support.FindBy;

import com.dwaiba.bdd.demo.po.summer.ImageComponent;
import com.dwaiba.qa.bb.aem.page.AuthorPage;
import com.dwaiba.qa.bb.qualifier.Frame;
import com.dwaiba.qa.bb.qualifier.PageObject;

@PageObject
@Frame("$cq")
public class MandelbrotPage extends AuthorPage {

  private static final String PAGE_URL = "/cf#/content/geometrixx/en/products/mandelbrot.html";

  private static final String PAGE_TITLE = "Mandelbrot Set";

  @FindBy(css = ".body_container .image")
  private ImageComponent imageComponent;

  @Override
  public String getContentPath() {
    return PAGE_URL;
  }

  @Override
  public String getPageTitle() {
    return PAGE_TITLE;
  }

  public ImageComponent getImageComponent() {
    return imageComponent;
  }

}
