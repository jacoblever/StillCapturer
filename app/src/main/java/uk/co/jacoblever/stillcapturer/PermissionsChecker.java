package uk.co.jacoblever.stillcapturer;

import android.app.Activity;

interface PermissionsChecker {
    boolean isReadStoragePermissionGranted(Activity context);

    boolean isWriteStoragePermissionGranted(Activity context);
}
