package cn.zpeace.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author zpeace
 * @date 2020/12/26
 */
@Service
public class PaymentService {

    public String success(Long id) {
        //正常业务
        return Thread.currentThread().getName() + "success" + id;
    }

    public String timeout(Long id) {
        //处理时间长的业务
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        return Thread.currentThread().getName() + "timeout" + id;
    }
}
