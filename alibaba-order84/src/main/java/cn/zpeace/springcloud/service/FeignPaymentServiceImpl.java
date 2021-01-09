package cn.zpeace.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author zpeace
 * @date 2021/1/7
 */
@Component
public class FeignPaymentServiceImpl implements FeignPaymentService {
    @Override
    public String getPayment(Long id) {
        return "服务降级";
    }
}
