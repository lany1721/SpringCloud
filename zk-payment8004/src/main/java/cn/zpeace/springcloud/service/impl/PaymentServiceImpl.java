package cn.zpeace.springcloud.service.impl;

import cn.zpeace.springcloud.dao.PaymentDao;
import cn.zpeace.springcloud.entity.Payment;
import cn.zpeace.springcloud.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author zpeace
 * @date 2020/12/24
 */
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentDao paymentDao;


    @Override
    public Integer create(Payment payment) {
        return paymentDao.insert(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.selectById(id);
    }
}
