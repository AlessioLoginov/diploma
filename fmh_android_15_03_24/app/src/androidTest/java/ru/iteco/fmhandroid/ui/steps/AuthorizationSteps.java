package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static ru.iteco.fmhandroid.ui.activity.DataHelper.elementWaiting;

import android.view.View;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.activity.DataHelper;
import ru.iteco.fmhandroid.ui.page.AuthorizationPage;

public class AuthorizationSteps {

    AuthorizationPage authorizationPage = new AuthorizationPage();

    public void loadAuthorizationPage() {
        Allure.step("Загрузка страницы авторизации");
        elementWaiting(withId(R.id.enter_button), 10000);
    }

    public void checkThatAuthorizationBlockContentIsFull() {
        Allure.step("Наличие всех элементов формы авторизации");
        authorizationPage.title.check(matches(isDisplayed()));
        authorizationPage.loginField.check(matches(isDisplayed()));
        authorizationPage.passwordField.check(matches(isDisplayed()));
        authorizationPage.loginButton.check(matches(isDisplayed()));
    }

    public void validLogIn() {
        Allure.step("Авторизация в приложении под валидными данным");
        DataHelper help = new DataHelper();
        authorizationPage.loginField.perform(typeText(help.getValidUser().getLogin()), closeSoftKeyboard());
        authorizationPage.passwordField.perform(typeText(help.getValidUser().getPassword()), closeSoftKeyboard());
        authorizationPage.loginButton.perform(click());
    }

    public void notValidLogIn() {
        Allure.step("Авторизация в приложении под НЕвалидными данным");
        DataHelper helper = new DataHelper();
        authorizationPage.loginField.perform(typeText(helper.getNotValidUser().getLogin()), closeSoftKeyboard());
        authorizationPage.passwordField.perform(typeText(helper.getNotValidUser().getPassword()), closeSoftKeyboard());
        authorizationPage.loginButton.perform(click());
    }

    public void emptyLogIn() {
        Allure.step("Авторизация в приложении с пустыми данным");
        authorizationPage.loginButton.perform(click());
    }

    public void checkToastMessageText(String text, View decorView) {
        Allure.step("Проверка сообщения по тексту");
        onView(withText(text))
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }

}
