package pl.put.poznan.sortingmadness.logic;

/**
 * Class for keeping custom objects from JSON
 */
public class CustomObject implements Comparable {
    /**
     * Object's JSON saved as String
     */
    private String JSONString;
    /**
     * Object attribute used for sorting
     */
    private String sortAttrib;
    /**
     * Value of sorting attribute
     */
    private Comparable sortAttribValue;

    /**
     * Default constructor
     */
    public CustomObject() {}

    /**
     * Function to compare object with another
     * @param o object to compare with
     * @return negative number if object is lesser than another, positive if greater, 0 if equal
     */
    @Override
    public int compareTo(Object o) {
        CustomObject comp = (CustomObject) o;
        return this.sortAttribValue.compareTo(comp.getSortAttribValue());
    }



    /**
     * getter
     * @return JSONString
     */
    public String getJSONString() {
        return JSONString;
    }

    /**
     * setter
     * @param JSONString
     */
    public void setJSONString(String JSONString) {
        this.JSONString = JSONString;
    }

    /**
     * getter
     * @return sorting attribute
     */
    public String getSortAttrib() {
        return sortAttrib;
    }

    /**
     * setter
     * @param sortAttrib
     */
    public void setSortAttrib(String sortAttrib) {
        this.sortAttrib = sortAttrib;
    }

    /**
     * getter
     * @return sorting attribute value
     */
    public Object getSortAttribValue() {
        return sortAttribValue;
    }

    /**
     * setter
     */
    public void setSortAttribValue(Comparable sortAttribValue) {
        this.sortAttribValue = sortAttribValue;
    }

    /**
     * Function for getting info about object
     * @return String
     */
    @Override
    public String toString() {
        return JSONString;
    }
}
