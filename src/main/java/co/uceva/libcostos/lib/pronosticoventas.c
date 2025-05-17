#include <jni.h>
#include "PronosticoVentas.h"  // generado con javah o javac -h

void calcular_minimos_cuadrados(float *ventas, int n, int meses_pronosticar, float *pronostico) {
    float sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;
    int i;
    // X será 1, 2, 3,... para cada mes histórico
    for (i = 0; i < n; i++) {
        int x = i + 1;
        float y = ventas[i];
        sumX += x;
        sumY += y;
        sumXY += x * y;
        sumX2 += x * x;
    }
    float denominator = n * sumX2 - sumX * sumX;
    float a = (sumY * sumX2 - sumX * sumXY) / denominator;  // intercepto
    float b = (n * sumXY - sumX * sumY) / denominator;      // pendiente

    // calcular pronóstico para meses siguientes
    for (i = 0; i < meses_pronosticar; i++) {
        int x = n + 1 + i;
        float val = a + b * x;
        // Limitar a mínimo 0
        pronostico[i] = (val < 0) ? 0 : val;
    }
}

JNIEXPORT void JNICALL Java_co_uceva_libcostos_lib_PronosticoVentas_calcularPronostico
  (JNIEnv *env, jobject obj, jfloatArray ventas, jint numPeriodos, jint numMesesPronosticar, jfloatArray resultado) {

    jfloat *ventas_c = (*env)->GetFloatArrayElements(env, ventas, NULL);
    jfloat *resultado_c = (*env)->GetFloatArrayElements(env, resultado, NULL);

    calcular_minimos_cuadrados(ventas_c, numPeriodos, numMesesPronosticar, resultado_c);

    (*env)->ReleaseFloatArrayElements(env, ventas, ventas_c, 0);
    (*env)->ReleaseFloatArrayElements(env, resultado, resultado_c, 0);
}
