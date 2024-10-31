#include <bits/stdc++.h>
using namespace std;

int firstMissingPositive(vector<int>& nums){
    unordered_map<int, bool> vis;
    int maxi = INT_MIN;

    for(int& i : nums){
        vis[i] = true;
        maxi = max(maxi, i);
    }

    for(int i = 1; i <= maxi; ++i){
        if(!vis[i]){
            return i;
        }
    }
    
    return (maxi > 0) ? maxi + 1 : 1;
}