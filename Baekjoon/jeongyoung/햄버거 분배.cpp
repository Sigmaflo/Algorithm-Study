#include <iostream>
#include <queue>

using namespace std;

int N, K;

// greedy 
int main(){
  
  cin >> N >> K;

  string str;

  cin >> str;

  queue<int> h;
  queue<int> p;

  for(int i = 0 ; i < N ; i++){
    if(str[i] == 'H')
      h.push(i);
    else
      p.push(i);
  }

  int cnt = 0 ;

  while(!p.empty()){
    
    
    int idx = p.front();
    p.pop();

    //cout << idx << " "<< h.front() <<"\n";
    
    bool found = false;
    while(!h.empty() && idx + K >= h.front()){
      int h_idx = h.front();
      //cout << ">"<< idx << " "<< h_idx<<"\n";
      h.pop();
      if(idx - K <= h_idx && idx + K >= h_idx ){
        //cout  << "hit : "<< idx << " "<< h_idx <<"\n";
        found = true;
        break;
      }
    }

    if(found)
      cnt++;
  }

  cout << cnt;
  

  return 0;
}
