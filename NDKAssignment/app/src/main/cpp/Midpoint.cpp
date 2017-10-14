//
// Created by samagra on 14/10/17.
//

#include "Midpoint.h"
#include <jni.h>
int midPoint(int a, int b){
    return (a+b)/2;
}
extern "C"

JNIEXPORT jobject JNICALL
Java_com_sdsmdg_ndkassignment_MainActivity_getMidpoint(JNIEnv *env, jobject instance, jobject one,
                                                       jobject two) {

    jclass pointClass = env->GetObjectClass(one);
    jfieldID yId = env->GetFieldID(pointClass,"y","I");
    jmethodID getXId = env -> GetMethodID(pointClass,"getX","()I");
    jmethodID constructorID = env -> GetMethodID(pointClass,"<init>","(II)V");

    int y1 =  env-> GetIntField(one, yId);
    int y2 =  env-> GetIntField(two,yId);

    int x1 = env -> CallIntMethod(one,getXId);
    int x2 = env -> CallIntMethod(two,getXId);

    return env->NewObject(pointClass,constructorID, midPoint(x1,x2), midPoint(y1,y2));



}


