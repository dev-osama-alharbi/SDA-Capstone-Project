package sda.capstone.API.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllAuth {
    private Integer sub_id;
    private String sub;
    private Integer sub_app;
    private Integer sub_default_role_id;
    private String sub_default_subscription_id;
    private Integer sub_default_membership_type_id;
    private Long sub_default_org_id;
    private Long sub_default_org_group_id;
    private String sub_default_org_name;
    private String sub_default_org_currency;
    private String sub_pic_url;
    private String sub_status;
    private List<String> sub_permissions;
    private List<Role> sub_roles;

    public static class Role {
        private Integer role_id;
        private String name;
        private String subscription_id;
        private Long organization_id;
        private String organization_name;
        private Boolean is_default;
        private Boolean is_active;
    } }

//
//    "sub_id": 1787,
//            "sub": "Norval.Lockman",
//            "sub_app": 2,
//            "sub_default_role_id": 5,
//            "sub_default_subscription_id": "2e810f91-4b7f-4d78-8d18-c5e9f7491cb8",
//            "sub_default_membership_type_id": 5,
//            "sub_default_org_id": 1715253779444611,
//            "sub_default_org_group_id": null,
//            "sub_default_org_name": "XYZ Inc",
//            "sub_default_org_currency": "SAR",
//            "sub_pic_url": null,
//            "sub_status": "active",
//            "sub_permissions": [
//            "ROLE_Business Owner",
//            "organization:read-app",
//            "organization:read-all",
//            "order:write",
//            "file:write",
//            "inventory:read",
//            "user-private-token:write",
//            "reception:confirm",
//            "membership:read-subscr",
//            "wishlist:approved",
//            "invoice:read",
//            "inventory:write",
//            "dashboard:read",
//            "user:write",
//            "specprice:read",
//            "accounting:write",
//            "user-group:read",
//            "specprice:write",
//            "company:admin",
//            "purchasing:confirm",
//            "reception:read",
//            "wishlist:quality_confirm",
//            "user-group:write",
//            "user-status:read",
//            "membership:update",
//            "country:read",
//            "procurement:read",
//            "company:read",
//            "company:fin_confirm",
//            "wishlist:set_coding",
//            "user-group-type:read",
//            "wishlist:offer_ready",
//            "purchasing:read",
//            "organization:read",
//            "wishlist:admin",
//            "order:read",
//            "handmade:write",
//            "wishlist:offer_confirm",
//            "wishlist:cancel",
//            "subscription:read",
//            "file:read",
//            "user:read",
//            "organization-group:read",
//            "invoice:write",
//            "handmade:confirm",
//            "reception:write",
//            "wishlist:set_price",
//            "organization:write",
//            "role:read-all",
//            "role:read",
//            "membership:read",
//            "wishlist:sale_confirm",
//            "organization-group:write",
//            "purchasing:write",
//            "wishlist:view_supp_price",
//            "invoice:confirm",
//            "handmade:read",
//            "procurement:write",
//            "organization-status:read",
//            "application:read-slim",
//            "company:qual_confirm",
//            "purchasing:read_cost",
//            "membership:write",
//            "accounting:read",
//            "order:confirm",
//            "subscription:write",
//            "user-private-token:read",
//            "wishlist:read"
//            ],
//            "sub_roles": [
//    {
//        "role_id": 5,
//            "name": "Business Owner",
//            "subscription_id": "2e810f91-4b7f-4d78-8d18-c5e9f7491cb8",
//            "organization_id": 1715253779444611,
//            "organization_name": "XYZ Inc",
//            "is_default": true,
//            "is_active": true
