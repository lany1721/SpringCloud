package cn.zpeace.springcloud.controller;

import cn.zpeace.springcloud.service.FeignPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zpeace
 * @date 2020/12/28
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@DefaultProperties(defaultFallback = "globalHandler")
public class OrderController {

    private final FeignPaymentService feignPaymentService;

    @GetMapping("/order/payment/success/{id}")
    String success(@PathVariable("id") Long id) {
        return feignPaymentService.success(id);
    }

    @GetMapping("/order/payment/timeout/{id}")
//    @HystrixCommand(
//            fallbackMethod = "timeoutHandler",
//            commandProperties = {
//                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000") // 3s内正常响应,超出3s进行服务降级
//            }
//    )
    @HystrixCommand
    String timeout(@PathVariable("id") Long id) {
        return feignPaymentService.timeout(id);
    }


    public String timeoutHandler(Long id){
        return "对方服务器繁忙o(╥﹏╥)o"+id;
    }

    // 下面是全局fallback方法
    public String globalHandler() {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }
}
