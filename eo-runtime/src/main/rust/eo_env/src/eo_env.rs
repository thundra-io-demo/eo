use jni::JNIEnv;
use jni::objects::{JClass, JObject, JValue};

#[allow(dead_code)]
pub struct EOEnv<'local> {
    java_env: JNIEnv<'local>,
    java_class: JClass<'local>,
    java_obj: JObject<'local>
}

impl<'local> EOEnv<'_> {
    pub fn new(java_env: JNIEnv<'local>, java_class: JClass<'local>, java_obj: JObject<'local>) -> EOEnv<'local> {
        EOEnv {
            java_env,
            java_class,
            java_obj
        }
    }

    pub fn find(&mut self, att: &str) -> i32 {
        1
    }
}
