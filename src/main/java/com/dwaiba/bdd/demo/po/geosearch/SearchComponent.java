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
package com.dwaiba.bdd.demo.po.geosearch;

import com.dwaiba.bdd.demo.po.ComponentWithDialog;
import com.dwaiba.qa.bb.aem.dialog.classic.field.lookup.AemLookupField;
import com.dwaiba.qa.bb.aem.qualifier.DialogField;
import com.dwaiba.qa.bb.aem.ui.AemDialog;
import com.dwaiba.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;

@PageObject
public class SearchComponent implements ComponentWithDialog {

  @Inject
  private AemDialog dialog;

  @DialogField(label = "Path to search in")
  private AemLookupField lookupField;

  @Override
  public AemDialog getDialog() {
    return dialog;
  }

  public AemLookupField getLookupField() {
    return lookupField;
  }

}
