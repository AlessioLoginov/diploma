package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class FilterNewsPage {
    public ViewInteraction titlePage;
    public ViewInteraction categoryText;
    public ViewInteraction dateStartText;
    public ViewInteraction dateEndText;
    public ViewInteraction filterActive;
    public ViewInteraction filterNotActive;
    public ViewInteraction filterButton;
    public ViewInteraction cancelButton;

    public ViewInteraction okButtonMessage;
    public ViewInteraction cancelButtonMessage;

    public FilterNewsPage() {
        titlePage = onView(withId(R.id.filter_news_title_text_view));
        categoryText =
                onView(withId(R.id.news_item_category_text_auto_complete_text_view));
        dateStartText =
                onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
        dateEndText =
                onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
        filterActive =
                onView(withId(R.id.filter_news_active_material_check_box));
        filterNotActive =
                onView(withId(R.id.filter_news_inactive_material_check_box));
        filterButton = onView(withId(R.id.filter_button));
        cancelButton = onView(withId(R.id.cancel_button));

        okButtonMessage = onView(withText("OK"));
        cancelButtonMessage = onView(withText("Отмена"));
    }
}


