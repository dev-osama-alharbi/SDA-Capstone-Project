package sda.capstone.API.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RolesItem{
	private String subscriptionId;
	private int roleId;
	private String name;
	private boolean isDefault;
}
