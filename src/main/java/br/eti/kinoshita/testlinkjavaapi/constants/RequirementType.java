package br.eti.kinoshita.testlinkjavaapi.constants;

public enum RequirementType {

	INFO('1'),
	FEATURE('2'),
	USE_CASE('3'),
	INTERFACE('4'),
	NON_FUNCTIONAL('5'),
	CONSTRAIN('6'),
	SYSTEM_FUNCTION('7');
	
	private char value;
	
	private RequirementType(char value) {
		this.value = value;
	}

	public String toString() {
		return Character.toString(this.value);
	}
	
	public static RequirementType getRequirementType(char value) {
    	switch (value) {
    	case '1':
    	    return INFO;
    	case '2':
    	    return FEATURE;
    	case '3':
    	    return USE_CASE;
    	case '4':
    	    return INTERFACE;
    	case '5':
    	    return NON_FUNCTIONAL;
    	case '6':
    	    return CONSTRAIN;
    	case '7':
    	    return SYSTEM_FUNCTION;
    	}
    	return null;
    }
}
