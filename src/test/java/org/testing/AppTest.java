package org.testing;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;

/**
 * Unit test for simple API.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "stepsdefinition")
public class AppTest
{

}
