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
package com.dwaiba.qa.bobcumber.steps;

import static com.dwaiba.qa.bb.proxy.record.TrafficLogPredicate.pathStartsWith;
import static com.dwaiba.qa.bb.proxy.record.TrafficLogPredicate.queryParamWithValueExists;
import static com.dwaiba.qa.bb.proxy.record.TrafficLogPredicate.urlStartsWith;

import com.dwaiba.bdd.demo.po.feedback.FeedbackPage;
import com.dwaiba.qa.bb.constants.AemConfigKeys;
import com.dwaiba.qa.bb.proxy.record.TrafficLogAnalyzer;
import com.dwaiba.qa.bb.traffic.aspects.RecordTraffic;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Steps used in traffic capture and analysis scenarios.
 */
public class TrafficCaptureSteps {

  @Inject
  private TrafficLogAnalyzer trafficLogAnalyzer;

  @Inject
  private FeedbackPage feedbackPage;

  @Inject
  @Named(AemConfigKeys.AUTHOR_URL)
  private String authorUrl;

  @Then("request is sent to author")
  public void requestIsSentToAuthor() {
    trafficLogAnalyzer.assertContains(urlStartsWith(authorUrl));
  }

  @Then("'stores init' AJAX call is fired")
  public void storesInitAJAXCallIsFired() {
    trafficLogAnalyzer.assertContains(pathStartsWith(
        "/etc/clientcontext/default/content/jcr:content/stores.init.js").add(
        queryParamWithValueExists("path", "/content/geometrixx/en/toolbar/feedback")));
  }

  @Given("^I open Feedback page with capture$")
  @RecordTraffic
  public void iOpenFeedbackPageWithCapture() {
    feedbackPage.open();
    feedbackPage.isDisplayed();
  }

}
