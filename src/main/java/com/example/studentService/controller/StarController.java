package com.example.studentService.controller;
import com.example.studentService.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/api/stars")
@RestController
public class StarController {
    private final StarService starService;

    @Autowired
    public StarController(StarService starService) {
        this.starService = starService;
    }

    @GetMapping("/draw/{line}")
    public String drawStars(@PathVariable int line) {
        return starService.drawPattern(line);
    }

}
