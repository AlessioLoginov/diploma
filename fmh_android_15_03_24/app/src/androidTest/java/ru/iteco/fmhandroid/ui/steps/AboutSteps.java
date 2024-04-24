package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.activity.DataHelper.elementWaiting;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.page.AboutPage;

public class AboutSteps {

    AboutPage aboutPage = new AboutPage();

    public void checkThatAboutBlockContentIsFull() {
        Allure.step("Проверка, что в блоке \"О приложении\" полный контент");
        elementWaiting(withId(R.id.about_company_info_label_text_view), 5000);
        aboutPage.logo.check(matches(isDisplayed()));
        aboutPage.backButton.check(matches(isDisplayed()));
        aboutPage.versionTitleField.check(matches(isDisplayed()));
        aboutPage.versionNumberField.check(matches(isDisplayed()));
        aboutPage.policyText.check(matches(isDisplayed()));
        aboutPage.termsOfUseText.check(matches(isDisplayed()));
        aboutPage.infoCompany.check(matches(isDisplayed()));
        aboutPage.privacyPolicyValue.check(matches(isDisplayed()));
        aboutPage.termsOfUseValue.check(matches(isDisplayed()));
    }

    public void goBack() {
        Allure.step("Назад на Главную страницу");
        aboutPage.backButton.perform(click());
    }

    public void goToPrivacyPolicy() {
        Allure.step("Переход к политике конфиденциальности");
        aboutPage.privacyPolicyValue.perform(click());

    }

    public void goToTermsOfUse() {
        Allure.step("Переход к пользовательскому соглашению");
        aboutPage.termsOfUseValue.perform(click());
    }
}
