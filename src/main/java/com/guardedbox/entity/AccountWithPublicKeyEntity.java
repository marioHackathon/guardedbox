package com.guardedbox.entity;

import static com.guardedbox.constants.Constraints.BASE64_PATTERN;
import static com.guardedbox.constants.Constraints.EMAIL_MAX_LENGTH;
import static com.guardedbox.constants.Constraints.EMAIL_MIN_LENGTH;
import static com.guardedbox.constants.Constraints.EMAIL_PATTERN;
import static com.guardedbox.constants.Constraints.PUBLIC_KEY_LENGTH;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * Entity: Account.
 * Contains the following fields: accountId, email, publicKey.
 * 
 * @author s3curitybug@gmail.com
 *
 */
@Entity
@Table(name = "account")
public class AccountWithPublicKeyEntity
        implements Serializable {

    /** Serial Version UID. */
    private static final long serialVersionUID = -3866191874226530489L;

    /** Account ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    @Positive
    private Long accountId;

    /** Email. */
    @Column(name = "email")
    @NotBlank
    @Email(regexp = EMAIL_PATTERN)
    @Size(min = EMAIL_MIN_LENGTH, max = EMAIL_MAX_LENGTH)
    private String email;

    /** Public Key. */
    @Column(name = "public_key")
    @NotBlank
    @Pattern(regexp = BASE64_PATTERN)
    @Size(min = PUBLIC_KEY_LENGTH, max = PUBLIC_KEY_LENGTH)
    private String publicKey;

    /**
     * Default Constructor.
     */
    public AccountWithPublicKeyEntity() {}

    /**
     * Constructor with accountId.
     * 
     * @param accountId The accountId to set.
     */
    public AccountWithPublicKeyEntity(
            Long accountId) {
        this.accountId = accountId;
    }

    /**
     * @return The accountId.
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * @param accountId The accountId to set.
     */
    public void setAccountId(
            Long accountId) {
        this.accountId = accountId;
    }

    /**
     * @return The email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return The publicKey.
     */
    public String getPublicKey() {
        return publicKey;
    }

    /**
     * @param publicKey The publicKey to set.
     */
    public void setPublicKey(
            String publicKey) {
        this.publicKey = publicKey;
    }

    /**
     * @param email The email to set.
     */
    public void setEmail(
            String email) {
        this.email = email;
    }

}
