package com.matchingengine.controller.dto;

import com.matchingengine.model.OrderType;

public record OrderRequest(String symbol, double price, int quantity, OrderType orderType) {
}
