package sda.capstone.API.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllMemberships {
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("id")
    private int id;

    @JsonProperty("app_id")
    private int appId;

    @JsonProperty("app_name")
    private String appName;

    @JsonProperty("app_short_name")
    private String appShortName;

    @JsonProperty("app_logo_url")
    private String appLogoUrl;

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("username")
    private String username;

    @JsonProperty("subscription_id")
    private String subscriptionId;

    @JsonProperty("membership_type_id")
    private int membershipTypeId;

    @JsonProperty("is_individual_membership")
    private boolean isIndividualMembership;

    @JsonProperty("default_role_id")
    private int defaultRoleId;

    @JsonProperty("default_role_name")
    private String defaultRoleName;

    @JsonProperty("organization_id")
    private long organizationId;

    @JsonProperty("organization_name")
    private String organizationName;

    @JsonProperty("organization_currency")
    private String organizationCurrency;

    @JsonProperty("is_owner")
    private boolean isOwner;

    @JsonProperty("is_active")
    private boolean isActive;

    @JsonProperty("is_default")
    private boolean isDefault;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("created_by")
    private int createdBy;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("updated_by")
    private int updatedBy;

}
// "id": 3035,
//         "app_id": 2,
//         "app_name": "Quaspareparts Gateway App",
//         "app_short_name": "Quaspareparts",
//         "app_logo_url": "https://cdn-a3m-dev.clarusway.com/public/a3m-data/application/2/logo/1703352263730-picture.png",
//         "user_id": 1404,
//         "username": "emily@clarusway.com",
//         "subscription_id": "2e810f91-4b7f-4d78-8d18-c5e9f7491cb8",
//         "membership_type_id": 5,
//         "is_individual_membership": false,
//         "default_role_id": 5,
//         "default_role_name": "Business Owner",
//         "organization_id": 1715253779444611,
//         "organization_name": "XYZ Inc",
//         "organization_currency": "SAR",
//         "is_owner": false,
//         "is_active": true,
//         "is_default": true,
//         "created_at": "2024-05-16T09:47:16.968623Z",
//         "created_by": 1406,
//         "updated_at": "2024-05-16T09:47:16.968624Z",
//         "updated_by": 1406
//         }