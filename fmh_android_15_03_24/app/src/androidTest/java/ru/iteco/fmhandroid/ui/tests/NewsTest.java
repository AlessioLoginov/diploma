package ru.iteco.fmhandroid.ui.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.ControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.DownloadSteps;
import ru.iteco.fmhandroid.ui.steps.FilterNewsSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@RunWith(AllureAndroidJUnit4.class)
public class NewsTest {
    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE,
            String.valueOf(System.currentTimeMillis()));
    DownloadSteps downloadSteps = new DownloadSteps();
    MainSteps mainSteps = new MainSteps();
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    NewsSteps newsSteps = new NewsSteps();
    ControlPanelSteps controlPanelSteps = new ControlPanelSteps();
    FilterNewsSteps filterNewsSteps = new FilterNewsSteps();

    @Before
    public void setUp() {
        downloadSteps.appDownload();
        try {
            mainSteps.mainScreenLoad();
        } catch (Exception e) {
            authorizationSteps.validLogIn();
            mainSteps.mainScreenLoad();
        }
    }
    /*Тест проверяет возможность перехода ко всем новостям с главной страницы.*/
    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Переход ко всем новостям с главной страницы")
    public void shouldAccessAllNewsFromHomePage() {
        mainSteps.openAllNews();
    }

    /*Тест проверяет функциональность разворачивания (раскрытия) отдельной новости на главной странице */
    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Развернуть новость на главной странице")
    public void shouldExpandSingleNewsOnHomePag() {
        newsSteps.clickOneNewsItem(0);
    }

    /*Тест проверяет, что все элементы на странице новостей присутствуют и корректно отображаются. */
    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Наличие всех элементов на странице Новости")
    public void shouldDisplayCompleteContentOnNewsPage() {
        mainSteps.openNewsPage();
        newsSteps.checkThatNewsBlockContentIsFull();
    }

    /*Тест проверяет возможность перехода на страницу панели управления и наличие всех элементов на этой странице. */
    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Переход на страницу Панели управления и Наличие всех элементов")
    public void shouldAccessControlPanelWithAllElements() {
        mainSteps.openNewsPage();
        controlPanelSteps.openControlPanelPage();
        controlPanelSteps.checkThatControlPanelContentIsFull();
    }

    /*Тест проверяет возврат на главную страницу со страницы новостей */
    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Возврат на Главную страницу со страницы Новости")
    public void shouldReturnToHomePageFromNewsPageWithFullContentCheck() {
        mainSteps.openNewsPage();
        newsSteps.checkThatNewsBlockContentIsFull();
        newsSteps.checkGoBackMainPage();
        mainSteps.checkThatMainBlockContentIsFull();
    }

    /*Тест проверяет функциональность отмены фильтрации новостей.  */
    @Test
    @Feature(value = "Тесты по разделу Новостей")
    @Story("Выход из фильтра без фильтрации новостей")
    public void shouldCancelNewsFilterWithoutApplyingChanges() {
        mainSteps.openNewsPage();
        controlPanelSteps.openControlPanelPage();
        controlPanelSteps.openNewsFilter();
        filterNewsSteps.clickCancelButton();
        controlPanelSteps.checkThatControlPanelContentIsFull();
    }
}
