package sda.capstone.API.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserGroups {
    private Integer id;
    private String name;
    private String short_name;
    private String subscriptionId;
    private Integer group_type_id;
    private Integer pic_id;
    private Integer organization_id;
    private Boolean is_head;
    private Boolean isDefault;
}