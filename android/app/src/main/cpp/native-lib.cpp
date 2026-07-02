#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_night_easyunitconverter_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello Core Native C++ Engine Functional";
    return env->NewStringUTF(hello.c_str());
}
