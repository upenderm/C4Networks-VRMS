package com.c4networks.vrms.ui.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class UserSettingsAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserSettingsAction.class.getName());

	public String execute() {
		logger.info("UserSettings Action call invoked");

		return SUCCESS;
	}

}
