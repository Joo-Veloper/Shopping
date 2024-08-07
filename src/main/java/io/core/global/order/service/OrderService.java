package io.core.global.order.service;

import io.core.global.order.entity.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}