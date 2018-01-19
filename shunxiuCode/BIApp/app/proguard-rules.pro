# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/gechuanguang/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}






#-------------------------------------------定制化区域----------------------------------------------
#---------------------------------1.实体类---------------------------------
-keep class me.sunlight.factory.model.** { *; }
-keep class com.pmrd.olive.model.** { *; }

#-------------------------------------------------------------------------

#---------------------------------2.第三方包-------------------------------
#okhttp
-dontwarn okhttp3.**
-keep class okhttp3.**{*;}

#okio
-dontwarn okio.**
-keep class okio.**{*;}

#loading
-keep class com.wang.avi.** { *; }
-keep class com.wang.avi.indicators.** { *; }

#uCrop
-dontwarn com.yalantis.ucrop**
-keep class com.yalantis.ucrop** { *; }
-keep interface com.yalantis.ucrop** { *; }

#极光推送
-dontoptimize
-dontpreverify

-dontwarn cn.jpush.**
-keep class cn.jpush.** { *; }
-keep class * extends cn.jpush.android.helpers.JPushMessageReceiver { *; }

-dontwarn cn.jiguang.**
-keep class cn.jiguang.** { *; }

#支付宝
-keep class com.alipay.android.app.IAlixPay{*;}
-keep class com.alipay.android.app.IAlixPay$Stub{*;}
-keep class com.alipay.android.app.IRemoteServiceCallback{*;}
-keep class com.alipay.android.app.IRemoteServiceCallback$Stub{*;}
-keep class com.alipay.sdk.app.PayTask{ public *;}
-keep class com.alipay.sdk.app.AuthTask{ public *;}
-dontwarn android.net.**
-keep class android.net.SSLCertificateSocketFactory{*;}
#微信
-keep class com.tencent.wxop.** { *; }
#微信分享
-keep class com.tencent.mm.sdk.** {
   *;
}
#新浪微博分享
-dontwarn com.weibo.sdk.Android.WeiboDialog
-dontwarn android.NET.http.SslError
-dontwarn android.webkit.WebViewClient
-keep public class android.Net.http.SslError{
   *;
}
-keep public class android.webkit.WebViewClient{
   *;
}
-keep public class android.webkit.WebChromeClient{
   *;
}
-keep public interface android.webkit.WebChromeClient$CustomViewCallback {
   *;
}
-keep public interface android.webkit.ValueCallback {
   *;
}
-keep class * implements android.webkit.WebChromeClient {
   *;
}

-keep class com.sina.weibo.sdk.api.** {
   *;
}

-keep class com.sina.weibo.sdk.** {
   *;
}

#百度地图
#-keep class com.baidu.** { *; }
#-keep class vi.com.gdi.bgl.android.**{*;}

#-------------------------------------------------------------------------

#---------------------------------3.与js互相调用的类------------------------



#-------------------------------------------------------------------------

#---------------------------------4.反射相关的类和方法-----------------------



#----------------------------------------------------------------------------
#---------------------------------------------------------------------------------------------------

#-------------------------------------------基本不用动区域--------------------------------------------
#---------------------------------基本指令区----------------------------------
-optimizationpasses 5
-dontskipnonpubliclibraryclassmembers
-printmapping proguardMapping.txt
-optimizations !code/simplification/cast,!field/*,!class/merging/*
-keepattributes *Annotation*,InnerClasses
-keepattributes Signature
-keepattributes SourceFile,LineNumberTable
#----------------------------------------------------------------------------

#---------------------------------默认保留区---------------------------------
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View
-keep public class com.android.vending.licensing.ILicensingService
-keep class android.support.** {*;}

-keep public class * extends android.view.View{
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
-keep class **.R$* {
 *;
}
-keepclassmembers class * {
    void *(**On*Event);
}
#----------------------------------------------------------------------------

#---------------------------------webview------------------------------------
-keepclassmembers class fqcn.of.javascript.interface.for.Webview {
   public *;
}
-keepclassmembers class * extends android.webkit.WebViewClient {
    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
    public boolean *(android.webkit.WebView, java.lang.String);
}
-keepclassmembers class * extends android.webkit.WebViewClient {
    public void *(android.webkit.WebView, jav.lang.String);
}
#----------------------------------------------------------------------------
#---------------------------------------------------------------------------------------------------

