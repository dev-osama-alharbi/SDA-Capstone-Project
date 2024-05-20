package sda.capstone.API.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllAuth {
    private Integer sub_id;
    private String sub;
    private Integer sub_app;
    private Integer sub_default_role_id;
    private String sub_default_subscription_id;
    private Integer sub_default_membership_type_id;
    private Long sub_default_org_id;
    private Long sub_default_org_group_id;
    private String sub_default_org_name;
    private String iss;
    private String exp;
    private String iat;
    private String nonce;
    private String azp;
    private String sub_default_org_currency;
    private String sub_pic_url;
    private String sub_status;
    private List<String> sub_permissions;
    private List<String> aud;
    private List<AllAuthRole> sub_roles;

}

