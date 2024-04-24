package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.page.FilterNewsPage;

public class FilterNewsSteps {

    FilterNewsPage filterNewsPage = new FilterNewsPage();

    public void checkThatFilterNewsBlockContentIsFull() {
        Allure.step("Проверка, что в блоке Фильтрации новостей полный контент");
        filterNewsPage.titlePage.check(matches(isDisplayed()));
        filterNewsPage.categoryText.check(matches(isDisplayed()));
        filterNewsPage.dateStartText.check(matches(isDisplayed()));
        filterNewsPage.dateEndText.check(matches(isDisplayed()));
        filterNewsPage.filterActive.check(matches(isDisplayed()));
        filterNewsPage.filterNotActive.check(matches(isDisplayed()));
        filterNewsPage.filterButton.check(matches(isDisplayed()));
        filterNewsPage.cancelButton.check(matches(isDisplayed()));
    }

    public void clickFilterButton() {
        Allure.step("Нажатие кнопки Фильтровать");
        filterNewsPage.filterButton.perform(click());
    }

    public void clickCancelButton() {
        Allure.step("Нажатие кнопки Отмена");
        filterNewsPage.cancelButton.perform(click());
    }

    public void clickOKButton() {
        Allure.step("Нажатие кнопки ОК в сообщении");
        filterNewsPage.okButtonMessage.perform(click());
    }

    public void fillInStartDateField(String startDate) {
        Allure.step("Поле начальная дата - ввод данных");
        filterNewsPage.dateStartText.perform(replaceText(startDate));
    }

    public void fillInEndDateField(String endDate) {
        Allure.step("Поле конечная дата - ввод данных");
        filterNewsPage.dateEndText.perform(replaceText(endDate));
    }

    public void clickActiveCheckBox() {
        Allure.step("Нажать чекбокс - Активна");
        filterNewsPage.filterActive.perform(click());
    }

    public void clickNotActiveCheckBox() {
        Allure.step("Нажать чекбокс - НЕ активна");
        filterNewsPage.filterNotActive.perform(click());
    }

    public void checkBoxStatusActive(boolean checked) {
        Allure.step("Проверка нажатия - Активна");

        if (checked) {
            filterNewsPage.filterActive.check(matches(isChecked()));
        } else {
            filterNewsPage.filterActive.check(matches(isNotChecked()));
        }
    }

    public void checkBoxStatusNotActive(boolean checked) {
        Allure.step("Проверка нажатия - НЕ активна");

        if (checked) {
            filterNewsPage.filterNotActive.check(matches(isChecked()));
        } else {
            filterNewsPage.filterNotActive.check(matches(isNotChecked()));
        }
    }

}
