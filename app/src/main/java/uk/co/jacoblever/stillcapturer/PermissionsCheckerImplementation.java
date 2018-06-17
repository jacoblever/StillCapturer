package uk.co.jacoblever.stillcapturer;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

public class PermissionsCheckerImplementation implements PermissionsChecker {

    @Override
    public boolean isReadStoragePermissionGranted(final Activity context) {
        return isPermissionGranted(context, Manifest.permission.READ_EXTERNAL_STORAGE);
    }

    @Override
    public boolean isWriteStoragePermissionGranted(final Activity context) {
        return isPermissionGranted(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    private boolean isPermissionGranted(Activity context, String readExternalStorage) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (context.checkSelfPermission(readExternalStorage)
                    == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                ActivityCompat.requestPermissions(context, new String[]{readExternalStorage}, 3);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            return true;
        }
    }

}
