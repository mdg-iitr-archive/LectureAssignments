//
// Created by whocares on 25/9/17.
//
#include <jni.h>
#include <MidPoint.h>

int getMidPoint(int a, int b) {
    return (a + b) / 2;
}

extern "C"
JNIEXPORT jobject JNICALL

Java_com_example_whocares_ndkassignment_MainActivity_getMidPoint(
        JNIEnv *env,
        jobject callingMethod,
        jobject p1,
        jobject p2
) {
    jclass objectClass = env->GetObjectClass(p1);
    jmethodID xmethodId = env->GetMethodID(objectClass, "getX", "()I");
    jfieldID yfieldId = env->GetFieldID(objectClass, "y", "I");
    int x1 = env->CallIntMethod(p1, xmethodId);
    int x2 = env->CallIntMethod(p2, xmethodId);

    int y1 = env->GetIntField(p1, yfieldId);
    int y2 = env->GetIntField(p2, yfieldId);

    jmethodID constructorMethodId = env->GetMethodID(objectClass, "<init>", "(II)V");

    return env->NewObject(objectClass, constructorMethodId, getMidPoint(x1, x2),
                          getMidPoint(y1, y2));
}

