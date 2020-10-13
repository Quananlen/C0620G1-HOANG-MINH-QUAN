package services;

import org.springframework.stereotype.Service;

@Service
public class Dict implements IDict {

    @Override
    public String lookUp(String word) {
        String[] dict = {"chó", "mèo", "chuột"};
        String[] dict2 = {"dog", "cat", "mouse"};
        for (int i = 0; i < dict2.length; i++) {
            if (word.equals(dict2[i])) return dict[i];
        }
        return "No result";
    }
}
