package com.stripe.model;

import com.google.gson.annotations.SerializedName;
import com.stripe.net.ApiResource;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class LineItem extends StripeObject implements HasId {
  /** Total before any discounts or taxes is applied. */
  @SerializedName("amount_subtotal")
  Long amountSubtotal;

  /** Total after discounts and taxes. */
  @SerializedName("amount_total")
  Long amountTotal;

  /**
   * Three-letter <a href="https://www.iso.org/iso-4217-currency-codes.html">ISO currency code</a>,
   * in lowercase. Must be a <a href="https://stripe.com/docs/currencies">supported currency</a>.
   */
  @SerializedName("currency")
  String currency;

  /** Always true for a deleted object. */
  @SerializedName("deleted")
  Boolean deleted;

  /**
   * An arbitrary string attached to the object. Often useful for displaying to users. Defaults to
   * product name.
   */
  @SerializedName("description")
  String description;

  @SerializedName("discounts")
  DiscountAmount discounts;

  /** Unique identifier for the object. */
  @Getter(onMethod_ = {@Override})
  @SerializedName("id")
  String id;

  /**
   * String representing the object's type. Objects of the same type share the same value.
   *
   * <p>Equal to {@code item}.
   */
  @SerializedName("object")
  String object;

  /**
   * Prices define the unit cost, currency, and (optional) billing cycle for both recurring and
   * one-time purchases of products. <a href="https://stripe.com/docs/api#products">Products</a>
   * help you track inventory or provisioning, and prices help you track payment terms. Different
   * physical goods or levels of service should be represented by products, and pricing options
   * should be represented by prices. This approach lets you change prices without having to change
   * your provisioning scheme.
   *
   * <p>For example, you might have a single &quot;gold&quot; product that has prices for $10/month,
   * $100/year, and €9 once.
   *
   * <p>Related guides: <a
   * href="https://stripe.com/docs/billing/subscriptions/set-up-subscription">Set up a
   * subscription</a>, <a href="https://stripe.com/docs/billing/invoices/create">create an
   * invoice</a>, and more about <a href="https://stripe.com/docs/billing/prices-guide">products and
   * prices</a>.
   */
  @SerializedName("price")
  Price price;

  /** The quantity of products being purchased. */
  @SerializedName("quantity")
  Long quantity;

  @SerializedName("taxes")
  Tax taxes;

  @Getter
  @Setter
  @EqualsAndHashCode(callSuper = false)
  public static class DiscountAmount extends StripeObject {
    /** The amount discounted. */
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
  public static class Tax extends StripeObject {
    /** Amount of tax applied for this rate. */
    @SerializedName("amount")
    Long amount;

    /**
     * Tax rates can be applied to <a
     * href="https://stripe.com/docs/billing/invoices/tax-rates">invoices</a>, <a
     * href="https://stripe.com/docs/billing/subscriptions/taxes">subscriptions</a> and <a
     * href="https://stripe.com/docs/payments/checkout/set-up-a-subscription#tax-rates">Checkout
     * Sessions</a> to collect tax.
     *
     * <p>Related guide: <a href="https://stripe.com/docs/billing/taxes/tax-rates">Tax Rates</a>.
     */
    @SerializedName("rate")
    TaxRate rate;
  }
}
