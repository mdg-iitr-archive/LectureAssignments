#include "MidPoint.h"
#include<cmath>

extern "C"
JNIEXPORT jint JNICALL
Java_com_aridj456_ndkassignment1_NativeWrapper_distance(JNIEnv *env, jobject instance, jobject a,
                                                        jobject b) {

    jclass cls = env->GetObjectClass(a);

    // for getting x using get Method
    jmethodID getXId = env->GetMethodID(cls,"getX","()I");
    int x1 = env->CallIntMethod(a,getXId);
    int x2 = env->CallIntMethod(b,getXId);

    //for getting y using y field
    jfieldID yId = env->GetFieldID(cls,"y","I");
    int y1 = env->GetIntField(a,yId);
    int y2 = env->GetIntField(b,yId);

    // distance
    int dis = (int) sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    return dis;

}

extern "C"
JNIEXPORT jobject JNICALL
Java_com_aridj456_ndkassignment1_NativeWrapper_getMidPoint(JNIEnv *env, jobject instance, jobject a,
                                                           jobject b) {
    jclass cls = env->GetObjectClass(a);

    //for getting x
    jmethodID getXId = env->GetMethodID(cls,"getX","()I");
    int x1 = env->CallIntMethod(a,getXId);
    int x2 = env->CallIntMethod(b,getXId);

    //for getting y
    jfieldID yId = env->GetFieldID(cls,"y","I");
    int y1 = env->GetIntField(a,yId);
    int y2 = env->GetIntField(b,yId);

    // creating new object from midpoint of a and b
    jmethodID constructor = env->GetMethodID(cls,"<init>","(II)V");
    jobject obj = env->NewObject(cls,constructor,getMidPoint(x1,x2),getMidPoint(y1,y2));
    return obj;
}

int getMidPoint(int x1,int x2){
    return (x1+x2)/2;
}
