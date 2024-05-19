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
public class UserData{
	private String address;
	private boolean isActive;
	private boolean isEmailVerified;
	private List<RolesItem> roles;
	private String createdAt;
	private String membershipCreatedAt;
	private int createdBy;
	private String lastname;
	private String subscriptionId;
	private int statusId;
	private String updatedAt;
	private String phone;
	private long organizationId;
	private String name;
	private List<OrganizationsItem> organizations;
	private int updatedBy;
	private String membershipUpdatedAt;
	private int id;
	private String email;
	private String username;
	private UserStatus status;
	private List<Object> userGroups;
	private List<ApplicationsItem> applications;
}