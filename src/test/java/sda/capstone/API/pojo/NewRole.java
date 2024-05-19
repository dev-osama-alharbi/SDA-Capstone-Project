package sda.capstone.API.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewRole{
	private int id;
	private String name;
	private int app_id;
	private String description;
	private List<PermissionsItem> permissions;

}