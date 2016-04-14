
/*Sketch of Max Flow*/

class spLink{
    spLink(int name, int back){
        this.name = name;
        this.back = back;
    }
    int name;
    int back;
}

boolean inList(ArrayList<spLink> inList, int name){
    for(int i = 0; i < inList.size(); i ++){
        if(inList.get(i).name == name)
            return true;
    }
    return false;
}

ArrayList<spLink> shortestPath(int resource, int server, int[][] network){

    ArrayList<spLink> queue, sP;
    queue = new ArrayList<spLink>();
    sP = new ArrayList<spLink>();
    
    queue.add(new spLink(server, -1));
    sP.add(new spLink(server, -1));
    
    while(queue.size() > 0){
        spLink nextGuy = queue.get(0);
        queue.remove(0);
        for(int i = 0; i < network.length; i ++){
            if(network[nextGuy.name][i] > 0 && !inList(sP,i)){
                queue.add(new spLink(i,nextGuy.name));
                sP.add(new spLink(i,nextGuy.name));
                if(i == resource)
                    queue = new ArrayList<spLink>();
            }
        }
    }
    return sP;
}

spLink getInList(ArrayList<spLink> inList, int name){
    for(int i = 0; i < inList.size(); i ++){
        if(inList.get(i).name == name)
            return inList.get(i);
    }
    return null;
}

int min(int a, int b){
    if(a < b)
        return a;
    else
        return b;
}

int maxAlongSP(ArrayList<spLink> inList, int resource, int server, int[][] network){
    int current = resource;
    int maxAlong = Integer.MAX_VALUE;
    while(current != server) {
        spLink next = getInList(inList,current);
        if(next != null){
            maxAlong = min(maxAlong, network[next.back][next.name]);
            current = next.back;
        }
        else {
            maxAlong = 0;
            current = server;
        }
    }
    return maxAlong;
}

int[][] subTractRisidual(ArrayList<spLink> inList, int max, int resource, int server, int [][] network){
    int current = resource;
    while(current != server) {
        spLink next = getInList(inList,current);
        if(next != null){
            network[next.back][next.name] -= max;
            current = next.back;
        }
        else {
            current = server;
        }
    }
    return network;
}

int dataRoute(int resource, int server, int[][] network) {
    int residual = 0;
    
    int max = 1;
    while(max > 0){
        ArrayList<spLink> shortPath = shortestPath(server,  resource, network);
        max = maxAlongSP(shortPath, server, resource, network);
        network = subTractRisidual(shortPath, max, server, resource, network);
        residual += max;
    }
    
    
    
    return residual;
}
