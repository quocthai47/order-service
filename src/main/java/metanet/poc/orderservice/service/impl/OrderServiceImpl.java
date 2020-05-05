package metanet.poc.orderservice.service.impl;


import io.seata.spring.annotation.GlobalTransactional;
import metanet.poc.orderservice.client.InventoryFeignClient;
import metanet.poc.orderservice.client.PaymentFeignClient;
import metanet.poc.orderservice.dto.AccountDto;
import metanet.poc.orderservice.dto.OrderDto;
import metanet.poc.orderservice.dto.PaymentDto;
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

    @Autowired
    private InventoryFeignClient inventoryFeignClient;

    @Autowired
    private PaymentFeignClient paymentFeignClient;


    @Override
    @GlobalTransactional
    public String createOrder(OrderDto dto) {
        Order order = new Order();

        order.setOrderUuid(dto.getOrderUuid());
        PaymentDto paymentInfo = dto.getPaymentInfo();

        orderRepository.save(order);
        inventoryFeignClient.reduceStock(dto.getSelectedProduct());
        paymentFeignClient.reduceBalance(new AccountDto(paymentInfo.getAccountId(), paymentInfo.getName(), paymentInfo.getTotalAmount()));

        return order.getOrderUuid();
    }


    public List<OrderDto> findAllOrders() {


        List<Order> orders = orderRepository.findAll();
        List<OrderDto> orderDto = orders.stream().map(o -> {
            OrderDto dto = new OrderDto();
            dto.setOrderUuid(o.getOrderUuid());
            return dto;
        }).collect(Collectors.toList());

        return orderDto;
    }


}
