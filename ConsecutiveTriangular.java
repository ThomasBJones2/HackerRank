boolean isTriangular(int in){
    int n = (int) Math.sqrt(in*2);
    return in*2 == n*(n+1);
}

boolean Triangular(int n) {
    ArrayList<Integer> triangular = new ArrayList<Integer> ();
    for(int i = 0; i < Math.sqrt(n); i ++){
        if(isTriangular(i)){
            triangular.add(i);
        }
    }
    for(int i = 0; i < triangular.size() - 1; i ++){
        int a = triangular.get(i);
        int b = triangular.get(i + 1);
        if(n == a*a + b*b)
            return true;
    }
    return false;
}

