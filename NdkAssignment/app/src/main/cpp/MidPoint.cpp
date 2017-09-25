//
// Created by harshit on 25/9/17.
//
#include <jni.h>

extern "C"
JNIEXPORT jobject JNICALL
Java_com_example_harshit_ndkassignment_MainActivity_getMidPoint(
JNIEnv* env,
jobject callingMethod,
jobject x,
jobject y
){
jclass cls = env->GetObjectClass(x);
jmethodID methodIdX = env->GetMethodID(cls, "getX", "()I");
jfieldID fieldIdY = env->GetFieldID(cls, "y", "I");
int x1 = env->CallIntMethod(x, methodIdX);
int y1 = env->GetIntField(x, fieldIdY);
int x2 = env->CallIntMethod(y, methodIdX);
int y2 = env->GetIntField(y, fieldIdY);
int midPointX = (x1 + x2)/2;
int midPointY = (y1 + y2)/2;
jmethodID methodId = env->GetMethodID(cls, "<init>", "(II)V");
jobject obj = env->NewObject(cls, methodId, midPointX, midPointY);
return obj;
}
