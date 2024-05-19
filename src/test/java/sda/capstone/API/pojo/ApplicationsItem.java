package sda.capstone.API.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationsItem{
	private String subscriptionPath;
	private boolean isMfaEnabled;
	private int logoId;
	private boolean isPasswordRecoveryEnabled;
	private String loginPath;
	private String description;
	private String createdAt;
	private boolean isEnabled;
	private String domainName;
	private String environment;
	private boolean isExternalIdpLoginEnabled;
	private String updatedAt;
	private int defaultMembershipTypeId;
	private String baseUri;
	private String name;
	private int updatedBy;
	private String shortName;
	private boolean isSelfRegistrationEnabled;
	private int id;
	private boolean isSubscriptionRequired;
}
