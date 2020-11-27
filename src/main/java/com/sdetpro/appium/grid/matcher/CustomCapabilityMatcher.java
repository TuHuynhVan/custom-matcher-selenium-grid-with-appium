package com.sdetpro.appium.grid.matcher;

import org.openqa.grid.internal.utils.DefaultCapabilityMatcher;

import java.util.Map;
import java.util.Objects;

public class CustomCapabilityMatcher extends DefaultCapabilityMatcher {

    @Override
    public boolean matches(Map<String, Object> nodeCapability, Map<String, Object> requestedCapability) {
        final String udidStringInCap = "udid";
        final String appiumUdid = "appium:".concat(udidStringInCap);
        final String browserName = "browserName";

        // If the request does not have the special capability,
        // we return what the DefaultCapabilityMatcher returns
        boolean result;
        if (requestedCapability.containsKey(udidStringInCap)) {
            result = matcher(nodeCapability, requestedCapability, udidStringInCap, udidStringInCap);
        } else if (requestedCapability.containsKey(appiumUdid)) {
            result = matcher(nodeCapability, requestedCapability, udidStringInCap, appiumUdid);
        } else if (requestedCapability.containsKey(browserName)) {
            result = matcher(nodeCapability, requestedCapability, browserName, browserName);
        } else {
            System.out.println("Basic matcher");
            result = super.matches(nodeCapability, requestedCapability);
        }

        if (result) {
            System.out.println("Node capabilities:\n" + nodeCapability + "\n===");
        }

        return result;
    }

    private boolean matcher(Map<String, Object> nodeCapability, Map<String, Object> requestedCapability, String nCap, String rCap) {
        if (!nodeCapability.containsKey(nCap)) return false;

        String expected = (String) requestedCapability.get(rCap);
        String actual = (String) nodeCapability.get(nCap);

        boolean result = Objects.equals(expected, actual);
        System.out.println(String.format("Is %s matching (A==E): '%s'=='%s'. Result: %s", nCap, actual, expected, result));

        return result;
    }
}