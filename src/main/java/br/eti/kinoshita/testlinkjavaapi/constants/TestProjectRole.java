package br.eti.kinoshita.testlinkjavaapi.constants;

public enum TestProjectRole {

	TEST_DESIGNER("test designer"),
	GUEST("guest"),
	SENIOR_TEST("senior tester"),
	TESTER("tester"),
	ADMINISTRATOR("admin"),
	LEADER("leader");
	
	
	private String value;

	TestProjectRole(String value) {
		this.value = value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
    	return this.value;
    }
	
}
