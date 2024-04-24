package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class DownloadPage {

    public ViewInteraction splashImage;
    public ViewInteraction splashText;
    public ViewInteraction splashProgressIndicator;

    public DownloadPage() {
        splashImage = onView(withId(R.id.splashscreen_image_view));
        splashText = onView(withId(R.id.splashscreen_text_view));
        splashProgressIndicator =
                onView(withId(R.id.splash_screen_circular_progress_indicator));
    }
}
