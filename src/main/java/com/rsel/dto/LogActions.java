package com.rsel.dto;

/**
 * The action field of the log table
 * Created  on 2017/3/4.
 */
public enum LogActions {

    LOGIN("Login background"), UP_PWD("change Password"), UP_INFO("Modify Personal Information"),
    DEL_ARTICLE("Delete article"), DEL_PAGE("Delete page"), SYS_BACKUP("System backup"),
    SYS_SETTING("Save system settings"), INIT_SITE("Initialize the site");

    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    LogActions(String action) {
        this.action = action;
    }
}
