package utils;

public class Console {

    /*
     * Set Test Status to Passed
     * @param: description
     */
    public void setPassed(String description){
        System.out.println("\t\t\t" + Utilities.getTimeStamp() + " | PASSED | " + description);
    }

    /*
     * Set Info in Console
     * @param: description
     */
    public void setInfo(String description){
        System.out.println("\t\t\t" + Utilities.getTimeStamp() + " | INFO | " + description);
    }

    /*
     * Set STest Status to Failed
     * @param: description
     */
    public void setFailed(String description, String message){
        System.out.println("\t\t\t" + Utilities.getTimeStamp() + " | FAILED | " + description + " | " + message);
        throw new RuntimeException(description + " | " + message);
    }

    /*
     * Set Step Definition Name
     * @param: Step Definition Name
     */
    public void setStepDefinitionName(String description){
        System.out.println("\t\t[STEP DEFINITION] "+description);
    }

}
