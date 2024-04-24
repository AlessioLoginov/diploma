package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainPage {
    public ViewInteraction mainLogo;

    public ViewInteraction profileButton;
    public ViewInteraction logOutButton;

    public ViewInteraction menuButton;
    public ViewInteraction mainOfMenu;
    public ViewInteraction newsOfMenu;
    public ViewInteraction aboutOfMenu;

    public ViewInteraction ourMissionButton;

    public ViewInteraction titleOfNewsContainer;
    public ViewInteraction allNewsButton;
    public ViewInteraction collapseAllNewsButton;

    public MainPage() {
        mainLogo = onView(withId(R.id.trademark_image_view));
        profileButton = onView(withId(R.id.authorization_image_button));
        logOutButton = onView(withText("Выйти"));
        menuButton = onView(withId(R.id.main_menu_image_button));
        mainOfMenu = onView(withText("Главная"));
        newsOfMenu = onView(withText("Новости"));
        aboutOfMenu = onView(withText("О приложении"));
        ourMissionButton = onView(withId(R.id.our_mission_image_button));
        titleOfNewsContainer = onView(withText("Новости"));
        allNewsButton = onView(withId(R.id.all_news_text_view));
        collapseAllNewsButton = onView(withId(R.id.expand_material_button));
    }
}
