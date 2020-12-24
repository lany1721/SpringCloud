package cn.zpeace.springcloud.dao;

import cn.zpeace.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * (Payment)表数据库访问层
 *
 * @author zpeace
 * @date 2020-12-24
 */
@Mapper
public interface PaymentDao extends BaseMapper<Payment> {

}