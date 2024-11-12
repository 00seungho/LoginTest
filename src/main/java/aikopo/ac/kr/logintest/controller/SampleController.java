package aikopo.ac.kr.logintest.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/sample/")
public class SampleController {
    @GetMapping("/all")
    public void exAll() {
        log.info("☆ exAll()메소드 호출됨");
    }
    @GetMapping("/member")
    public void exMember() {
        log.info("☆ exMember()메소드 호출됨");
    }
    @GetMapping("/admin")
    public void exAdmin() {
        log.info("☆ exAdmin()메소드 호출됨");
    }
}
