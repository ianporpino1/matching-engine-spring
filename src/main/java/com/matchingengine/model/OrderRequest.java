package com.matchingengine.model;

public record OrderRequest(String symbol, double price, int quantity, OrderType orderType) {
}
