package sda.capstone.API.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Organization {

    private Long id ;// int Integer
    private Integer status_id ;
    private Integer organization_group_id ;
    private String name;
    private Integer founder_id;
    private String short_name;
    private String country_id;
    private String currency;
    private String address;
    private String phone;
    private String website;
    private String fax;
    private String email;
//    private String website;
//    private String fax;
//    private Integer status_id;
//    private String currency;
    private String created_at;
    private Integer created_by;
    private String updated_at;
    private Integer updated_by;
}
