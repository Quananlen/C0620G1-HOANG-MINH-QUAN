package common;

import org.apache.commons.lang3.text.WordUtils;

public class StringMod {
    public static String[] turnFieldToLabel (String[] list) {
        for (int i = 0; i < list.length; i++) {
            list[i] = list[i].replace("_", " ");
            list[i] = WordUtils.capitalizeFully(list[i]);
        }
        return list;
    }

}
