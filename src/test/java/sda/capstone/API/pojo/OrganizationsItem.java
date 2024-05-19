package sda.capstone.API.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrganizationsItem{
	private int founderId;
	private String updatedAt;
	private String name;
	private String createdAt;
	private String currency;
	private long id;
	private String countryId;
	private String email;
}
