#include <jni.h>
#include "CostosProceso.h"

float calcularCostoPorProceso(const float *costos, size_t num_procesos, float unidades, float *costo_unitario) {
    if (costos == NULL || num_procesos == 0 || unidades < 0) return -1.0f;

    float total_unitario = 0.0f;
    for (size_t i = 0; i < num_procesos; i++) {
        total_unitario += costos[i];
    }

    if (costo_unitario) *costo_unitario = total_unitario;

    return total_unitario * unidades;
}

JNIEXPORT jfloat JNICALL Java_co_uceva_libcostos_lib_CostosProceso_calcularCosto
  (JNIEnv *env, jobject obj, jfloatArray jcostos, jint jnumProcesos, jfloat junidades, jfloatArray junitario) {

    jfloat *costos = (*env)->GetFloatArrayElements(env, jcostos, NULL);
    jfloat *unitario = (*env)->GetFloatArrayElements(env, junitario, NULL);

    float resultado = calcularCostoPorProceso(costos, (size_t)jnumProcesos, junidades, unitario);

    (*env)->ReleaseFloatArrayElements(env, junitario, unitario, 0);
    (*env)->ReleaseFloatArrayElements(env, jcostos, costos, JNI_ABORT); // no necesitamos modificar costos

    return resultado;
}
