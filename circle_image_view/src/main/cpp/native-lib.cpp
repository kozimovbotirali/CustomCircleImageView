#include <jni.h>
#include<string>
#include<sstream>
#include<android/log.h>
#include <iostream>
//#include_next "default-sets.h"

//
// Created by B.Kozimov on 29.10.2021.
//

#define log_d(MESSAGE)  __android_log_write(ANDROID_LOG_DEBUG, "TTT", MESSAGE)
#define log_e(MESSAGE)  __android_log_write(ANDROID_LOG_ERROR, "TTT", MESSAGE)

#define CONNECT_PACKAGE(NAME) Java_com_sabgames_circle_1image_1view_BitmapHelper_##NAME
#define fun(TYPE, NAME, ...) JNIEXPORT TYPE JNICALL CONNECT_PACKAGE(NAME)(JNIEnv *env, jobject thiz, ## __VA_ARGS__)

using namespace std;

int SQR(int x);

extern "C"
fun(void, toCircledImage, jintArray _pixels, jint width, jint height) {
    jint *pixels = env->GetIntArrayElements(_pixels, NULL);
    if (NULL != pixels) {
        int x0 = width / 2;
        int y0 = height / 2;

        int radius = (x0 <= y0) ? x0 : y0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int index = width * i + j;
                int temp = SQR(j - x0) + SQR(i - y0);
                if (SQR(radius) < temp) {
                    pixels[index] = 0x00FFFFFF;
                }
            }
        }
        env->ReleaseIntArrayElements(_pixels, pixels, 0);
    }
}

int SQR(int x) {
    return x * x;
}