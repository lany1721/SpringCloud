package cn.zpeace.springcloud.controller;

import cn.zpeace.springcloud.handler.CustomBlockHandler;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author zpeace
 * @date 2021/1/5
 */
@Slf4j
@RestController
public class FlowLimitController {

    @GetMapping("/test/a")
    public String testA() {
        return "testA";
    }

    @GetMapping("/test/b")
    public String testB() {
        return "testB";
    }

    /**
     * 慢调用降级
     * 最大 RT 200ms
     * 比例阈值 1
     * 熔断时长 5s
     * 最小请求数 5
     * 每秒请求数达到5个，并且平均响应时间大约200ms 熔断该接口5s
     */
    @GetMapping("/test/c")
    public String testC()
    {
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("testC 测试RT");
        return "testC";
    }

    /**
     * 异常比例降级
     * 比例阈值 0.2
     * 熔断时长 5s
     * 最小请求数 5
     * 每秒请求数达到5个，并且发生异常的比例达到0.2 熔断该接口5s
     */
    @GetMapping("/test/d")
    public String testD()
    {
        log.info("testD 异常比例");
        int age = 10 / 0;
        return "testD";
    }

    /**
     * 异常异常数
     * 异常数 5
     * 熔断时长 5s
     * 最小请求数 5
     * 每秒请求数达到5个，并且1m内异常数达到5 熔断该接口
     */
    @GetMapping("/test/e")
    public String testE()
    {
        log.info("testE 测试异常数");
        int age = 10/0;
        return "------testE 测试异常数";
    }

    /**
     * 热点数据测试
     * 配置自定义的流控降级提示
     */
    @GetMapping("/test/f")
    @SentinelResource(value = "/test/f",blockHandler = "blockHandler")
    public String testF(@RequestParam(required = false) String p1,
                        @RequestParam(required = false) String p2) {
        log.info("testF 热点数据测试,p1:{},p2:{}",p1,p2);
        return "testF";
    }

    public String blockHandler (String p1, String p2, BlockException exception) {
        //sentinel系统默认的提示：Blocked by Sentinel (flow limiting)
        return "------deal_testHotKey,o(╥﹏╥)o";
    }

    /**
     * 配置自定义的流控降级提示
     */
    @GetMapping("/test/g")
    @SentinelResource(value = "/test/g",
            blockHandlerClass = {CustomBlockHandler.class},
            blockHandler = "blockHandler1")
    public String testG() {
        log.info("testG 配置自定义的流控降级提示");
        return "testG";
    }

}
