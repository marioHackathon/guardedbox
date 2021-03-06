package com.guardedbox.entity;

import static com.guardedbox.constants.Constraints.BASE64_PATTERN;
import static com.guardedbox.constants.Constraints.EMAIL_MAX_LENGTH;
import static com.guardedbox.constants.Constraints.EMAIL_MIN_LENGTH;
import static com.guardedbox.constants.Constraints.EMAIL_PATTERN;
import static com.guardedbox.constants.Constraints.ENCRYPTED_PRIVATE_KEY_LENGTH;
import static com.guardedbox.constants.Constraints.ENCRYPTED_VALUE_PATTERN;
import static com.guardedbox.constants.Constraints.HEX_PATTERN;
import static com.guardedbox.constants.Constraints.PUBLIC_KEY_LENGTH;
import static com.guardedbox.constants.Constraints.SECURITY_QUESTIONS_MAX_LENGTH;
import static com.guardedbox.constants.SecurityParameters.ENTROPY_EXPANDER_LENGTH;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * Entity: Account.
 * Contains all the fields.
 * 
 * @author s3curitybug@gmail.com
 *
 */
@Entity
@Table(name = "account")
public class AccountFullEntity
        implements Serializable {

    /** Serial Version UID. */
    private static final long serialVersionUID = 4171368265398710978L;

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

    /** Entropy Expander. */
    @Column(name = "entropy_expander")
    @NotNull
    @Pattern(regexp = HEX_PATTERN)
    @Size(min = ENTROPY_EXPANDER_LENGTH, max = ENTROPY_EXPANDER_LENGTH)
    private String entropyExpander;

    /** Public Key. */
    @Column(name = "public_key")
    @NotBlank
    @Pattern(regexp = BASE64_PATTERN)
    @Size(min = PUBLIC_KEY_LENGTH, max = PUBLIC_KEY_LENGTH)
    private String publicKey;

    /** Security Questions. */
    @Column(name = "security_questions")
    @NotBlank
    @Size(max = SECURITY_QUESTIONS_MAX_LENGTH)
    private String securityQuestions;

    /** Encrypted Private Key. */
    @Column(name = "encrypted_private_key")
    @NotBlank
    @Pattern(regexp = ENCRYPTED_VALUE_PATTERN)
    @Size(min = ENCRYPTED_PRIVATE_KEY_LENGTH, max = ENCRYPTED_PRIVATE_KEY_LENGTH)
    private String encryptedPrivateKey;

    /** Public Key from Security Questions. */
    @Column(name = "public_key_from_security_answers")
    @NotBlank
    @Pattern(regexp = BASE64_PATTERN)
    @Size(min = PUBLIC_KEY_LENGTH, max = PUBLIC_KEY_LENGTH)
    private String publicKeyFromSecurityAnswers;

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
     * @param email The email to set.
     */
    public void setEmail(
            String email) {
        this.email = email;
    }

    /**
     * @return The entropyExpander.
     */
    public String getEntropyExpander() {
        return entropyExpander;
    }

    /**
     * @param entropyExpander The entropyExpander to set.
     */
    public void setEntropyExpander(
            String entropyExpander) {
        this.entropyExpander = entropyExpander;
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
     * @return The securityQuestions.
     */
    public String getSecurityQuestions() {
        return securityQuestions;
    }

    /**
     * @param securityQuestions The securityQuestions to set.
     */
    public void setSecurityQuestions(
            String securityQuestions) {
        this.securityQuestions = securityQuestions;
    }

    /**
     * @return The encryptedPrivateKey.
     */
    public String getEncryptedPrivateKey() {
        return encryptedPrivateKey;
    }

    /**
     * @param encryptedPrivateKey The encryptedPrivateKey to set.
     */
    public void setEncryptedPrivateKey(
            String encryptedPrivateKey) {
        this.encryptedPrivateKey = encryptedPrivateKey;
    }

    /**
     * @return The publicKeyFromSecurityAnswers.
     */
    public String getPublicKeyFromSecurityAnswers() {
        return publicKeyFromSecurityAnswers;
    }

    /**
     * @param publicKeyFromSecurityAnswers The publicKeyFromSecurityAnswers to set.
     */
    public void setPublicKeyFromSecurityAnswers(
            String publicKeyFromSecurityAnswers) {
        this.publicKeyFromSecurityAnswers = publicKeyFromSecurityAnswers;
    }

}
