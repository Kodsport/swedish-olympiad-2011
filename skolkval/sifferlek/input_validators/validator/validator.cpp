#include "validator.h"

void run() {
    int a = Int(1, int(1e6));
    Space();
    int b = Int(a, Arg("maxn"));
    Endl();
    
    Eof();
}
