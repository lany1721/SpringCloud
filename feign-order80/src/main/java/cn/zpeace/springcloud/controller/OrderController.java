package cn.zpeace.springcloud.controller;

import cn.zpeace.springcloud.entity.ResultVO;
import cn.zpeace.springcloud.service.FeignPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zpeace
 * @date 2020/12/26
 */
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final FeignPaymentService feignPaymentService;

    @GetMapping("/order/payment/{id}")
    public ResultVO<?> query(@PathVariable("id") Long id) {
        return feignPaymentService.getPaymentById(id).setMessage("feign");
    }

    @GetMapping(value = "/order/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // 假如消费者只能接受1s 内的远程调用
        return feignPaymentService.paymentFeignTimeout();
    }

}
