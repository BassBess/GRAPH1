
import java.util.HashMap;


class graph{
  
 private Map<Character,List <Character>> adjlist = new HashMap<>();


 public addEdge(Character a,Character b){
   
        adjlist.putIfAbsent(a, new ArrayList<>());
        adjlist.get(a).add(b);

 }
 public addUndirected(Character a, Character b ){

   addVertix(Character a);
   adjlist.get(a).add(b);
   addVertix(Character b);
   adjlist.get(b).add(a);

 }

  
  public addVertix(Character a){
    adjlist.putIfAbsent(a, new ArrayList<>()); 
  }

  public deleteVertix(Character a){
    
  for (List<Character> list : adjlist.values()) {
      list.remove(a)    ;
    }    
    adjlist.remove(a);  
  }



  public removeEdge(Character a, Character b){

if (adjlist.containsKey(a)) {
        adjlist.get(a).remove(b);
    }
    
  }
public removeUndirected(Character a, Character b){


    adjlist.get(a).remove(b);
    adjlist.get(b).remove(a);
    
  }

public Set<Character> getVertices() {
    return adjlist.keySet();
}

  
public List<Character> getNeighbors(Character a) {
    return adjlist.getOrDefault(a, new ArrayList<>());
}


  
public List<Character>getInNeighbors(Character a){
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







  
}
