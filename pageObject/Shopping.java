package com.ecom.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Shopping {

	WebDriver lDriver;

	public Shopping(WebDriver rDriver) {
		lDriver = rDriver;
		PageFactory.initElements(rDriver,this);
	}

	@FindBy(css="a.sf-with-ul")
	@CacheLookup
	WebElement womenBtn;

	@FindBy(css=" a[title='T-shirts']")
	@CacheLookup
	WebElement TeeBtn;

	@FindBy(xpath ="//a[@class='sf-with-ul' and text()='Dresses']")
	@CacheLookup
	WebElement dressBtn;

	@FindBy(xpath ="//a[@title='Proceed to checkout']")
	@CacheLookup
	WebElement checkOutBtn;

	@FindBys(  @FindBy(xpath ="//a[@class='product_img_link']"))
	@CacheLookup
	List <WebElement> productList;

	@FindBys(  @FindBy(xpath ="//div[@class='product-image-container']"))
	@CacheLookup
	List <WebElement> imgContainer;

	@FindBys(  @FindBy(xpath ="//span[contains(text(),'Add to cart')]"))
	@CacheLookup
	List <WebElement> imgAddToCart;

	public void clickAddToCart(int index) {
		imgAddToCart.get(index).click();
	}

	public int getListSize() {
		return productList.size();
	}

	public String getListAttrValue(int index, String attr) {
		return productList.get(index).getAttribute(attr);
	}

	public void moveToImgContainer(int index) {
		Actions act = new Actions(lDriver);
		act.moveToElement(imgContainer.get(index)).build().perform();
	}

	public void clickWomenBtn() {
		womenBtn.click();
	}

	public WebElement getWomenBt() {
		return womenBtn;
	}

	public void moveToWomenTab() {
		Actions act = new Actions(lDriver);
		act.moveToElement(womenBtn).build().perform();
	} 

	public void clickDressTab() {
		Actions act = new Actions(lDriver);
		act.moveToElement(dressBtn).click().build().perform();
	} 

	public WebElement getTBtn() {
		return TeeBtn;
	}

	public WebElement getDress() {
		return dressBtn;
	}

	public void clickCheckOut() {
		checkOutBtn.click();
	}
}

