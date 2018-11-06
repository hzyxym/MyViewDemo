package com.fzs.hzy.myviewdemo.entity;

public class NavExtendParameters {
    private String action;
    private Object actionPars;
    private String actionParams;
    private String calssPath;
    private boolean isLogin;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Object getActionPars() {
        return actionPars;
    }

    public void setActionPars(Object actionPars) {
        this.actionPars = actionPars;
    }

    public String getActionParams() {
        return actionParams;
    }

    public void setActionParams(String actionParams) {
        this.actionParams = actionParams;
    }

    public String getCalssPath() {
        return calssPath;
    }

    public void setCalssPath(String calssPath) {
        this.calssPath = calssPath;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }
}
