package metanet.poc.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDto {

    private String orderUuid;

    private ProductDto selectedProduct;

    private PaymentDto paymentInfo;

    public OrderDto() {
    }


    public String getOrderUuid() {
        return orderUuid;
    }

    public void setOrderUuid(String orderUuid) {
        this.orderUuid = orderUuid;
    }

    public ProductDto getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(ProductDto selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public PaymentDto getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentDto paymentInfo) {
        this.paymentInfo = paymentInfo;
    }
}
