package cn.zpeace.springcloud.controller;

import cn.zpeace.springcloud.service.PaymentService;
import cn.zpeace.springcloud.entity.Payment;
import cn.zpeace.springcloud.entity.ResultVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author zpeace
 * @date 2020/12/24
 */
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment")
    public ResultVO<?> create(@RequestBody Payment payment) {
        Integer result = paymentService.create(payment);
        log.info("******插入结果*****:{}",result);
        return ResultVO.success(serverPort);
    }

    @GetMapping("/payment/{id}")
    public ResultVO<?> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("******查询成功*****:{}",payment);
        return ResultVO.success(payment + serverPort);
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLb() {
        return serverPort;
    }

    /**
     * 设置超时调用
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout()
    {
        // 业务逻辑处理正确，但是需要耗费3秒钟
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        return serverPort;
    }
}
