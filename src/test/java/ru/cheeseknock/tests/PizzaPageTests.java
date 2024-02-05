package ru.cheeseknock.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.cheeseknock.pages.CartPage;
import ru.cheeseknock.pages.PizzaPage;

public class PizzaPageTests extends TestBase {

    PizzaPage pizzaPage = new PizzaPage();
    CartPage cartPage = new CartPage();


    @Tag("SMOKE")
    @ValueSource(strings = {
            "Пицца с соусом Джек Дениэлс",
            "Пицца Маргарита Пармеджано",
            "Пицца Сальсичча",
            "Пицца с соусом барбекю-кола"})
    @ParameterizedTest(name = "Добавление в корзину пиццы {0}")
    @DisplayName("Добавление в корзину пиццы {0}")
    void addToCartPizzaTest(String pizza) {
        pizzaPage
                .openPage()
                .removeWorkingHoursNotifier()
                .addToCartPizza(pizza)
                .clickOnCartIcon();

        cartPage.checkPizzaInCart(pizza);
        Selenide.clearBrowserCookies();
    }

    @Tag("CRIT")
    @ParameterizedTest(name = "Добавление в корзину пиццы {0} с маслом {1} ")
    @MethodSource("ru.cheeseknock.tests.TestData#provideTestData")
    void AddToCartPizzaWithOil(String pizza, String oil) {
        pizzaPage
                .openPage()
                .removeWorkingHoursNotifier()
                .addToCartPizzaWithOil(pizza, oil)
                .clickOnCartIcon();
        cartPage.checkPizzaWithOilinCart(pizza, oil);
        Selenide.clearBrowserCookies();
    }

    @Tag("SMOKE")
    @CsvSource({"Пицца с соусом Джек Дениэлс, 5",
            "Пицца Маргарита Пармеджано, 2",
            "Пицца Сальсичча, 1",
            "Пицца с соусом барбекю-кола, 3"})
    @ParameterizedTest(name = "Добавление в корзину пиццы {0} в количестве {1}")
    void addToCartManyPizzasTest(String pizza, String quantity) {
        pizzaPage
                .openPage()
                .removeWorkingHoursNotifier()
                .setPizzaQuantity(pizza, quantity)
                .addToCartPizza(pizza)
                .clickOnCartIcon();

        cartPage.checkPizzaInCart(pizza)
                .checkPizzaQuantity(quantity);
        Selenide.clearBrowserCookies();
    }
}


