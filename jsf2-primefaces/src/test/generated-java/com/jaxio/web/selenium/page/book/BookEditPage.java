/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-selenium-primefaces:src/test/java/selenium/pages/entity/EditPage.e.vm.java
 */
package com.jaxio.web.selenium.page.book;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.jaxio.web.selenium.support.Page;
import com.jaxio.web.selenium.page.AbstractEditPage;

@Page
public class BookEditPage extends AbstractEditPage {
    // edit box
    @FindBy(id = "form:title")
    public WebElement title;
    @FindBy(id = "form:numberOfPages")
    public WebElement numberOfPages;

    // many-to-one account
    @FindBy(id = "form:account")
    public WebElement account;
    @FindBy(id = "form:viewAccount")
    public WebElement accountViewButton;

}