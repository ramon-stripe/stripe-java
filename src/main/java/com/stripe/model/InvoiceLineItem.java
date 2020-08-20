package com.stripe.model;

import com.google.gson.annotations.SerializedName;
import com.stripe.net.ApiResource;
import java.util.List;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class InvoiceLineItem extends StripeObject implements HasId {
  /** The amount, in %s. */
  @SerializedName("amount")
  Long amount;

  /**
   * Three-letter <a href="https://www.iso.org/iso-4217-currency-codes.html">ISO currency code</a>,
   * in lowercase. Must be a <a href="https://stripe.com/docs/currencies">supported currency</a>.
   */
  @SerializedName("currency")
  String currency;

  /** An arbitrary string attached to the object. Often useful for displaying to users. */
  @SerializedName("description")
  String description;

  @SerializedName("discount_amounts")
  DiscountAmount discountAmounts;

  /** If true, discounts will apply to this line item. Always false for prorations. */
  @SerializedName("discountable")
  Boolean discountable;

  /**
   * A discount represents the actual application of a coupon to a particular customer. It contains
   * information about when the discount began and when it will end.
   *
   * <p>Related guide: <a href="https://stripe.com/docs/billing/subscriptions/discounts">Applying
   * Discounts to Subscriptions</a>.
   */
  @SerializedName("discounts")
  Discount discounts;

  /** Unique identifier for the object. */
  @Getter(onMethod_ = {@Override})
  @SerializedName("id")
  String id;

  /**
   * The ID of the <a href="https://stripe.com/docs/api/invoiceitems">invoice item</a> associated
   * with this line item if any.
   */
  @SerializedName("invoice_item")
  String invoiceItem;

  /**
   * Has the value {@code true} if the object exists in live mode or the value {@code false} if the
   * object exists in test mode.
   */
  @SerializedName("livemode")
  Boolean livemode;

  /**
   * Set of <a href="https://stripe.com/docs/api/metadata">key-value pairs</a> that you can attach
   * to an object. This can be useful for storing additional information about the object in a
   * structured format. Note that for line items with {@code type=subscription} this will reflect
   * the metadata of the subscription that caused the line item to be created.
   */
  @SerializedName("metadata")
  Map<String, String> metadata;

  /**
   * String representing the object's type. Objects of the same type share the same value.
   *
   * <p>Equal to {@code line_item}.
   */
  @SerializedName("object")
  String object;

  @SerializedName("period")
  InvoiceLineItemPeriod period;

  /** The plan of the subscription, if the line item is a subscription or a proration. */
  @SerializedName("plan")
  Plan plan;

  /** The price of the line item. */
  @SerializedName("price")
  Price price;

  /** Whether this is a proration. */
  @SerializedName("proration")
  Boolean proration;

  /** The quantity of the subscription, if the line item is a subscription or a proration. */
  @SerializedName("quantity")
  Long quantity;

  /** The subscription that the invoice item pertains to, if any. */
  @SerializedName("subscription")
  String subscription;

  /**
   * The subscription item that generated this invoice item. Left empty if the line item is not an
   * explicit result of a subscription.
   */
  @SerializedName("subscription_item")
  String subscriptionItem;

  @SerializedName("tax_amounts")
  TaxAmount taxAmounts;

  /** The tax rates which apply to the line item. */
  @SerializedName("tax_rates")
  List<TaxRate> taxRates;

  /**
   * A string identifying the type of the source of this line item, either an {@code invoiceitem} or
   * a {@code subscription}.
   *
   * <p>One of {@code invoiceitem}, or {@code subscription}.
   */
  @SerializedName("type")
  String type;

  /**
   * For prorations this indicates whether Stripe automatically grouped multiple related debit and
   * credit line items into a single combined line item.
   */
  @SerializedName("unified_proration")
  Boolean unifiedProration;

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
     * type='subscription') that the discount's coupon was applied to, if it was applied directly to
     * a particular invoice item or invoice line item.
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
  public static class InvoiceLineItemPeriod extends StripeObject {
    /** End of the line item's billing period. */
    @SerializedName("end")
    Long end;

    /** Start of the line item's billing period. */
    @SerializedName("start")
    Long start;
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
