#include <jni.h>
#include <string>

using namespace std;

const string BASE_URL = "yourUrl";

extern "C"
JNIEXPORT jstring  extern "C" jstring
Java_com_example_myproject_ext_constant_ConstApi_getEndPoint(JNIEnv *env, jobject thiz) {

    string s = BASE_URL;

    return env->NewStringUTF(s.c_str());
}



//extern "C" jstring JNICALL
//Java_com_example_myproject_ConstKeys_getEndPoint(
//        JNIEnv *env, jobject thiz, jint envtype, jint envvariant) {
////    int type = (int) envtype;
////    int variant = (int) envvariant;
//    string s = BASE_URL;
//
////    if (type == ENV_PRODUCTION) {
////        s = PROD_END_POINT;
////    } else if (type == ENV_STAGING) {
////        s = STAGING_END_POINT;
////    } else {
////        if (variant == ENV_VARIANT_BCA) {
////            s = DEV_BCA_END_POINT;
////        } else if (variant == ENV_VARIANT_CAKRA) {
////            s = DEV_CAKRA_END_POINT;
////        }
////    }
//
//    return env->NewStringUTF(s.c_str());
//}