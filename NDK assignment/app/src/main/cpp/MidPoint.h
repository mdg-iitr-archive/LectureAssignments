#include <jni.h>

extern "C" JNIEXPORT jobject JNICALL
Java_com_aridj456_ndkassignment1_NativeWrapper_getMidPoint(
        JNIEnv *env, jobject callingObject, jobject a, jobject b);

int getMidPoint(int a, int b);