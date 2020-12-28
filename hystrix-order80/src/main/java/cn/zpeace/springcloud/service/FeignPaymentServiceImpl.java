package cn.zpeace.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author zpeace
 * @date 2020/12/28
 */
@Component
public class FeignPaymentServiceImpl implements FeignPaymentService {
    @Override
    public String success(Long id) {
        return "feign服务降级处理";
    }

    @Override
    public String timeout(Long id) {
        return "feign服务降级处理";
    }
}
