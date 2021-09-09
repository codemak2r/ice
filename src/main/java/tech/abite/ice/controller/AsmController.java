package tech.abite.ice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zw.wen
 */
@RestController
@RequestMapping("/api/accurate")
public class AsmController {

    @PostMapping("/analysis")
    public void parse(){

    }
}
