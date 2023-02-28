package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private final Page page;

    private final String emailId = "//input[@id='input-email']";
    private final String password = "//input[@id='input-password']";
    private final String loginBtn = "//input[@value='Login']";
    private final String forgotPwdLink = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
    private final String logoutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";

    public LoginPage(Page page) {
        this.page = page;
    }

    public String getLoginPageTitle() {
        return page.title();
    }

    public boolean isForgotPwdLinkExist() {
        return page.isVisible(forgotPwdLink);
    }

    public boolean doLogin(String appUserName, String appPassword) {
        System.out.println("app credentials: " + appUserName + " : " + appPassword);
        page.fill(emailId, appUserName);
        page.fill(password, appPassword);
        page.click(loginBtn);
        if(page.isVisible(logoutLink)) {
            System.out.println("user is logged in");
            return true;
        }
        return false;
    }
}
