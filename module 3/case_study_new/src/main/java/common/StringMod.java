package common;

import org.apache.commons.lang3.StringUtils;

public class StringMod {
    public static String[] turnFieldToLabel (String[] list) {
        for (int i = 0; i < list.length; i++) {
            String[] labelArr = list[i].split("_");
            for (int j = 0; j < labelArr.length; j++) {
                labelArr[j] = upperCaseFirstChar(labelArr[j]);
            }
            list[i] = StringUtils.join(labelArr," ");
        }
        return list;
    }

    public static String upperCaseFirstChar(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}
