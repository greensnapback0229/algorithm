#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>

using namespace std;

//stack data struct
class Sd{
    public: 
        vector<int> connected;
        int straddled, visited;
};

//vector<pair<int, int>> edges;
vector<vector<int>> edges;
vector<Sd> sds;
stack<Sd> s;
int main(){
    
    int n;
    cin >> n;
    sds.resize(n+1);
    
    for(int i=0;i<n-1;i++){
        int a, b;
        cin >> a >> b;
        
        sds[a].connected.push_back(b);
        sds[b].connected.push_back(a);
    }

    //3개 이상 겹치면 사이클이 만들어짐
    for (int i = 1; i < edges.size(); ++i) {
        cout << "Vertex " << i << " adjacent vertices: ";
        for (int j = 0; j < edges[i].size(); ++j) {
            cout << edges[i][j] << " ";
        }
        cout << endl;
    }   
    
}


/*int dfs(Sd sd, int prev){
    if(prev == 0){
        for()
    }
    return 1;
}*/

