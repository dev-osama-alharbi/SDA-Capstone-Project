package sda.capstone.API.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Roles {
    private Integer id;
    private String name;
    private Integer app_id;
    private String  subscriptionId;
    private String description;
    private Boolean isDefault;
    private Permissions[] permissions;
}
