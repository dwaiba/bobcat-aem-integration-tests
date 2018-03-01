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
package com.dwaiba.bdd.demo.po.frame;

import org.openqa.selenium.WebElement;

import com.dwaiba.qa.bb.qualifier.CurrentScope;
import com.dwaiba.qa.bb.qualifier.Frame;
import com.dwaiba.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;

@PageObject
@Frame("$2")
public class FrameWithIndex {

  @Inject
  @CurrentScope
  private WebElement currentScope;

  public String getText() {
    return currentScope.getText();
  }

}
