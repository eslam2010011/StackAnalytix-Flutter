package com.example.untitled1

import androidx.annotation.NonNull
import android.app.Activity
import java.lang.ref.WeakReference
import com.analytix.Analytics.StackAnalytix
import android.util.Log
import android.view.ViewGroup

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
 class Untitled1Plugin: FlutterPlugin, MethodCallHandler,ActivityAware {

  private lateinit var channel : MethodChannel
  private lateinit var activity : Activity

  override fun onAttachedToActivity(binding: ActivityPluginBinding) {
    activity =binding.activity

  }

  override fun onDetachedFromActivityForConfigChanges() {

  }


  override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {
    activity = binding.activity

  }

  override fun onDetachedFromActivity() {
   }
  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "StackAnalytix")
    channel.setMethodCallHandler(this)
  }

  override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
    if (call.method == "StackAnalytix") {
      val contentView: ViewGroup = activity.findViewById(android.R.id.content) as ViewGroup
      Log.d("StackAnalytix_Log",contentView.id.toString())
      StackAnalytix.Builder()
        .setContext(activity!!.application)
        .setAppId(15)
        .setClientId(256)
        .setkey("535639e0-4012-40ee-a77f-b0fb84f0709f")
        .setScreenRecorder(true)
        .build()
      result.success("load")
    } else {
      result.notImplemented()
    }
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
  }
}
