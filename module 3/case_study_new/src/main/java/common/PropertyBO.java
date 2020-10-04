package common;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PropertyBO {
    PropertyDAO propertyDAO = new PropertyDAO();

    public String[] getProperty(String column) {
        return propertyDAO.getProperty(column);
    }

    public String[] getCustomerProperty() {
        String[] list = propertyDAO.getProperty("customer");
        List<String> arrayList = new LinkedList<>(Arrays.asList(list));
        arrayList.removeIf(str -> (str.equals("customer_type_id")));
        list = arrayList.toArray(new String[0]);
        return list;
    }
}
