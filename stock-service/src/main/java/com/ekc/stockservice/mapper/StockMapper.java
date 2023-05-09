package com.ekc.stockservice.mapper;

import com.ekc.stockservice.dto.StockRequest;
import com.ekc.stockservice.dto.StockResponse;
import com.ekc.stockservice.entity.Stock;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StockMapper {

    Stock stockRequestToStock(StockRequest stockRequest);

    StockResponse stockToStockResponse(Stock stock);
}
