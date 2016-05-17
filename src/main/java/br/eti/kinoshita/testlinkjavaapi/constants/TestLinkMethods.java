/*
 * The MIT License
 *
 * Copyright (c) <2010> <Bruno P. Kinoshita>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.eti.kinoshita.testlinkjavaapi.constants;

/**
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 * @since 1.9.0-1
 */
public enum TestLinkMethods {
	
	ABOUT("tl.about"), 
    ADD_PLATFORM_TO_TEST_PLAN("tl.addPlatformToTestPlan"),
	ADD_TEST_CASE_TO_TEST_PLAN("tl.addTestCaseToTestPlan"), 
    ASSIGN_REQUIREMENTS("tl.assignRequirements"),
    ASSIGN_TEST_CASE_EXECUTION_TASK("tl.assignTestCaseExecutionTask"),
    ASSING_USER_TO_PROJECT("tl.assignUserToProject"),
	CHECK_DEV_KEY("tl.checkDevKey"), 
    CREATE_BUILD("tl.createBuild"), 
	CREATE_REQUIREMENT("tl.createRequirement"),
	CREATE_TEST_CASE("tl.createTestCase"), 
    CREATE_TEST_CASE_STEPS("tl.createTestCaseSteps"), 
	CREATE_TEST_PLAN("tl.createTestPlan"), 
    CREATE_TEST_PROJECT("tl.createTestProject"), 
    CREATE_TEST_SUITE("tl.createTestSuite"), 
    CREATE_USER("tl.createUser"),
    DELETE_EXECUTION("tl.deleteExecution"), 
    DELETE_TEST_CASE_STEPS("tl.deleteTestCaseSteps"), 
    DOES_USER_EXIST("tl.doesUserExist"),
    GENERATOR_DEV_KEY("tl.generateAPIKey"),
    GET_BUILDS_FOR_TEST_PLAN("tl.getBuildsForTestPlan"), 
    GET_EXEC_COUNTERS_BY_BUILD("tl.getExecCountersByBuild"),
    GET_FAILED_TEST_CASES_BY_BUILD("tl.getFailedTestCasesByBuildId"),
    GET_FIRST_LEVEL_TEST_SUITES_FOR_TEST_PROJECT("tl.getFirstLevelTestSuitesForTestProject"), 
    GET_FULL_PATH("tl.getFullPath"), 
    GET_LAST_EXECUTION_RESULT("tl.getLastExecutionResult"), 
    GET_LATEST_BUILD_FOR_TEST_PLAN("tl.getLatestBuildForTestPlan"), 
    GET_PROJECT_TEST_PLANS("tl.getProjectTestPlans"), 
    GET_PROJECT_PLATFORMS("tl.getProjectPlatforms"),
    GET_PROJECTS("tl.getProjects"), 
    GET_TEST_CASE("tl.getTestCase"),
    GET_TEST_CASE_ATTACHMENTS("tl.getTestCaseAttachments"), 
    GET_TEST_CASE_CUSTOM_FIELD_DESIGN_VALUE("tl.getTestCaseCustomFieldDesignValue"), 
    GET_TEST_CASE_CUSTOM_FIELD_TEST_PLAN_DESIGN_VALUE("tl.getTestCaseCustomFieldTestPlanDesignValue"), 
    GET_TEST_CASE_CUSTOM_FIELD_EXECUTION_VALUE("tl.getTestCaseCustomFieldExecutionValue"),
    GET_TEST_CASES_FOR_TEST_SUITE("tl.getTestCasesForTestSuite"), 
    GET_TEST_CASES_FOR_TEST_PLAN("tl.getTestCasesForTestPlan"), 
    GET_TEST_CASES_EXECUTIONS_BY_BUILD_AND_REQUIREMENT("tl.tl.getTestCasesExecutionsByBuildAndRequirement"), 
    GET_TEST_CASES_EXECUTIONS_BY_BUILD_AND_PLATFORM_AND_REQUIREMENT("tl.getTestCasesExecutionsByBuildAndPlatformAndRequirement"), 
    GET_TEST_CASES_COUNT_BY_REQUIREMENT_ID("tl.getTestCasesCountByRequirementId"), 
    GET_TEST_CASES_BY_REQUIREMENT_ID("tl.getTestCasesByRequirementId"),
    GET_TEST_CASES_BY_PROJECT_ID("tl.getAllTestCasesByProjectId"),
    GET_TEST_CASE_KEYWORDS("tl.getTestCaseKeywords"),
    GET_NOT_MAPPED_TEST_CASES("tl.getNotMappedTestCases"),
    GET_MAPPED_REQUIREMENTS_BY_TEST_CASE_ID("tl.getMappedRequirementsByTestCaseId"),
    GET_TEST_CASE_ID_BY_NAME("tl.getTestCaseIDByName"),
    GET_TEST_PLAN_BY_NAME("tl.getTestPlanByName"),
    GET_TEST_PLAN_BY_ID("tl.getTestPlanById"),
    GET_TEST_PLAN_CUSTOM_FIELD_DESIGN_VALUE("tl.getTestPlanCustomFieldDesignValue"),
    GET_TEST_PLAN_PLATFORMS("tl.getTestPlanPlatforms"), 
    GET_TEST_PROJECT_BY_NAME("tl.getTestProjectByName"), 
    GET_TEST_SUITE_BY_ID("tl.getTestSuiteByID"), 
    GET_TEST_SUITES_FOR_TEST_PLAN("tl.getTestSuitesForTestPlan"), 
    GET_TEST_SUITES_FOR_TEST_SUITE("tl.getTestSuitesForTestSuite"),
    GET_TOTALS_FOR_TEST_PLAN("tl.getTotalsForTestPlan"), 
    GET_USER_BY_LOGIN("tl.getUserByLogin"),
    REMOVE_PLATFORM_FROM_TEST_PLAN("tl.removePlatformFromTestPlan"),
    REPEAT("tl.repeat"),
    REPORT_TC_RESULT("tl.reportTCResult"), 
    SAY_HELLO("tl.sayHello"), 
    SET_TEST_MODE("tl.setTestMode"), 
    SET_TEST_CASE_EXECUTION_TYPE("tl.setTestCaseExecutionType"), 
    UPDATE_TEST_CASE("tl.updateTestCase"),
    UPDATE_TEST_CASE_CUSTOM_FIELD_VALUE("tl.updateTestCaseCustomFieldDesignValue"),
    UPLOAD_ATTACHMENT("tl.uploadAttachment"), 
    UPLOAD_EXECUTION_ATTACHMENT("tl.uploadExecutionAttachment"),
    UPLOAD_REQUIREMENT_ATTACHMENT("tl.uploadRequirementAttachment"), 
    UPLOAD_REQUIREMENT_SPECIFICATION_ATTACHMENT("tl.uploadRequirementSpecificationAttachment"), 
    UPLOAD_TEST_CASE_ATTACHMENT("tl.uploadTestCaseAttachment"), 
    UPLOAD_TEST_SUITE_ATTACHMENT("tl.uploadTestSuiteAttachment"), 
    UPLOAD_TEST_PROJECT_ATTACHMENT("tl.uploadTestProjectAttachment")
    ;

    private String value;

	TestLinkMethods(String value) {
		this.value = value;
	}

	public String toString() {
		return this.value;
	}

}

