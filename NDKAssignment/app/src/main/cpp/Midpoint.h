//
// Created by samagra on 14/10/17.
//

#ifndef NDKASSIGNMENT_MIDPOINT_H
#define NDKASSIGNMENT_MIDPOINT_H

#include <jni.h>

extern "C" JNIEXPORT jobject JNICALL
Java_com_sdsmdg_ndkassignment_Point_getMidPoint(
        JNIEnv *env, jobject callingObject, jobject p1, jobject p2);

int midPoint(int a, int b);

#endif //NDKASSIGNMENT_MIDPOINT_H
