package com.example.spring_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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

    @PostMapping("/convert")
    public String translate(@RequestParam String vocabulary, HttpServletRequest request)     {
        String result = stringMap.get(vocabulary.toLowerCase());
        if (!stringMap.containsKey(vocabulary.toLowerCase())){
            result = "Không có trong từ điển";
        }
        request.setAttribute("result", result);
        return "/views";
    }
}
