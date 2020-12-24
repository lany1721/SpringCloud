package cn.zpeace.springcloud.controller;

import cn.zpeace.springcloud.entity.Payment;
import cn.zpeace.springcloud.entity.ResultVO;
import cn.zpeace.springcloud.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/payment")
    public ResultVO<?> create(@RequestBody Payment payment) {
        Integer result = paymentService.create(payment);
        log.info("******插入结果*****:{}",result);
        return ResultVO.success();
    }

    @GetMapping("/payment/{id}")
    public ResultVO<?> getPaymentById(@PathVariable Long id) {
        return ResultVO.success(paymentService.getPaymentById(id));
    }

}
