#include "validator.h"

void run() {
    bool ispositive = Arg("ispositive");

    int N = Int(1, 5); Endl();
    for (int i = 0; i < N; i++) {
        int H = Int(0, 1000); Space();
        int B = Int(0, 1000); Space();
        int P = Int(1, 1000); Endl();
        if (ispositive) assert(H <= B);
    }
    Eof();
}
