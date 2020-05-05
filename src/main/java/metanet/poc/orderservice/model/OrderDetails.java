package metanet.poc.orderservice.model;

import java.math.BigDecimal;

public class OrderDetails {

  private String itemId;
  private Integer quantity;
  private String cardNumber;
  private BigDecimal totalAmount;

  public OrderDetails(String itemId, Integer quantity, String cardNumber, BigDecimal totalAmount) {
    this.itemId = itemId;
    this.quantity = quantity;
    this.cardNumber = cardNumber;
    this.totalAmount = totalAmount;
  }

  public String getItemId() {
    return itemId;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }

}