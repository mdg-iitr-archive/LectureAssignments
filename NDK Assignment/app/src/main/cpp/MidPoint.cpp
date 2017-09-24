//
// Created by rohan on 24/9/17.
//

#include "MidPoint.h"

extern "C" JNIEXPORT jobject JNICALL
Java_com_sdsmdg_ndkassignment_Point_getMidPoint(
        JNIEnv *env, jobject callingObject, jobject p1, jobject p2) {

    jclass pointClass = env->GetObjectClass(p1);

    jfieldID yFieldID = env->GetFieldID(pointClass, "y", "I");
    jmethodID getXMethodID = env->GetMethodID(pointClass, "getX", "()I");
    jmethodID setXMethodID = env->GetMethodID(pointClass, "setX", "(I)V");
    jmethodID constrMethodID = env->GetMethodID(pointClass, "<init>", "(II)V");

    int x1 = env->CallIntMethod(p1, getXMethodID);
    int y1 = env->GetIntField(p1, yFieldID);

    int x2 = env->CallIntMethod(p2, getXMethodID);
    int y2 = env->GetIntField(p2, yFieldID);

    return env->NewObject(
            pointClass,
            constrMethodID,
            midPoint(x1, x2),
            midPoint(y1, y2)
    );
}

int midPoint(int a, int b) {
    return (a + b) / 2;
}