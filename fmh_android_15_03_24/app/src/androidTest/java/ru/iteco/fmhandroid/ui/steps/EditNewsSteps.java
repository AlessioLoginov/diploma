package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.page.EditNewsPage;

public class EditNewsSteps {

    EditNewsPage editNewsPage = new EditNewsPage();

    public void checkThatEditNewsPageContentIsFull() {
        Allure.step("Проверка, что в окне Редактирования новости полный контент");
        editNewsPage.titlePage.check(matches(isDisplayed()));
        editNewsPage.categoryText.check(matches(isDisplayed()));
        editNewsPage.titleText.check(matches(isDisplayed()));
        editNewsPage.descriptionText.check(matches(isDisplayed()));
        editNewsPage.publicationDate.check(matches(isDisplayed()));
        editNewsPage.time.check(matches(isDisplayed()));
        editNewsPage.switcher.check(matches(isDisplayed()));
        editNewsPage.saveButton.check(matches(isDisplayed()));
        editNewsPage.cancelButton.check(matches(isDisplayed()));
    }

    public void fillInNewsCategoryField(String text) {
        Allure.step("Ввод данных в поле Категория");
        editNewsPage.categoryText.perform(replaceText(text));
    }

    public void fillInNewsTitleField(String text) {
        Allure.step("Ввод данных в поле Заголовок");
        editNewsPage.titleText.perform(replaceText(text));
    }

    public void fillInPublicDateField(String text) {
        Allure.step("Ввод данных в поле Дата публикации");
        editNewsPage.publicationDate.perform(replaceText(text));
    }

    public void fillInTimeField(String text) {
        Allure.step("Ввод данных в поле Время");
        editNewsPage.time.perform(replaceText(text));
    }

    public void fillInNewsDescriptionField(String text) {
        Allure.step("Ввод данных в поле Описание");
        editNewsPage.descriptionText.perform(replaceText(text));
    }

    public void EditNewsFields(String category, String title, String publicationDate,
                               String publicationTime, String description) {
        Allure.step("Перезаполнение/редактирование данных новости");
        fillInNewsCategoryField(category);
        fillInNewsTitleField(title);
        fillInNewsDescriptionField(description);
        fillInPublicDateField(publicationDate);
        fillInTimeField(publicationTime);
    }

    public void changeStatus() {
        Allure.step("Поменять статус новости");
        editNewsPage.switcher.perform(click());
    }

    public void clickSaveButton() {
        Allure.step("Нажатие кнопки Сохранить");
        editNewsPage.saveButton.perform(click());
    }

    public void clickCancelButton() {
        Allure.step("Нажатие кнопки Отмена");
        editNewsPage.cancelButton.perform(click());
    }

    public void clickOKButton() {
        Allure.step("Нажатие кнопки ОК в сообщении");
        editNewsPage.okButtonMessage.perform(click());
    }
}

