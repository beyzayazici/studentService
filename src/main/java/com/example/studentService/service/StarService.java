package com.example.studentService.service;

import org.springframework.stereotype.Service;

@Service
public class StarService {
    public String drawPattern(int line) {
        int spaceCount;
        var maxStar= line * 2 - 1;
        var result = new StringBuilder();
        result.append("Eşkenar Üçgen\n");
        for(var i = 1; i <= maxStar; i++) {
            spaceCount = (maxStar - i) / 2;
            if (i % 2 == 0 || i == 1) {
                if(spaceCount > 0)
                    result.append(String.format("%0" + spaceCount + "d", 0).replace("0", " "));
                result.append(String.format("%0" + i + "d%n", 0).replace("0", "*"));
            }
        }
        return result.toString();
    }
}
