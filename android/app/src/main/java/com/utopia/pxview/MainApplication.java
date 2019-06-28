package com.utopia.pxview;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.facebook.react.ReactApplication;
import com.contentsquare.rn.CsSdkPackage;
import com.reactnative.photoview.PhotoViewPackage;
import com.rnziparchive.RNZipArchivePackage;
import com.BV.LinearGradient.LinearGradientPackage;
import org.devio.rn.splashscreen.SplashScreenReactPackage;
import com.opensettings.OpenSettingsPackage;
import com.learnium.RNDeviceInfo.RNDeviceInfo;
import com.psykar.cookiemanager.CookieManagerPackage;
import com.babisoft.ReactNativeLocalization.ReactNativeLocalizationPackage;
import cl.json.RNSharePackage;
import com.oblador.vectoricons.VectorIconsPackage;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import com.smixx.fabric.FabricPackage;
import com.react.rnspinkit.RNSpinkitPackage;
import com.RNFetchBlob.RNFetchBlobPackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.utopia.pxview.UgoiraView.UgoiraViewPackage;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new RNSpinkitPackage(),
           new MainReactPackage(),
            new CsSdkPackage(),
            new PhotoViewPackage(),
            new UgoiraViewPackage(),
            new RNZipArchivePackage(),
            new LinearGradientPackage(),
            new SplashScreenReactPackage(),
            new OpenSettingsPackage(),
            new RNDeviceInfo(),
            new CookieManagerPackage(),
            new ReactNativeLocalizationPackage(),
            new RNSharePackage(),
            new VectorIconsPackage(),
            new FabricPackage(),
            new RNFetchBlobPackage()
      );
    }

    @Override
    protected String getJSMainModuleName() {
      return "index";
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
  }
}
