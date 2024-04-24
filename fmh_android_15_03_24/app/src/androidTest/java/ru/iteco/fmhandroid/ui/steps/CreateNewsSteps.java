package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

import android.view.View;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.page.CreateNewsPage;

public class CreateNewsSteps {

    CreateNewsPage createNewsPage = new CreateNewsPage();

    public void checkThatCreateNewsPageContentIsFull() {
        Allure.step("Проверка, что в окне Создания новости полный контент");
        createNewsPage.titlePage.check(matches(isDisplayed()));
        createNewsPage.categoryText.check(matches(isDisplayed()));
        createNewsPage.titleText.check(matches(isDisplayed()));
        createNewsPage.descriptionText.check(matches(isDisplayed()));
        createNewsPage.publicationDate.check(matches(isDisplayed()));
        createNewsPage.time.check(matches(isDisplayed()));
        createNewsPage.switcher.check(matches(isDisplayed()));
        createNewsPage.saveButton.check(matches(isDisplayed()));
        createNewsPage.cancelButton.check(matches(isDisplayed()));
    }

    public void fillInNewsCategoryField(String text) {
        Allure.step("Ввод данных в поле Категория");
        createNewsPage.categoryText.perform(replaceText(text));
    }

    public void fillInNewsTitleField(String text) {
        Allure.step("Ввод данных в поле Заголовок");
        createNewsPage.titleText.perform(replaceText(text));
    }

    public void fillInPublicDateField(String text) {
        Allure.step("Ввод данных в поле Дата публикации");
        createNewsPage.publicationDate.perform(replaceText(text));
    }

    public void fillInTimeField(String text) {
        Allure.step("Ввод данных в поле Время");
        createNewsPage.time.perform(replaceText(text));
    }

    public void fillInNewsDescriptionField(String text) {
        Allure.step("Ввод данных в поле Описание");
        createNewsPage.descriptionText.perform(replaceText(text));
    }

    public void createNews(String category, String title, String publicationDate,
                           String publicationTime, String description) {
        Allure.step("Ввод данных для создания новости");
        fillInNewsCategoryField(category);
        fillInNewsTitleField(title);
        fillInPublicDateField(publicationDate);
        fillInTimeField(publicationTime);
        fillInNewsDescriptionField(description);
    }

    public void clickSaveButton() {
        Allure.step("Нажатие кнопки Сохранить");
        createNewsPage.saveButton.perform(click());
    }

    public void clickCancelButton() {
        Allure.step("Нажатие кнопки Отмена");
        createNewsPage.cancelButton.perform(click());
    }

    public void clickOKButton() {
        Allure.step("Нажатие кнопки ОК в сообщении");
        createNewsPage.okButtonMessage.perform(click());
    }

    public void checkToastMessageText(String text, View decorView) {
        Allure.step("Проверка сообщения");
        onView(withText(text))
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }

}
