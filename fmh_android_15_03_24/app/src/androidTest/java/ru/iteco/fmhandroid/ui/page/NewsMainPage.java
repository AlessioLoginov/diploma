package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.activity.DataHelper.childAtPosition;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class NewsMainPage {

    //Страница всех новостей
    public ViewInteraction logo;
    public ViewInteraction title;
    public ViewInteraction sort;
    public ViewInteraction filter;
    public ViewInteraction controlPanelButton;
    public ViewInteraction allNewsBlock;
    public ViewInteraction childNewsButton;

    public NewsMainPage() {
        logo = onView(withId(R.id.trademark_image_view));
        title = onView(withText("Новости"));
        sort = onView(withId(R.id.sort_news_material_button));
        filter = onView(withId(R.id.filter_news_material_button));
        controlPanelButton = onView(withId(R.id.edit_news_material_button));
        allNewsBlock = onView(withId(R.id.all_news_cards_block_constraint_layout));
        childNewsButton = onView(allOf(withId(R.id.news_list_recycler_view),
                childAtPosition(withClassName(is("android.widget.LinearLayout")),
                        withId(R.id.all_news_cards_block_constraint_layout), 0)));
    }
}
