package com.stripe.model;

import com.google.gson.annotations.SerializedName;
import com.stripe.net.ApiResource;
import java.math.BigDecimal;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class CreditNoteLineItem extends StripeObject implements HasId {
  /**
   * The integer amount in <strong>%s</strong> representing the gross amount being credited for this
   * line item, excluding (exclusive) tax and discounts.
   */
  @SerializedName("amount")
  Long amount;

  /** Description of the item being credited. */
  @SerializedName("description")
  String description;

  /**
   * The integer amount in <strong>%s</strong> representing the discount being credited for this
   * line item.
   */
  @SerializedName("discount_amount")
  Long discountAmount;

  @SerializedName("discount_amounts")
  DiscountAmount discountAmounts;

  /** Unique identifier for the object. */
  @Getter(onMethod_ = {@Override})
  @SerializedName("id")
  String id;

  /** ID of the invoice line item being credited. */
  @SerializedName("invoice_line_item")
  String invoiceLineItem;

  /**
   * Has the value {@code true} if the object exists in live mode or the value {@code false} if the
   * object exists in test mode.
   */
  @SerializedName("livemode")
  Boolean livemode;

  /**
   * String representing the object's type. Objects of the same type share the same value.
   *
   * <p>Equal to {@code credit_note_line_item}.
   */
  @SerializedName("object")
  String object;

  /** The number of units of product being credited. */
  @SerializedName("quantity")
  Long quantity;

  @SerializedName("tax_amounts")
  TaxAmount taxAmounts;

  /** The tax rates which apply to the line item. */
  @SerializedName("tax_rates")
  List<TaxRate> taxRates;

  /**
   * The type of the credit note line item, one of {@code invoice_line_item} or {@code
   * custom_line_item}. When the type is {@code invoice_line_item} there is an additional {@code
   * invoice_line_item} property on the resource the value of which is the id of the credited line
   * item on the invoice.
   */
  @SerializedName("type")
  String type;

  /** The cost of each unit of product being credited. */
  @SerializedName("unit_amount")
  Long unitAmount;

  /** Same as {@code unit_amount}, but contains a decimal value with at most 12 decimal places. */
  @SerializedName("unit_amount_decimal")
  BigDecimal unitAmountDecimal;

  @Getter
  @Setter
  @EqualsAndHashCode(callSuper = false)
  public static class DiscountAmount extends StripeObject {
    /** The amount, in %s, of the discount. */
    @SerializedName("amount")
    Long amount;

    /**
     * A discount represents the actual application of a coupon to a particular customer. It
     * contains information about when the discount began and when it will end.
     *
     * <p>Related guide: <a href="https://stripe.com/docs/billing/subscriptions/discounts">Applying
     * Discounts to Subscriptions</a>.
     */
    @SerializedName("discount")
    Discount discount;

    @Getter
    @Setter
    @EqualsAndHashCode(callSuper = false)
    public static class Discount extends StripeObject implements HasId {
      /**
       * A coupon contains information about a percent-off or amount-off discount you might want to
       * apply to a customer. Coupons may be applied to <a
       * href="https://stripe.com/docs/api#invoices">invoices</a> or <a
       * href="https://stripe.com/docs/api#create_order-coupon">orders</a>. Coupons do not work with
       * conventional one-off <a href="https://stripe.com/docs/api#create_charge">charges</a>.
       */
      @SerializedName("coupon")
      Coupon coupon;

      /** The ID of the customer associated with this discount. */
      @SerializedName("customer")
      @Getter(lombok.AccessLevel.NONE)
      @Setter(lombok.AccessLevel.NONE)
      ExpandableField<Customer> customer;

      /** Always true for a deleted object. */
      @SerializedName("deleted")
      Boolean deleted;

      /**
       * If the coupon has a duration of {@code repeating}, the date that this discount will end. If
       * the coupon has a duration of {@code once} or {@code forever}, this attribute will be null.
       */
      @SerializedName("end")
      Long end;

      /**
       * The ID of the discount object. Discounts cannot be fetched by ID. Use {@code
       * expand[]=discounts} in API calls to expand discount IDs in an array.
       */
      @Getter(onMethod_ = {@Override})
      @SerializedName("id")
      String id;

      /**
       * The invoice that the discount's coupon was applied to, if it was applied directly to a
       * particular invoice.
       */
      @SerializedName("invoice")
      String invoice;

      /**
       * The invoice item {@code id} (or invoice line item {@code id} for invoice line items of
       * type='subscription') that the discount's coupon was applied to, if it was applied directly
       * to a particular invoice item or invoice line item.
       */
      @SerializedName("invoice_item")
      String invoiceItem;

      /**
       * String representing the object's type. Objects of the same type share the same value.
       *
       * <p>Equal to {@code discount}.
       */
      @SerializedName("object")
      String object;

      /** The promotion code applied to create this discount. */
      @SerializedName("promotion_code")
      @Getter(lombok.AccessLevel.NONE)
      @Setter(lombok.AccessLevel.NONE)
      ExpandableField<PromotionCode> promotionCode;

      /** Date that the coupon was applied. */
      @SerializedName("start")
      Long start;

      /**
       * The subscription that this coupon is applied to, if it is applied to a particular
       * subscription.
       */
      @SerializedName("subscription")
      String subscription;

      /** Get ID of expandable {@code customer} object. */
      public String getCustomer() {
        return (this.customer != null) ? this.customer.getId() : null;
      }

      public void setCustomer(String id) {
        this.customer = ApiResource.setExpandableFieldId(id, this.customer);
      }

      /** Get expanded {@code customer}. */
      public Customer getCustomerObject() {
        return (this.customer != null) ? this.customer.getExpanded() : null;
      }

      public void setCustomerObject(Customer expandableObject) {
        this.customer = new ExpandableField<Customer>(expandableObject.getId(), expandableObject);
      }

      /** Get ID of expandable {@code promotionCode} object. */
      public String getPromotionCode() {
        return (this.promotionCode != null) ? this.promotionCode.getId() : null;
      }

      public void setPromotionCode(String id) {
        this.promotionCode = ApiResource.setExpandableFieldId(id, this.promotionCode);
      }

      /** Get expanded {@code promotionCode}. */
      public PromotionCode getPromotionCodeObject() {
        return (this.promotionCode != null) ? this.promotionCode.getExpanded() : null;
      }

      public void setPromotionCodeObject(PromotionCode expandableObject) {
        this.promotionCode =
            new ExpandableField<PromotionCode>(expandableObject.getId(), expandableObject);
      }
    }
  }

  @Getter
  @Setter
  @EqualsAndHashCode(callSuper = false)
  public static class TaxAmount extends StripeObject {
    /** The amount, in %s, of the tax. */
    @SerializedName("amount")
    Long amount;

    /** Whether this tax amount is inclusive or exclusive. */
    @SerializedName("inclusive")
    Boolean inclusive;

    /** The tax rate that was applied to get this tax amount. */
    @SerializedName("tax_rate")
    @Getter(lombok.AccessLevel.NONE)
    @Setter(lombok.AccessLevel.NONE)
    ExpandableField<TaxRate> taxRate;

    /** Get ID of expandable {@code taxRate} object. */
    public String getTaxRate() {
      return (this.taxRate != null) ? this.taxRate.getId() : null;
    }

    public void setTaxRate(String id) {
      this.taxRate = ApiResource.setExpandableFieldId(id, this.taxRate);
    }

    /** Get expanded {@code taxRate}. */
    public TaxRate getTaxRateObject() {
      return (this.taxRate != null) ? this.taxRate.getExpanded() : null;
    }

    public void setTaxRateObject(TaxRate expandableObject) {
      this.taxRate = new ExpandableField<TaxRate>(expandableObject.getId(), expandableObject);
    }
  }
}
