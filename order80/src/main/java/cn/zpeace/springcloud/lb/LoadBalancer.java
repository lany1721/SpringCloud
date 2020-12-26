package cn.zpeace.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author zpeace
 * @date 2020/12/26
 */
public interface LoadBalancer {
    /**
     * 从服务器实例列表一个获取服务实例
     * @param serviceInstances 服务器实例列表
     * @return 服务实例
     */
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
