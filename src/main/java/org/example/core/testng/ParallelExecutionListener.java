package org.example.core.testng;

import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;

import java.util.List;

public class ParallelExecutionListener implements IAlterSuiteListener {
    @Override
    public void alter(List<XmlSuite> suites) {
        int threadCount = Integer.parseInt(System.getProperty("thread-count", "1"));
        for (XmlSuite suite : suites) {
            suite.setParallel(XmlSuite.ParallelMode.METHODS); // Set parallel mode
            suite.setThreadCount(threadCount); // Set thread count
        }
    }
}