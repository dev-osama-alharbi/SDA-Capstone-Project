package sda.capstone.API.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Organization {
    private long id ;
    private Integer status_id ;
    private Integer organization_group_id ;
    private String name;
    private Integer founder_id;
    private String short_name;
    private String currency;
    private String address;
    private String phone;
    private String website;
    private String fax;
    private String email;
    private String created_at;
    private String updated_at;
}
