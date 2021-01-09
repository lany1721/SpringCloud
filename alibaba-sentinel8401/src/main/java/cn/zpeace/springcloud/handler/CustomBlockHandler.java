package cn.zpeace.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author zpeace
 * @date 2021/1/7
 */
public class CustomBlockHandler {

    public static String blockHandler1(BlockException blockException) {
        return "blockHandler1";
    }
}
