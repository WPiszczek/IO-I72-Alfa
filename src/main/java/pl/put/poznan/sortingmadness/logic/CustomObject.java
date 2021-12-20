package pl.put.poznan.sortingmadness.logic;

import org.json.JSONException;
import org.json.JSONObject;

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
     * Function for getting sorting attribute value from JSON string
     * @return
     * @throws JSONException
     */
    public Comparable getAttribValueFromJSON() throws JSONException {
        JSONObject jsonObject = new JSONObject(this.JSONString);
        return (Comparable) jsonObject.get(sortAttrib);
    }

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
     * @throws JSONException
     */
    public void setSortAttribValue() throws JSONException {
        this.sortAttribValue = getAttribValueFromJSON();
    }

    /**
     * Function for getting info about object
     * @return
     */
    @Override
    public String toString() {
        return "CustomObject{" +
                "JSONString='" + JSONString + '\'' +
                ", sortAttrib='" + sortAttrib + '\'' +
                ", sortAttribValue=" + sortAttribValue +
                '}';
    }
}
