package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.activity.DataHelper.elementWaiting;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.page.ControlPanelPage;
import ru.iteco.fmhandroid.ui.page.NewsMainPage;

public class ControlPanelSteps {

    ControlPanelPage controlPanelPage = new ControlPanelPage();
    NewsMainPage newsMainPage = new NewsMainPage();
    CreateNewsSteps createNewsSteps = new CreateNewsSteps();


    public void openControlPanelPage() {
        Allure.step("Переход в панель управления со страницы Новости");
        newsMainPage.controlPanelButton.perform(click());
        elementWaiting(withId(R.id.add_news_image_view), 6000);
    }

    public void checkThatControlPanelContentIsFull() {
        Allure.step("Проверка, что в панели управления полный контент");
        elementWaiting(withId(R.id.add_news_image_view), 6000);
        controlPanelPage.logo.check(matches(isDisplayed()));
        controlPanelPage.sortButton.check(matches(isDisplayed()));
        controlPanelPage.filterButton.check(matches(isDisplayed()));
        controlPanelPage.addNewsButton.check(matches(isDisplayed()));
    }

    public void clickSortNewsButton() {
        Allure.step("Нажать кнопку сортировки");
        controlPanelPage.sortButton.perform(click());
    }

    public void openNewsFilter() {
        Allure.step("Открыть расширенный фильтр");
        controlPanelPage.filterButton.perform(click());
    }

    public void openCreateNewsButton() {
        Allure.step("Нажать кнопку создание новости");
        controlPanelPage.addNewsButton.perform(click());
    }

    public void clickDeleteNews(String newsTitle) {
        Allure.step("Удалить новость с указанным заголовком");
        controlPanelPage.deleteNewsButton(newsTitle).perform(click());
        createNewsSteps.clickOKButton();
    }

    public void clickEditNews(String newsTitle) {
        Allure.step("Нажать кнопку Корректировка новости");
        controlPanelPage.editNewsButton(newsTitle).perform(click());
    }

    public void checkIfNewsWithTitle(String titleText) {
        Allure.step("Проверка наличия новости с указанным заголовком");
        onView(allOf(withText(titleText), isDisplayed())).check(matches(isDisplayed()));
    }

    public void checkIfNoNewsWithTitle(String titleText) {
        Allure.step("Проверка, что новости с указанным заголовком нет");
        onView(allOf(withText(titleText), isDisplayed())).check(doesNotExist());
    }
}
