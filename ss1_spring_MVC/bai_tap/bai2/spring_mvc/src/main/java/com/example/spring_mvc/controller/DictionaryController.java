package com.example.spring_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Controller
public class DictionaryController {
    private static Map<String, String> stringMap = new HashMap<>();

    static {
        stringMap.put("hello", "Xin chào");
        stringMap.put("thanks", "Cảm ơn");
        stringMap.put("goodbye", "Tạm biệt");
        stringMap.put("banana", "Quả chuối");
    }

    @GetMapping("")
    public String display() {
        return "/views";
    }

    @GetMapping("/convert")
    public String translate(@RequestParam String vocabulary, HttpServletRequest request) {
        String result = null;
        for (Map.Entry<String, String> mapSearch : stringMap.entrySet()) {
            if (mapSearch.getKey().contains(vocabulary.toLowerCase(Locale.ROOT))) {
                result = mapSearch.getValue();
                break;
            }
        }
        if (result == null) {
            result = "Không có trong từ điển";
        }
        request.setAttribute("result", result);
        return "/views";
    }
}
