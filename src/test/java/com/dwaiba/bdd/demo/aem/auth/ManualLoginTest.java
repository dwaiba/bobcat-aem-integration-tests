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
package com.dwaiba.bdd.demo.aem.auth;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import com.dwaiba.bdd.demo.GuiceModule;
import com.dwaiba.bdd.demo.po.login.LoginPage;
import com.dwaiba.bdd.demo.suite.SmokeTests;
import com.dwaiba.qa.bb.junit.Modules;
import com.dwaiba.qa.bb.junit.TestRunner;
import com.google.inject.Inject;

@RunWith(TestRunner.class)
@Modules(GuiceModule.class)
public class ManualLoginTest {

  @Inject
  private LoginPage loginPage;

  @Category(SmokeTests.class)
  @Test
  public void loginAsAuthorTest() throws IOException {
    assertTrue(loginPage.openLoginPage().loginAsAuthor().projectScreenIsDisplayed());
  }

  @Category(SmokeTests.class)
  @Test
  public void logoutTest() {
    loginPage.openLoginPage().loginAsAuthor().openUserDialog().signOut();
    assertTrue(loginPage.loginPageIsDisplayed());
  }
}
