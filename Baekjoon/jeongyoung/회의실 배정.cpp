#include <iostream>
#include <algorithm>
#include <vector>
#define pii pair<int, int >

using namespace std;



int N ;
vector<pii> arr;
int main(){

  cin >> N;

  for(int i = 0 ; i < N ; i++){
    int a, b, c;

    cin >> a >> b;
    arr.push_back(make_pair(b, a));
  }

  sort(arr.begin(), arr.end());

  int t = 0 ;
  int ans = 0 ;
  for(int i = 0; i < N ; i++){
    int e = arr[i].first;
    int s = arr[i].second;

    if(s < t)
      continue;

    t = e;

    //cout << "< " << s << " " << e << "\n";
    ans++;
    
  }
  cout << ans;

  


  return 0;
}
