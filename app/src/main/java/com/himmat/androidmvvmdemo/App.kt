package com.himmat.androidmvvmdemo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Himmat Sawant.
 * Date : 24-04-2023.
 * Description : To set up Hilt need to annotate Application class with @HiltAndroidApp so it
 *               can generate required component. @HiltAndroidApp triggers Hilt's code generation
 */

@HiltAndroidApp
class App : Application(){
}