#include <iostream>
#include <string.h>
#include <tuple>
#include <vector>

#define MIN 0

using namespace std;

vector< pair<int,int > > adj[100002]; // V, cost

// <max, max leaf>
pair<int, int> dfs(int callee, int x){

    int max_cost = 0;
    int max_leaf = x;

    for(int i = 0 ; i < adj[x].size() ; i++){
        pair<int,int> p = adj[x][i];
        if(p.first == callee)
            continue;
        pair<int, int> res = dfs(x, p.first);
        if(max_cost < p.second + res.first){
            max_cost = p.second + res.first;
            max_leaf = res.second; 
        }
    }  
    pair<int,int> res_pair = make_pair(max_cost, max_leaf);

    return res_pair;
}

int main(){
  int nV;
  int branch[100002];
  cin >> nV;

  for(int i = 1; i <= nV; i++){
    int x;
    int V;
    int E;

      cin >> x;
      while(1){
        cin >> V;
        if(V == -1){
            break;
        }
        branch[V]++;
        cin >> E;
        pair<int,int> p = make_pair(V,E);
        adj[x].push_back(p);
      }
    } 

    // maybe?
    int max_cost = 0;
    pair<int,int> p1 = dfs(0, 1);
    pair<int,int> p2 = dfs(0, p1.second);

    max_cost = max(p1.first, p2.first);

    cout << max_cost;
    return 0;
}

