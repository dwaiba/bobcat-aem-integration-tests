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
package com.dwaiba.bdd.demo.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.dwaiba.bdd.demo.GuiceModule;
import com.dwaiba.bdd.demo.aem.AemContentFinderTest;
import com.dwaiba.bdd.demo.aem.AemBubbleMessageTest;
import com.dwaiba.bdd.demo.aem.AemCheckboxTest;
import com.dwaiba.bdd.demo.aem.AemContextMenuTest;
import com.dwaiba.bdd.demo.aem.AemDropdownTest;
import com.dwaiba.bdd.demo.aem.AemImageTest;
import com.dwaiba.bdd.demo.aem.AemLookupFieldTest;
import com.dwaiba.bdd.demo.aem.AemParsysTest;
import com.dwaiba.bdd.demo.aem.AemRadioGroupTest;
import com.dwaiba.bdd.demo.aem.AemRichtextTest;
import com.dwaiba.bdd.demo.aem.AemSidekickTest;
import com.dwaiba.bdd.demo.aem.AemTextAreaTest;
import com.dwaiba.bdd.demo.aem.AemTextFieldTest;
import com.dwaiba.bdd.demo.aem.ValidationWindowTest;
import com.dwaiba.bdd.demo.aem.dialog.TabsTest;
import com.dwaiba.bdd.demo.aem.list.AemListTest;
import com.dwaiba.bdd.demo.aem.list.AemListItemTest;
import com.dwaiba.bdd.demo.aem.tags.AemTagsTest;
import com.dwaiba.bdd.demo.aem.wcm.SiteAdminTest;
import com.dwaiba.qa.bb.junit.Modules;
import com.dwaiba.qa.bb.junit.concurrent.ConcurrentSuite;

@Modules(GuiceModule.class)
@RunWith(ConcurrentSuite.class)
@Suite.SuiteClasses({
    AemImageTest.class,
    AemTextFieldTest.class,
    AemContentFinderTest.class,
    AemLookupFieldTest.class,
    AemParsysTest.class,
    AemContextMenuTest.class,
    AemTagsTest.class,
    AemRadioGroupTest.class,
    TabsTest.class,
    AemBubbleMessageTest.class,
    AemSidekickTest.class,
    SiteAdminTest.class,
    AemRichtextTest.class,
    AemListItemTest.class,
    AemListTest.class,
    AemCheckboxTest.class,
    AemDropdownTest.class,
    AemTextAreaTest.class,
    ValidationWindowTest.class
})
public class BbAemClassicSuite {
  //Test suite, nothing to add here
}
