package cn.zpeace.springcloud.controller;

import cn.zpeace.springcloud.entity.Payment;
import cn.zpeace.springcloud.service.FeignPaymentService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zpeace
 * @date 2021/1/7
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class CircleBreakerController {

    private final RestTemplate restTemplate;

    private final FeignPaymentService feignPaymentService;

    @Value("${rpc.payment-service}")
    private String paymentService;

    @GetMapping(value = "/order/payment/{id}")
//    @SentinelResource(value = "getPayment",fallback = "handlerFallback")
//    @SentinelResource(value = "getPayment",blockHandler = "blockHandler")
    @SentinelResource(value = "getPayment",blockHandler = "blockHandler",fallback = "handlerFallback")
    public String getPayment(@PathVariable("id") Long id) {
        Payment payment = restTemplate.getForObject(paymentService + "/payment/" + id, Payment.class);
        if (id >= 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (payment == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }
        return payment.toString();
    }

    /**
     *  本例是fallback
     */
    public String handlerFallback(@PathVariable  Long id,Throwable e) {
        return "兜底异常handlerFallback,exception内容  "+e.getMessage();
    }

    /**
     *  本例是blockHandler
     */
    public String blockHandler(@PathVariable  Long id, BlockException blockException) {
        Payment payment = new Payment(id,"null");
        return "blockHandler-sentinel限流,无此流水: blockException  "+blockException.getMessage();
    }

    @GetMapping("/order/feign/{id}")
    public String getPaymentByFeign(@PathVariable("id") Long id) {
        return feignPaymentService.getPayment(id);
    }
}
