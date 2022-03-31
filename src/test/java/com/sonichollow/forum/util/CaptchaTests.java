package com.sonichollow.forum.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class CaptchaTests {
    @Test
    public void product(){
        Map<String,String> captchaObject=Captcha.product();
        System.err.println(captchaObject.get("code"));
        System.err.println(captchaObject.get("base64"));
    }
}
