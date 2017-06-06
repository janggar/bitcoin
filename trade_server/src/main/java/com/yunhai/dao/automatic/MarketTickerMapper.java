package com.yunhai.dao.automatic;

import com.yunhai.model.automatic.MarketTicker;
import com.yunhai.model.automatic.MarketTickerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MarketTickerMapper {
    int countByExample(MarketTickerExample example);

    int deleteByExample(MarketTickerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MarketTicker record);

    int insertSelective(MarketTicker record);

    List<MarketTicker> selectByExample(MarketTickerExample example);

    MarketTicker selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MarketTicker record, @Param("example") MarketTickerExample example);

    int updateByExample(@Param("record") MarketTicker record, @Param("example") MarketTickerExample example);

    int updateByPrimaryKeySelective(MarketTicker record);

    int updateByPrimaryKey(MarketTicker record);
}