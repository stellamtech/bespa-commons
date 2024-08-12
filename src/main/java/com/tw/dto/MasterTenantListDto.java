package com.tw.dto;

import lombok.Data;

@Data
public class MasterTenantListDto {

	private Long id;
	
	private String dbName;

	private String tenantName;

	private String url;

	private String userName;

	private String password;

	private String driverClass;

	private String status;

	private Integer tenantId;
}
