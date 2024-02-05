package ru.cheeseknock.tests;

import java.util.stream.Stream;

public class TestData {

    public String[] oil = {"Острое","Чесночное"};

    static Stream<Object[]> provideTestData() {
        return Stream.of(
                new Object[]{"Пицца Сальсичча", "Острое"},
                new Object[]{"Пицца Сальсичча", "Чесночное"},
                new Object[]{"Пицца с соусом Джек Дениэлс","Острое"},
                new Object[]{"Пицца Маргарита Пармеджано","Чесночное"}
        );
    }
}

