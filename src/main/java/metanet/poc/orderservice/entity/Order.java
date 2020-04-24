package metanet.poc.orderservice.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "order_tbl")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id", unique = true, nullable = false)
    private Integer orderId;

    @Column(name = "order_uuid", length = 40)
    private String orderUuid;

    private Date createdDate;

    private BigDecimal amount;

    @Column(name = "shipping_uuid", length = 40)
    private String shippingUuid;

    public Order() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getOrderUuid() {
        return orderUuid;
    }

    public void setOrderUuid(String orderUuid) {
        this.orderUuid = orderUuid;
    }

    public String getShippingUuid() {
        return shippingUuid;
    }

    public void setShippingUuid(String shippingUuid) {
        this.shippingUuid = shippingUuid;
    }
}
