#include <string>
#include <cstdio>
#include <iostream>
#include <algorithm>
using namespace std;

int sum(int a){
    int s = 0;
    while(a){
        s += a%10;
        a /= 10;
    }
    return s < 10 ? s : sum(s);
}

int mult(int a ){
    int s = 1;
    while(a){
        s *= a%10;
        a /= 10;
    }
    return s < 10 ? s : mult(s);
}

int main(){
    int a, b;
    cin >> a >> b;
    int ans = 0;
    for(int i = a; i<=b; i++){
        if(sum(i) == mult(i)){
            ans++;
        }
    }
    cout << ans << endl;
}
