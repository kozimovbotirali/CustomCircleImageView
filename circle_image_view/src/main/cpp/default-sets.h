#include <jni.h>
#include<android/log.h>
//
// Created by B.Kozimov on 29.10.2021.
//

#ifndef CUSTOMCIRCLEIMAGEVIEW_DEFAULT_SETS_H
#define CUSTOMCIRCLEIMAGEVIEW_DEFAULT_SETS_H

#define log_d(MESSAGE)  __android_log_write(ANDROID_LOG_DEBUG, __func__, MESSAGE)
#define log_e(MESSAGE)  __android_log_write(ANDROID_LOG_ERROR, __func__, MESSAGE)

#define CONNECT_PACKAGE(NAME) Java_com_sabgames_circle_1image_1view_BitmapHelper_##NAME
#define fun(TYPE, NAME, ...) JNIEXPORT TYPE JNICALL CONNECT_PACKAGE(NAME)(JNIEnv *env, jobject thiz, ## __VA_ARGS__)

#endif //CUSTOMCIRCLEIMAGEVIEW_DEFAULT_SETS_H