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
import com.dwaiba.bdd.demo.aem.auth.AemLoginTest;
import com.dwaiba.bdd.demo.aem.packages.ContentInstallerTest;
import com.dwaiba.bdd.demo.aem.packages.WcmCommandHandlerActivatorTest;
import com.dwaiba.bdd.demo.aem.wcm.api.WcmCommandHandlerPageCreatorTest;
import com.dwaiba.bdd.demo.jcr.JcrTest;
import com.dwaiba.qa.bb.junit.Modules;
import com.dwaiba.qa.bb.junit.concurrent.ConcurrentSuite;

@Modules(GuiceModule.class)
@RunWith(ConcurrentSuite.class)
@Suite.SuiteClasses({
    AemLoginTest.class,
    JcrTest.class,
    ContentInstallerTest.class,
    WcmCommandHandlerPageCreatorTest.class,
    WcmCommandHandlerActivatorTest.class
})
public class BbAemCommonSuite {
  // Test suite, nothing to add here
}
