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
package com.dwaiba.qa.bobcumber;

import com.dwaiba.bdd.demo.po.customersurvey.RadioComponent;
import com.dwaiba.bdd.demo.po.feedback.TextFieldComponent;
import com.dwaiba.bdd.demo.po.feedback.TitleComponent;
import com.dwaiba.qa.bb.aem.Components;

/**
 * Enum that maps a component to its related PageObject class.
 */
public enum DemoComponents implements Components {

  TEXT_FIELD_COMPONENT(TextFieldComponent.class),
  TITLE(TitleComponent.class),
  RADIO_GROUP(RadioComponent.class);

  private final Class<?> clazz;

  DemoComponents(Class<?> clazz) {
    this.clazz = clazz;
  }

  public static DemoComponents fromString(String componentName) {
    String normalized = componentName.replace(" ", "_").toUpperCase();
    return DemoComponents.valueOf(normalized);
  }

  @Override
  public Class<?> getComponentClass() {
    return clazz;
  }
}
