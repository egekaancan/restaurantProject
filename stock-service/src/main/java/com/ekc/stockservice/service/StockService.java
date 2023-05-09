package com.ekc.stockservice.service;

import com.ekc.stockservice.dto.StockRequest;
import com.ekc.stockservice.dto.StockResponse;
import com.ekc.stockservice.entity.Stock;
import com.ekc.stockservice.mapper.StockMapper;
import com.ekc.stockservice.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    private final StockMapper stockMapper;

    public List<StockResponse> getStocks() {
        List<StockResponse> stocks = stockRepository.findAll()
                .stream().map(stockMapper::stockToStockResponse).collect(Collectors.toList());
        return stocks;
    }

    public StockResponse getStockByName(String stockName) {
        StockResponse stockResponse = stockMapper.stockToStockResponse(stockRepository.findByStockName(stockName));
        return stockResponse;
    }

    public StockResponse saveStock(StockRequest stockRequest) {
        Stock stock = stockMapper.stockRequestToStock(stockRequest);
        stockRepository.save(stock);
        return stockMapper.stockToStockResponse(stock);
    }

    public StockResponse updateStockById(Long id, StockRequest stockRequest) {
        Stock stock = stockRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        stock.setStockType(stockRequest.getStockType());
        stock.setStockName(stockRequest.getStockName());
        stockRepository.save(stock);
        return stockMapper.stockToStockResponse(stock);
    }

    public StockResponse deleteStockById(Long id) {
        Stock stock = stockRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        stockRepository.delete(stock);
        return stockMapper.stockToStockResponse(stock);
    }
}
