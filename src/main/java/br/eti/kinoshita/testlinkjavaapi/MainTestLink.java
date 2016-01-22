package br.eti.kinoshita.testlinkjavaapi;


import java.net.MalformedURLException;
import java.net.URL;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.TestLinkSession;
import br.eti.kinoshita.testlinkjavaapi.constants.TestCaseDetails;
import br.eti.kinoshita.testlinkjavaapi.constants.TestProjectRole;
import br.eti.kinoshita.testlinkjavaapi.model.Authentication;
import br.eti.kinoshita.testlinkjavaapi.model.TestCase;
import br.eti.kinoshita.testlinkjavaapi.model.TestPlan;
import br.eti.kinoshita.testlinkjavaapi.model.TestProject;
import br.eti.kinoshita.testlinkjavaapi.model.User;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;

public class MainTestLink {

	//252502252866sOny4!
	public static void main(String[] args) {
		
		try {
			String url = "http://192.168.131.221/lib/api/xmlrpc/v1/xmlrpc.php";
			URL testlinkURL = new URL(url);
			
			Authentication authentication = new Authentication("admin", "turmalina");
			TestLinkSession session = new TestLinkSession(testlinkURL, authentication);
			
			String devKey = session.generateDevKey();
			TestLinkAPI api = new TestLinkAPI(testlinkURL, devKey);
			System.out.println(api.ping());
			
			TestCase [] testcases = api.getFailedTestCasesByBuild(1, 7);
			
			for (int i = 0; i< testcases.length; i++) {
				System.out.println(testcases[i].toString());
			}
			
			//System.out.println(api.createRequirement(1, 2, "Requirement2"));
		
			//printTestCases(api);
			//Integer id = createProject(api);
			//createUser(api);
			
			//Authentication authentication2 = new Authentication("franclis.silva", "Mariag83!");
			//TestLinkSession session2 = new TestLinkSession(testlinkURL, authentication2);
			//System.out.println(session2.generateDevKey());
			
			//assingUserToProject(api, id, "franclis.silva");
		} catch (MalformedURLException te) {
			te.printStackTrace(System.err);
			System.exit(-1);
		} catch (TestLinkAPIException e) {
			e.printStackTrace(System.err);
			System.out.println(e.getMessage());
		}
	}
	
	public static void printTestCases(TestLinkAPI api) {
		Integer projectId = 14;
		TestPlan[] testPlans = api.getProjectTestPlans(projectId);

		for (int i = 0; i < testPlans.length; i++) {
			
			TestCase[] testCases = api.getTestCasesForTestPlan(testPlans[i].getId(), null, null, null, null, null, null, null, null, true, TestCaseDetails.FULL); //others filters [not required]
	
			for (int j = 0; j < testCases.length; j++) {
				TestCase testCase = api.getTestCase(testCases[j].getId(), null, null);
				System.out.println(testCase.toString());
				System.out.println("\n \n");
			}
			
		  /*TestSuite [] testSuites = api.getTestSuitesForTestPlan(testPlans[i].getId());
			for (int x = 0; x < testSuites.length; x++) {
				
				System.out.println(testPlans[i].getName());
				
				TestCase[] testCases2 = api.getTestCasesForTestSuite(testSuites[x].getId(), true, TestCaseDetails.FULL);
						
				for (int j = 0; j < testCases2.length; j++) {
					System.out.println(testCases2[j].toString());
				}
			}*/
			
		}
	}
	
	public static Integer createProject(TestLinkAPI api) {
		TestProject testlinkProject = api.createTestProject("Teste5", // testProjectName
				"Teste5", // testProjectPrefix
				"Teste5", // description
				true, // enableRequirements
				true, // enableTestPriority
				true, // enableAutomation
				false, // enableInventory
				true, // isActive
				true); // isPublic [It must be public so that API get access]
		System.out.println(testlinkProject.toString());
		
		return testlinkProject.getId();
		
	}
	
	public static void createUser(TestLinkAPI api) {
		User userCreated = api.createUser("franclis.silva", "Franclis", "Galdino da Silva", "franclis.silva@embedded.ufcg.edu.br", true);
		System.out.println(userCreated.toString());
	}
	
	public static void assingUserToProject(TestLinkAPI api, Integer projectId, String username) {
		api.assignUserToProject(projectId, username, TestProjectRole.SENIOR_TEST);
	}
}
