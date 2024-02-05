package ru.cheeseknock.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import ru.cheeseknock.utils.Utils;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class PizzaPage {

    Utils utils = new Utils();

    private final SelenideElement
            cartIcon = $(".menu-korzina-container"),
            workingHoursBanner = $("#timeModal"),
            closeModalButton =  $(".btn-close[data-bs-dismiss='modal'][aria-label='Close']");

    public PizzaPage openPage() {
        open("product-category/pizza/");
        return this;
    }

    public PizzaPage addToCartPizza(String pizza) {
        SelenideElement pizzaElement = $$("li").findBy(text(pizza));
        SelenideElement addToCartButton = pizzaElement.find(".single_add_to_cart_button");
        executeJavaScript("arguments[0].click();", addToCartButton);
        return this;
    }

    public PizzaPage addToCartPizzaWithOil(String pizza, String oil) {
        SelenideElement pizzaElement = $$("li").findBy(text(pizza));
        pizzaElement.find("#select2-pa_maslo-container").click();
        Utils.wait(2);
        pizzaElement.$(new ByText(oil)).click();
        SelenideElement addToCartButton = pizzaElement.find(".single_add_to_cart_button");
        executeJavaScript("arguments[0].click();", addToCartButton);
        return this;
    }



    public void clickOnCartIcon() {
        Utils.wait(2);
         cartIcon.click();
    }

    public PizzaPage removeWorkingHoursNotifier() {
        Utils.wait(2);
        if (workingHoursBanner.isDisplayed()) {
            closeModalButton.click();
        }
        workingHoursBanner.shouldNotBe(visible);
        return this;
    }

    public PizzaPage setPizzaQuantity(String pizza, String quantity) {
        SelenideElement pizzaElement = $$("li").findBy(text(pizza));
        int q = Integer.parseInt(quantity);
        for (int i = 1; i < q; i++) {
            pizzaElement.$(".quantity-arrows.plus").click();
        }
        return this;
    }
}


