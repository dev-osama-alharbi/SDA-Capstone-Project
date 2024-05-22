package sda.capstone.API.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserData {
    String strJson = """
                {
                    "app_id": 2,
                    "organization_id": 1716287440101561,
                    "email": "",
                    "subscription_id": "12e01972-a928-43f9-a20c-d8df7ff926e7",
                    "default_role_id": 5
                }""";
    private Integer id;
    private String name;
    private String lastname;
    private String username;
    private String email;
    private Boolean is_email_verified;
    private String phone;
    private String address;
    private String country_id;
    private Integer pic_id;
    private Preferences preferences;
    private Integer status_id;
    private String created_at;
    private Integer created_by;
    private String updated_at;
    private Integer updated_by;


    private String subscriptionId;
    private String membershipCreatedAt;
    private String membershipUpdatedAt;
    private Long organizationId;
    private Integer defaultRoleId;
    private Integer appId;
    private Boolean isActive;

    private List<UserGroups> userGroups;
    private List<Organization> Organization;
    private List<Roles> Roles;
    private List<UserStatus> UserStatus;
    private List<Applications> Applications;
}
