package sda.capstone.API.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {
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
    private User_groups[] user_groups;
    private String created_at;
    private Integer created_by;
    private String updated_at;
    private Integer updated_by;
}
