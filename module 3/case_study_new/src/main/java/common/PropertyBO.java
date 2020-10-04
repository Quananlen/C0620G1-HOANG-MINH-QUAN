package common;

public class PropertyBO {
    PropertyDAO propertyDAO = new PropertyDAO();

    public String[] getProperty(String column) {
        return propertyDAO.getProperty(column);
    }
}
