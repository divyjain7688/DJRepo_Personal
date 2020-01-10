package com.selenium.ebiz.tools;
public interface SauceOnDemandSessionIdProvider {

    /**
     * Return the session id for the SeleniumRC/WebDriver instance - this equates to the Sauce OnDemand
     * Job id.
     * @return string representing the session id for the SeleniumRC/WebDriver instance
     */
    String getSessionId();
}
