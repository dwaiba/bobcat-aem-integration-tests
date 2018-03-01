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
package com.dwaiba.bdd.demo.po.summer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dwaiba.qa.bb.aem.dialog.classic.field.image.AemImage;
import com.dwaiba.qa.bb.aem.qualifier.DialogField;
import com.dwaiba.qa.bb.aem.ui.AemDialog;
import com.dwaiba.qa.bb.aem.ui.component.AemComponent;
import com.dwaiba.qa.bb.dragdrop.Draggable;
import com.dwaiba.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;

@PageObject
@AemComponent(cssClassName = "image", group = "General", name = "Image", sidekickCssSelector = ".cq-_47libs_47foundation_47components_47image")
public class ImageComponent {

  @Inject
  private AemDialog dialog;

  @DialogField(css = ".cq-smartfile-_46_47file")
  private AemImage imageField;

  @FindBy(xpath = ".//img")
  private WebElement img;

  public WebElement getImg() {
    return img;
  }

  public String getImgAttribute(WebElement img, String name) {
    return img.getAttribute(name);
  }

  public AemDialog getDialog() {
    return dialog;
  }

  public AemImage getImageField() {
    return imageField;
  }

  public void clear() {
    imageField.clear();
  }

  public String getInfo() {
    return imageField.getImageInfo();
  }

  public void insert(Draggable elementByName) {
    imageField.insert(elementByName);
  }
}
