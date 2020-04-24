package metanet.poc.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDto {

    private String orderUuid;
    private String shippingUuid;
    private BigDecimal amount;

    public OrderDto() {}


    public String getOrderUuid() {
        return orderUuid;
    }

    public void setOrderUuid(String orderUuid) {
        this.orderUuid = orderUuid;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getShippingUuid() {
        return shippingUuid;
    }

    public void setShippingUuid(String shippingUuid) {
        this.shippingUuid = shippingUuid;
    }
}
