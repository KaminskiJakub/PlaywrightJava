package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private final Page page;

    private final String search = "input[name='search']";
    private final String searchIcon = "div#search button";
    private final String searchPageHeader = "div#content h1";
    private final String loginLink = "a:text('Login')";
    private final String myAccountLink = "a[title='My Account']";

    public HomePage(Page page) {
        this.page = page;
    }

    public String getHomePageTitle() {
        String title = page.title();
        System.out.println("Page title: " + title);
        return title;
    }

    public String getHomePageURL() {
        return page.url();
    }

    public String doSearch(String productName) {
        page.fill(search, productName);
        page.click(searchIcon);
        String header =  page.textContent(searchPageHeader);
        System.out.println(header);
        return header;
    }

    public LoginPage navigateToLoginPage() {
        page.click(myAccountLink);
        page.click(loginLink);
        return new LoginPage(page);
    }
}
