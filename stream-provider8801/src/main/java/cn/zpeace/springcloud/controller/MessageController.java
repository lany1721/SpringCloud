package cn.zpeace.springcloud.controller;

import cn.zpeace.springcloud.service.IMessageProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zpeace
 * @date 2020/12/31
 */
@RestController
@RequiredArgsConstructor
public class MessageController {

    private final IMessageProvider messageProvider;

    @GetMapping("/send")
    public String send() {
        return messageProvider.send();
    }
}
