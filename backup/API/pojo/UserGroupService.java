package sda.capstone.API.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserGroupService {
       private Integer id;
       private String name;
       private String short_name;
       private String description;
       private Integer group_type_id;
       private Integer pic_id;
       private Long organization_id;
       private Organization organization;
       private Users[] users;
       private Roles[] roles;
}
