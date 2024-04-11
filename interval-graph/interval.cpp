#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#define L = 1;
#define R = 1;

using namespace std;

//interval_info
class Sd{
    public: 
        //인접 vertexs
        vector<int> connected;
        //걸친 node 수
        int straddled=0;
        //dfs 탐색 방문 유무
        bool visited = false;
        int start, end;
        
};

int dfs(int index, int depth);
void print_dfs(int index);

vector<Sd> interval;
int result = 1;

int main(){
    
    int n;
    cin >> n;
    interval.resize(n+1);
    
    for(int i=0;i<n-1;i++){
        int a, b;
        cin >> a >> b;
        
        interval[a].connected.push_back(b);
        interval[b].connected.push_back(a);
    }

    for (int i = 1; i < interval.size(); ++i) {
        cout << "Vertex " << i << " adjacent vertices: ";
        for (int j = 0; j < interval[i].connected.size(); ++j) {
            cout << interval[i].connected[j] << " ";
        }    
        //cout << "\nvisited: " << interval[i].visited << ", straddled: " << interval[i].straddled << endl;
        cout << endl;

    }   
    
    dfs(1, 0);

    if(result == -1){
        cout << -1 << endl;
    }
    else{
        cout << 1 << endl;
        print_dfs(1);
    }
}


int dfs(int index, int depth){
    Sd& sd = interval[index];
    int r_depth = depth;
    sd.visited = true;

    if(sd.connected.size() == 1){
        return depth;
    }

    for(int i=0;i<sd.connected.size();i++){
        //cout << "interval[" << i << "] : " << "visited: " << interval[i].visited << endl;
        int next_index = sd.connected[i];

        if(!interval[next_index].visited){
            int r = dfs(next_index, depth+1);
            r_depth = max(r, r_depth);
            r -= depth;
            if(r >= 2 ){
                cout << index << " - " <<"interval[" << next_index <<"]: 방향으로 depth 2 이상 소유" << endl;
                sd.straddled += 1;
            }
        }
    }

    //cout << "interval[" << index <<"].straddled =  " << interval[index].straddled << ", r_depth="<<r_depth <<endl;
    //걸친 interval이 2개 이상

    if(index == 1){
        if(sd.straddled > 2)
            result = -1;
    }
    else{
        if(sd.straddled > 1)
            result = -1;
    }
    

    cout << "interval[" << index <<"].straddled =  " << interval[index].straddled << ", r_depth="<<r_depth << ", result=" << result <<endl;
    return r_depth;
}

void print_dfs(int index, int direction){
    int length = interval[index].connected.size();
    for(int i=0;i<interval[index].connected.size();i++){
        int next_index = i;
        
    }
}