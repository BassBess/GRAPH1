
import java.util.*;


class graph{
 Boolean directed;
 private Map<Character,List <Character>> adjlist = new HashMap<>();

public graph(boolean d){

directed = d;
  
}

  
 public void addEdge(Character a,Character b){
      addVertix(a);
     addVertix(b);
   if(directed){
  
   
       if (!adjlist.get(a).contains(b)) {
        adjlist.get(a).add(b);
    }
   }else{

        if (!adjlist.get(a).contains(b)) adjlist.get(a).add(b);
        if (!adjlist.get(b).contains(a)) adjlist.get(b).add(a);
     
   }

 }


  
  public void addVertix(Character a){
    adjlist.putIfAbsent(a, new ArrayList<>()); 
  }

  public void deleteVertix(Character a){
    
  for (List<Character> list : adjlist.values()) {
      list.remove(a)    ;
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

  
public List<Character> getNeighbors(Character a) {
    return adjlist.getOrDefault(a, new ArrayList<>());
}


  
public List<Character> getInNeighbors(Character a){
  List<Character> result = new ArrayList<>();
for (Map.Entry<Character, List<Character>> entry : adjlist.entrySet()) {
    if (entry.getValue().contains(a)) {
        result.add(entry.getKey());
    }
}
  
      
  return result;
    }

public boolean hasVertex(Character a) {
return adjlist.containsKey(a);
}

public boolean hasEdge(Character a, Character b){
return adjlist.containsKey(a) && adjlist.get(a).contains(b);
}


public int getDegree(Character a) {
return adjlist.containsKey(a) ? adjlist.get(a).size() : 0;
}

public int getInDegree(Character a) {

int result = 0;
  
  for (List<Character> list : adjlist.values()) {
      if( list.contains(a)){
    result++;
      }
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
  for (List<Character> list : adjlist.values()) {
    sum += list.size();
}
return sum;
}else{

for (List<Character> list : adjlist.values()) {
   sum += list.size();
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

    return edges / maxEdges; 
}


  
}
  

  

