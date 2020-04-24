package metanet.poc.orderservice.service;

import metanet.poc.orderservice.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> findAllOrders();
    String createOrder(OrderDto dto);
}
