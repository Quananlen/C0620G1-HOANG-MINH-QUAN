package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.IDict;

@Controller
public class GreetingController {

    @Autowired
    private IDict dict;

    @GetMapping()
    public String greeting() {
        return "dictionary";
    }

    @GetMapping("/Convert")
    public String convert(@RequestParam String usd, @RequestParam String vnd, ModelMap modelMap) {
        if (usd == "") usd = "0";
        if (vnd == "") vnd = "0";
        double vndNew = Double.parseDouble(usd) * 23000;
        double usdNew = Double.parseDouble(vnd) / 23000;
        modelMap.put("vndNew", vndNew);
        modelMap.put("usdNew", usdNew);
        return "currency_conversion";
    }

    @GetMapping("/Dictionary")
    public String lookUp(@RequestParam String word, Model model) {
//        String[] dict = {"chó", "mèo", "chuột"};
//        String[] dict2 = {"dog", "cat", "mouse"};
//        for (int i = 0; i < dict2.length; i++) {
//            if (word.equals(dict2[i])) model.addAttribute("result", dict[i]);
//        }
        model.addAttribute("result", dict.lookUp(word));
        return "dictionary";
    }
}
