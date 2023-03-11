#include <iostream>
#include <vector>

#define ll long long 
using namespace std;

int N, M;
vector<int> arr;

int main(){

  cin >> N >> M;
  for(int i = 0 ; i < N; i++){
    int a;
    cin >> a;
    arr.push_back(a);
  }

  int low = 0;
  int high = 1e9;
  int ans = 1e9;

  int mid = (low + high) / 2;
  while(low < high) {
    mid = (low + high) / 2;

    ll sum = 0;
    for(int i = 0 ; i < N; i++){
      if(arr[i] - mid > 0 )
        sum += arr[i] - mid;
    }
    //cout << high << " " << low << " " << mid << " " << sum << "\n";

    if(sum >= M){
      ans = mid;
      low = mid + 1;
    }else{
      high = mid;
    }
  }

  cout << ans;


  return 0;
}
