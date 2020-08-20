package com.stripe.model;

import com.google.gson.annotations.SerializedName;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.net.ApiResource;
import com.stripe.net.RequestOptions;
import com.stripe.param.CapabilityUpdateParams;
import java.util.List;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Capability extends ApiResource implements HasId {
  /** The account for which the capability enables functionality. */
  @SerializedName("account")
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<Account> account;

  /** The identifier for the capability. */
  @Getter(onMethod_ = {@Override})
  @SerializedName("id")
  String id;

  /**
   * String representing the object's type. Objects of the same type share the same value.
   *
   * <p>Equal to {@code capability}.
   */
  @SerializedName("object")
  String object;

  /** Whether the capability has been requested. */
  @SerializedName("requested")
  Boolean requested;

  /** Time at which the capability was requested. Measured in seconds since the Unix epoch. */
  @SerializedName("requested_at")
  Long requestedAt;

  @SerializedName("requirements")
  Requirements requirements;

  /**
   * The status of the capability. Can be {@code active}, {@code inactive}, {@code pending}, or
   * {@code unrequested}.
   */
  @SerializedName("status")
  String status;

  /** Get ID of expandable {@code account} object. */
  public String getAccount() {
    return (this.account != null) ? this.account.getId() : null;
  }

  public void setAccount(String id) {
    this.account = ApiResource.setExpandableFieldId(id, this.account);
  }

  /** Get expanded {@code account}. */
  public Account getAccountObject() {
    return (this.account != null) ? this.account.getExpanded() : null;
  }

  public void setAccountObject(Account expandableObject) {
    this.account = new ExpandableField<Account>(expandableObject.getId(), expandableObject);
  }

  /** Updates an existing Account Capability. */
  public Capability update(Map<String, Object> params) throws StripeException {
    return update(params, (RequestOptions) null);
  }

  /** Updates an existing Account Capability. */
  public Capability update(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format(
                "/v1/accounts/%s/capabilities/%s",
                ApiResource.urlEncodeId(this.getAccount()), ApiResource.urlEncodeId(this.getId())));
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, Capability.class, options);
  }

  /** Updates an existing Account Capability. */
  public Capability update(CapabilityUpdateParams params) throws StripeException {
    return update(params, (RequestOptions) null);
  }

  /** Updates an existing Account Capability. */
  public Capability update(CapabilityUpdateParams params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format(
                "/v1/accounts/%s/capabilities/%s",
                ApiResource.urlEncodeId(this.getAccount()), ApiResource.urlEncodeId(this.getId())));
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, Capability.class, options);
  }

  @Getter
  @Setter
  @EqualsAndHashCode(callSuper = false)
  public static class Requirements extends StripeObject {
    /**
     * The date the fields in {@code currently_due} must be collected by to keep the capability
     * enabled for the account.
     */
    @SerializedName("current_deadline")
    Long currentDeadline;

    /**
     * The fields that need to be collected to keep the capability enabled. If not collected by the
     * {@code current_deadline}, these fields appear in {@code past_due} as well, and the capability
     * is disabled.
     */
    @SerializedName("currently_due")
    List<String> currentlyDue;

    /**
     * If the capability is disabled, this string describes why. Possible values are {@code
     * requirement.fields_needed}, {@code pending.onboarding}, {@code pending.review}, {@code
     * rejected_fraud}, or {@code rejected.other}.
     */
    @SerializedName("disabled_reason")
    String disabledReason;

    @SerializedName("errors")
    Errors errors;

    /**
     * The fields that need to be collected assuming all volume thresholds are reached. As they
     * become required, these fields appear in {@code currently_due} as well, and the {@code
     * current_deadline} is set.
     */
    @SerializedName("eventually_due")
    List<String> eventuallyDue;

    /**
     * The fields that weren't collected by the {@code current_deadline}. These fields need to be
     * collected to enable the capability for the account.
     */
    @SerializedName("past_due")
    List<String> pastDue;

    /**
     * Fields that may become required depending on the results of verification or review. An empty
     * array unless an asynchronous verification is pending. If verification fails, the fields in
     * this array become required and move to {@code currently_due} or {@code past_due}.
     */
    @SerializedName("pending_verification")
    List<String> pendingVerification;

    @Getter
    @Setter
    @EqualsAndHashCode(callSuper = false)
    public static class Errors extends StripeObject {
      /**
       * The code for the type of error.
       *
       * <p>One of {@code invalid_address_city_state_postal_code}, {@code invalid_street_address},
       * {@code invalid_value_other}, {@code verification_document_address_mismatch}, {@code
       * verification_document_address_missing}, {@code verification_document_corrupt}, {@code
       * verification_document_country_not_supported}, {@code verification_document_dob_mismatch},
       * {@code verification_document_duplicate_type}, {@code verification_document_expired}, {@code
       * verification_document_failed_copy}, {@code verification_document_failed_greyscale}, {@code
       * verification_document_failed_other}, {@code verification_document_failed_test_mode}, {@code
       * verification_document_fraudulent}, {@code verification_document_id_number_mismatch}, {@code
       * verification_document_id_number_missing}, {@code verification_document_incomplete}, {@code
       * verification_document_invalid}, {@code verification_document_manipulated}, {@code
       * verification_document_missing_back}, {@code verification_document_missing_front}, {@code
       * verification_document_name_mismatch}, {@code verification_document_name_missing}, {@code
       * verification_document_nationality_mismatch}, {@code verification_document_not_readable},
       * {@code verification_document_not_uploaded}, {@code verification_document_photo_mismatch},
       * {@code verification_document_too_large}, {@code verification_document_type_not_supported},
       * {@code verification_failed_address_match}, {@code verification_failed_business_iec_number},
       * {@code verification_failed_document_match}, {@code verification_failed_id_number_match},
       * {@code verification_failed_keyed_identity}, {@code verification_failed_keyed_match}, {@code
       * verification_failed_name_match}, or {@code verification_failed_other}.
       */
      @SerializedName("code")
      String code;

      /**
       * An informative message that indicates the error type and provides additional details about
       * the error.
       */
      @SerializedName("reason")
      String reason;

      /**
       * The specific user onboarding requirement field (in the requirements hash) that needs to be
       * resolved.
       */
      @SerializedName("requirement")
      String requirement;
    }
  }
}
