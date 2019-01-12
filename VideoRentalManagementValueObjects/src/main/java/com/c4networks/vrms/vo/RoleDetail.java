package com.c4networks.vrms.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Upender M
 * 
 */

@XmlType(name = "RoleDetail", namespace = "http://vo.vrms.c4networks.com/")
@XmlRootElement(name = "RoleDetail")
public class RoleDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	private String roleId;
	private String roleName;
	private String roleDesc;
	private String accessPage;

	public RoleDetail() {
	}

	/**
	 * @return the roleId
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId
	 *            the roleId to set
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName
	 *            the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the roleDesc
	 */
	public String getRoleDesc() {
		return roleDesc;
	}

	/**
	 * @param roleDesc
	 *            the roleDesc to set
	 */
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	/**
	 * @return the accessPage
	 */
	public String getAccessPage() {
		return accessPage;
	}

	/**
	 * @param accessPage
	 *            the accessPage to set
	 */
	public void setAccessPage(String accessPage) {
		this.accessPage = accessPage;
	}

}