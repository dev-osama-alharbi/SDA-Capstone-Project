package sda.capstone.API.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Applications {

    private Integer id;
    private String name;
    private String shortName;
    private String description;
    private String baseUri;
    private String domainName;
    private String environment;
    private Integer defaultMembershipTypeId;
    private Boolean isEnabled;
    private Boolean isSubscriptionRequired;
    private Boolean isSelfRegistrationEnabled;
    private Boolean isPasswordRecoveryEnabled;
    private Boolean isExternalIdpLoginEnabled;
    private Boolean isMfaEnabled;
    private String subscriptionPath;
    private String loginPath;
    private Integer logoId;
    private String createdAt;
    private String updatedAt;
    private String updatedBy;
    private Integer updated_by;

}
