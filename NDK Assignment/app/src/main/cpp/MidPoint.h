//
// Created by rohan on 24/9/17.
//

#ifndef NDK_ASSIGNMENT_MIDPOINT_H
#define NDK_ASSIGNMENT_MIDPOINT_H

#include <jni.h>

extern "C" JNIEXPORT jobject JNICALL
Java_com_sdsmdg_ndkassignment_Point_getMidPoint(
        JNIEnv *env, jobject callingObject, jobject p1, jobject p2);

int midPoint(int, int);

#endif //NDK_ASSIGNMENT_MIDPOINT_H
