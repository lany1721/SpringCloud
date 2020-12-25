package cn.zpeace.springcloud.service;

import cn.zpeace.springcloud.entity.Payment;

/**
 * @author zpeace
 * @date 2020/12/24
 */
public interface PaymentService {

    Integer create(Payment payment);

    Payment getPaymentById(Long id);
}
