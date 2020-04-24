package metanet.poc.orderservice.service.impl;


import metanet.poc.orderservice.dto.OrderDto;
import metanet.poc.orderservice.entity.Order;
import metanet.poc.orderservice.repository.OrderRepository;
import metanet.poc.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public String createOrder(OrderDto dto) {
        Order order = new Order();

        order.setAmount(dto.getAmount());
        order.setOrderUuid(dto.getOrderUuid());
        order.setShippingUuid(dto.getShippingUuid());

        orderRepository.saveAndFlush(order);
        return order.getOrderUuid();
    }

    public List<OrderDto> findAllOrders() {
        List<Order> orders = orderRepository.findAll();

        List<OrderDto> orderDto = orders.stream().map(o -> {
                                                    OrderDto dto = new OrderDto();
                                                    dto.setOrderUuid(o.getOrderUuid());
                                                    dto.setAmount(o.getAmount());
                                                    dto.setShippingUuid(o.getShippingUuid());
                                                    return dto;
                                                }).collect(Collectors.toList());

        return orderDto;
    }
}
