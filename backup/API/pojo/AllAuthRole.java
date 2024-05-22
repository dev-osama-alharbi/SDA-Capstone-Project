package sda.capstone.API.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllAuthRole {
    private Integer role_id;
    private String name;
    private String subscription_id;
    private Long organization_id;
    private String organization_name;
    private Boolean is_default;
    @JsonProperty("default")
    private Boolean defaultd;
}
