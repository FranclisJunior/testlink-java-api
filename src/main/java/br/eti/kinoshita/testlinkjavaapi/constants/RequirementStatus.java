package br.eti.kinoshita.testlinkjavaapi.constants;

public enum RequirementStatus {

	DRAFT('D'),
	FINISH('F'),
	IMPLEMENTED('I'),
	NOT_TESTABLE('N'),
	OBSOLETE('O'),
	REVIEW('R'),
	REWORK('W'),
	VALID('V');
	
	private char value;
	
	private RequirementStatus(char value) {
		this.value = value;
	}
	
    public String toString() {
    	return Character.toString(this.value);
    }
	
    public static RequirementStatus getRequirementStatus(char value) {
    	switch (value) {
    	case 'd':
    	case 'D':
    	    return DRAFT;
    	case 'f':
    	case 'F':
    	    return FINISH;
    	case 'i':
    	case 'I':
    	    return IMPLEMENTED;
    	case 'n':
    	case 'N':
    	    return NOT_TESTABLE;
    	case 'o':
    	case 'O':
    	    return OBSOLETE;
    	case 'r':
    	case 'R':
    	    return REVIEW;
    	case 'w':
    	case 'W':
    	    return REVIEW;
    	case 'v':
    	case 'V':
    	    return VALID;
    	}
    	
    	return null;
    }
    
}
