package cn.zpeace.springcloud.dao;

import cn.zpeace.springcloud.entity.Payment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Payment)表数据库访问层
 *
 * @author zpeace
 * @date 2020-12-24
 */
@Mapper
public interface PaymentDao extends BaseMapper<Payment> {

}