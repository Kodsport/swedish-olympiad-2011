#include <string>
#include <cstdio>
#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int n;
    cin >> n;
    int ans = 0;
    for(int i = 0; i<n; i++){
        int a, b, c;
        cin >> a >> b >> c;
        ans += (b - a)*c;
    }
    cout << ans << endl;
}
