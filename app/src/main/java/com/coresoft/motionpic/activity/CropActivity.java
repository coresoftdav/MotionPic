package com.coresoft.motionpic.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;



import static android.content.Intent.FLAG_RECEIVER_FOREGROUND;

import com.coresoft.motionpic.R;
import com.coresoft.motionpic.fragment.MainFragment;
import com.coresoft.motionlibs.utils.Share;

public class CropActivity extends HomeParentActivity {

    private static final String TAG = "CropImageAct";
    public static CropActivity activity;

    private Uri mUri;


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_crop);
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("CropImageAct==>  ");
        sb.append(Share.imageUrl);
        Log.e(str, sb.toString());
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, (Fragment) MainFragment.getInstance()).commitAllowingStateLoss();
        }

        RelativeLayout mAdView = findViewById(R.id.adView);
        loadBannerAdsApp(mAdView);
    }



    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }


    public void onDestroy() {
        super.onDestroy();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onBackPressed() {
        finish();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", getPackageName(), null));
        intent.addFlags(FLAG_RECEIVER_FOREGROUND);
        startActivity(intent);

    }

    public void startResultActivity(Uri uri) {
        this.mUri = uri;

        Intent intent = new Intent(this, MotionEditActivity.class);
        intent.setData(uri);
        startActivity(intent);
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
        finish();
        return;
    }

    public void onClosed() {
        Intent intent = new Intent(this, MotionEditActivity.class);
        intent.setData(this.mUri);
        startActivity(intent);
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
        finish();
    }
}
