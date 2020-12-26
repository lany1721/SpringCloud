package cn.zpeace.springcloud.controller;

import cn.zpeace.springcloud.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zpeace
 * @date 2020/12/26
 */
@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/success/{id}")
    public String success(@PathVariable("id") Long id) {
        return paymentService.success(id) + serverPort;
    }

    @GetMapping("/payment/timeout/{id}")
    public String failure(@PathVariable("id") Long id) {
        return paymentService.timeout(id) + serverPort;
    }
}
