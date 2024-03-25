package edu.yangao.jarhasxml.controller;

import edu.yangao.jarhasxml.mapper.TestMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    private final TestMapper testMapper;

    public TestController(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    @GetMapping("test")
    public List<String> test() {
        return testMapper.test();
    }
}
