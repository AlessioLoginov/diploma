package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class EditNewsPage {
    public ViewInteraction titlePage;
    public ViewInteraction categoryText;
    public ViewInteraction titleText;
    public ViewInteraction descriptionText;
    public ViewInteraction publicationDate;
    public ViewInteraction time;
    public ViewInteraction switcher;
    public ViewInteraction saveButton;
    public ViewInteraction cancelButton;

    public ViewInteraction errorMessage;

    public ViewInteraction okButtonMessage;
    public ViewInteraction cancelButtonMessage;

    public EditNewsPage() {
        titlePage = onView(withId(R.id.custom_app_bar_title_text_view));
        categoryText =
                onView(withId(R.id.news_item_category_text_auto_complete_text_view));
        titleText = onView(withId(R.id.news_item_title_text_input_edit_text));
        descriptionText =
                onView(withId(R.id.news_item_description_text_input_edit_text));

        publicationDate = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
        time = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
        switcher = onView(withId(R.id.switcher));
        saveButton = onView(withId(R.id.save_button));
        cancelButton = onView(withId(R.id.cancel_button));
        errorMessage = onView(withId(R.id.message));
        okButtonMessage = onView(withText("OK"));
        cancelButtonMessage = onView(withText("Отмена"));
    }
}
