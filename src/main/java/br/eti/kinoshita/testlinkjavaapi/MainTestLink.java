package br.eti.kinoshita.testlinkjavaapi;
import java.net.MalformedURLException;
import java.net.URL;

import br.eti.kinoshita.testlinkjavaapi.constants.RequirementStatus;
import br.eti.kinoshita.testlinkjavaapi.constants.RequirementType;

public class MainTestLink {

	public static void main(String [] args) throws MalformedURLException {
		URL apiUrl = new URL("https://testlink-test.virtus.ufcg.edu.br:443/lib/api/xmlrpc/v1/xmlrpc.php");
		String apiKey = "aa14c1f04b8faa259e59fc83f62b37ed";

		TestLinkAPI api =  new TestLinkAPI(apiUrl, apiKey);
		
		System.out.println(api.createRequirement(1786, 2, "Test2", RequirementStatus.DRAFT, RequirementType.INFO));
	}
	
}
