package com.c4networks.vrms.services.dao;

import java.util.List;

import com.c4networks.vrms.vo.RoleDetail;

/**
 * 
 * @author M Upender
 *
 */

public interface RoleDetailsDAO {

	public void saveRoleDetail(RoleDetail RoleDetail);

	public void deleteRoleDetail(RoleDetail RoleDetail);

	public RoleDetail findByRoleDetailId(String RoleDetailId);

	public List<RoleDetail> findByProperty(String propertyName, Object value);

	public List<RoleDetail> findByProperty(String propertyName, Object value, String propertyName2, Object value2);

	public List<RoleDetail> findAll();

}
