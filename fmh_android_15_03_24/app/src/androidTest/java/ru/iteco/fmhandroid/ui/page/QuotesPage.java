package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.activity.DataHelper.childAtPosition;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class QuotesPage {
    public ViewInteraction logo;
    public ViewInteraction title;
    public ViewInteraction ourMissionList;
    public ViewInteraction missionConstraintLayout;

    public QuotesPage() {
        logo = onView(withId(R.id.trademark_image_view));
        title = onView(withId(R.id.our_mission_title_text_view));
        ourMissionList = onView(withId(R.id.our_mission_item_list_recycler_view));
        missionConstraintLayout = onView(allOf(withId(R.id.our_mission_item_list_recycler_view),
                childAtPosition(withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")), 0)));
    }
}
