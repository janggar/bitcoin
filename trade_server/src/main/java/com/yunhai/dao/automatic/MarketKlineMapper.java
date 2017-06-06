package com.yunhai.dao.automatic;

import com.yunhai.model.automatic.MarketKline;
import com.yunhai.model.automatic.MarketKlineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MarketKlineMapper {
    int countByExample(MarketKlineExample example);

    int deleteByExample(MarketKlineExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MarketKline record);

    int insertSelective(MarketKline record);

    List<MarketKline> selectByExample(MarketKlineExample example);

    MarketKline selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MarketKline record, @Param("example") MarketKlineExample example);

    int updateByExample(@Param("record") MarketKline record, @Param("example") MarketKlineExample example);

    int updateByPrimaryKeySelective(MarketKline record);

    int updateByPrimaryKey(MarketKline record);
}