import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

class Topological_Sort {
    public static void main(String[] args) {

    }

    //! Depth First Search
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        HashMap<Integer,ArrayList<Integer>> hash = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (ArrayList<Integer> i : edges) {
            ArrayList<Integer> lst = hash.getOrDefault(i.get(0), new ArrayList<>());
            lst.add(i.get(1));
            hash.put(i.get(0),lst);
        }
        int[] visi = new int[v];
        Arrays.fill(visi, -1);
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < visi.length; i++) {
            if(visi[i]==-1){
                toposort(i,hash,visi,stk);
            }
        }
        while(!stk.empty()){
            res.add(stk.pop());
        }
        return res;
    }

    static void toposort(int node, HashMap<Integer, ArrayList<Integer>> hash, int[] visi, Stack<Integer> stk) {
        visi[node]++;
        if (!hash.containsKey(node)) {
            stk.push(node);
            return;
        }
        ArrayList<Integer> lst = hash.get(node);
        for (int i = 0; i < lst.size(); i++) {
            if (visi[lst.get(i)] == -1) {
                toposort(lst.get(i), hash, visi, stk);
            }
        }
        stk.push(node);
    }
    

    //! Kahn's Algorithm 
    

}