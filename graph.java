
import java.util.HashMap;


class graph{
  
 private Map<Character,List <Character>> adjlist = new HashMap<>();


 public addEdge(Character a,Charachter b){
   
        adjlist.putIfAbsent(a, new ArrayList<>());
        adjlist.get(a).add(b);

 }
 public addUndirected(Character a, Character b ){

   addVertix(Character a);
   adjlist.get(a).add(b);
   addVertix(Character b)
   adjlist.get(b).add(a);

 }

  
  public addVertix(Character a){
    adjlist.putIfAbsent(a, new ArrayList<>()); 
  }

  public deleteVertix(Character a){
    
  for (List<Character> list : adjlist.values()) {
      list.remove(a)    
    }    
    adjlist.remove(a);  
  }


  

}
