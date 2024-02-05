package ru.cheeseknock.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    public CartPage checkPizzaInCart(String pizza) {
        $("td.product-name").shouldHave(text(pizza + " - Без масла"));
        return this;
    }

    public void checkPizzaWithOilinCart(String pizza, String oil) {
        $("td.product-name").shouldHave(text(pizza + " - " + oil));
    }

    public void checkPizzaQuantity(String quantity) {
        $("input[type='number']").shouldHave(value(quantity));
    }
}
