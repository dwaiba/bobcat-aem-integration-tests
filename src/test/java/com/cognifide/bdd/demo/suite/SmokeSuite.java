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

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.dwaiba.bdd.demo.BobcatWaitTest;
import com.dwaiba.bdd.demo.GuiceModule;
import com.dwaiba.bdd.demo.aem.AemCheckboxTest;
import com.dwaiba.bdd.demo.aem.AemContentFinderTest;
import com.dwaiba.bdd.demo.aem.AemTextFieldTest;
import com.dwaiba.bdd.demo.aem.AemContextMenuTest;
import com.dwaiba.bdd.demo.aem.AemDropdownTest;
import com.dwaiba.bdd.demo.aem.AemImageTest;
import com.dwaiba.bdd.demo.aem.AemLookupFieldTest;
import com.dwaiba.bdd.demo.aem.AemParsysTest;
import com.dwaiba.bdd.demo.aem.AemRadioGroupTest;
import com.dwaiba.bdd.demo.aem.AemTextAreaTest;
import com.dwaiba.bdd.demo.aem.auth.AemLoginTest;
import com.dwaiba.bdd.demo.aem.auth.ManualLoginTest;
import com.dwaiba.bdd.demo.aem.list.AemListTest;
import com.dwaiba.bdd.demo.aem.list.AemListItemTest;
import com.dwaiba.bdd.demo.aem.packages.ContentInstallerTest;
import com.dwaiba.bdd.demo.aem.wcm.SiteAdminTest;
import com.dwaiba.bdd.demo.expectedConditions.UrlExpectedConditionsTest;
import com.dwaiba.bdd.demo.jcr.JcrTest;
import com.dwaiba.bdd.demo.misc.RegexMatcherTest;
import com.dwaiba.qa.bb.junit.Modules;

@Modules(GuiceModule.class)
@RunWith(Categories.class)
@IncludeCategory(SmokeTests.class)
@Suite.SuiteClasses({
    ManualLoginTest.class,
    AemLoginTest.class,
    AemCheckboxTest.class,
    AemDropdownTest.class,
    AemImageTest.class,
    AemTextAreaTest.class,
    AemTextFieldTest.class,
    BobcatWaitTest.class,
    AemListTest.class,
    AemListItemTest.class,
    AemRadioGroupTest.class,
    AemContentFinderTest.class,
    AemLookupFieldTest.class,
    AemParsysTest.class,
    JcrTest.class,
    UrlExpectedConditionsTest.class,
    RegexMatcherTest.class,
    ContentInstallerTest.class,
    AemContextMenuTest.class,
    SiteAdminTest.class
})
public class SmokeSuite {
  //Test suite, nothing to add here
}
