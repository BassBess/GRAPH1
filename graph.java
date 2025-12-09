
import java.util.*;


class graph{
 boolean directed;
 
private Map<Character, Map<Character, Integer>> adjlist = new HashMap<>();



public graph(boolean d){

directed = d;
  
}

  
 public void addEdge(Character a, Character b, int weight) {
    addVertix(a);
    addVertix(b);

    if (!adjlist.get(a).containsKey(b)) {
        adjlist.get(a).put(b, weight);
    } else {
        adjlist.get(a).put(b, weight);
    }

    if (!directed) {
        adjlist.get(b).put(a, weight);
    }
}



  
  public void addVertix(Character a){
 adjlist.putIfAbsent(a, new HashMap<>());
  }

 
  public void deleteVertix(Character a){
    
  for (Map<Character, Integer> neighbors : adjlist.values()) {
    neighbors.remove(a);
   }
  
    adjlist.remove(a);  
  }



  public boolean removeEdge(Character a, Character b) {
 
    if (directed) {
        if (adjlist.containsKey(a) && adjlist.get(a).remove(b)) {
            return true;  
        }
        return false;
    }

    if (adjlist.containsKey(a) && adjlist.containsKey(b)) {
        boolean removed = false;

        if (adjlist.get(a).remove(b)) removed = true;
        if (adjlist.get(b).remove(a)) removed = true;

        return removed;
    }

    return false;
}



public Set<Character> getVertices() {
    return adjlist.keySet();
}

  public Set<Character> getNeighbors(Character a) {
    if (!adjlist.containsKey(a)) return new HashSet<>();
    return adjlist.get(a).keySet();
}



  
public List<Character> getInNeighbors(Character a){
  List<Character> result = new ArrayList<>();
for (Map.Entry<Character, Map<Character, Integer>> entry : adjlist.entrySet()) {
    if (entry.getValue().containsKey(a)) {
        result.add(entry.getKey());
    }
}

  
      
  return result;
    }

public boolean hasVertex(Character a) {
return adjlist.containsKey(a);
}

public boolean hasEdge(Character a, Character b){
return adjlist.containsKey(a) && adjlist.get(a).containsKey(b);
}


public int getDegree(Character a) {
return adjlist.containsKey(a) ? adjlist.get(a).size() : 0;
}

public int getInDegree(Character a) {

int result = 0;
  
  for (Map<Character, Integer> neighbors : adjlist.values()) {
    if (neighbors.containsKey(a)) result++;
}
  

  return result;
}




public int getNumVertices() {return adjlist.size();}

public int getNumEdges(){

if (adjlist.isEmpty()){
  return 0;

}
  int sum=0;
if(directed){
 for (Map<Character, Integer> neighbors : adjlist.values()) {
   sum += neighbors.size();
}

return sum;
}else{

for (Map<Character, Integer> neighbors : adjlist.values()) {
   sum += neighbors.size();
}

return sum /2; 


  
}
  
 }
public boolean isEmpty() {
    return adjlist.isEmpty(); }

 public double getDensity() {
    int V = getNumVertices();
    if (V <= 1) return 0.0;

    int edges = getNumEdges(); 
    double maxEdges;

    if (directed) {
        maxEdges = V * (V - 1);
    } else {
        maxEdges = V * (V - 1) / 2.0;
    }

    return edges /(double) maxEdges; 
}

public Integer getEdgeWeight(Character a, Character b) {
    if (!adjlist.containsKey(a)) return null;
    return adjlist.get(a).get(b);
}

 public List<Character> bfs(Character a){
  List<Character> result = new ArrayList<>();
  Set<Character> visited = new HashSet<>();
  Queue<Character> Q = new LinkedList<>();

  Q.add(a);
  while(!Q.isEmpty()){

   Character node = Q.remove();
   result.add(node);
   
   
for (Character neighbor : adjlist.get(node).keySet()) {

if(!visited.contains(neighbor)){
    Q.add(neighbor);
    visited.add(neighbor);
}

}   

  
}
  return result;
}
  

  
}
