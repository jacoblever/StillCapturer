package uk.co.jacoblever.stillcapturer;

import android.content.Context;
import android.net.Uri;

public interface PathResolver {

    String getActualPath(final Context context, final Uri uri);

}
