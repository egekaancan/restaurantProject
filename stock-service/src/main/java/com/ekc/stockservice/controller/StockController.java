package com.ekc.stockservice.controller;

import com.ekc.stockservice.dto.StockRequest;
import com.ekc.stockservice.dto.StockResponse;
import com.ekc.stockservice.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/stockApi")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping("/getStocks")
    public ResponseEntity<List<StockResponse>> getStocks() {
        return ResponseEntity.ok(stockService.getStocks());
    }

    @GetMapping("/getStockByName")
    public ResponseEntity<StockResponse> getStockByName(@PathVariable String stockName) {
        return ResponseEntity.ok(stockService.getStockByName(stockName));
    }

    @PostMapping("/save")
    public ResponseEntity<StockResponse> saveStock(@RequestBody StockRequest stockRequest) {
        StockResponse stockResponse = stockService.saveStock(stockRequest);
        return new ResponseEntity<>(stockResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StockResponse> updateStockById(@PathVariable Long id, @RequestBody StockRequest stockRequest) {
        return ResponseEntity.ok(stockService.updateStockById(id,stockRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StockResponse> deleteStockById(@PathVariable Long id) {
        return ResponseEntity.ok(stockService.deleteStockById(id));
    }
}
