/*This is a sketch of a flowsnake builder
done for Codefights*/

String crank(String in){
    char[] charArray = in.toCharArray();
    ArrayList<String> outArray = new ArrayList<String>();
    for(int i = 0; i < charArray.length; i ++){
        if(charArray[i] == '>'){
            outArray.add(">");
        }
        if(charArray[i] == '<'){
            outArray.add("<");
        }
        if(charArray[i] == 'A'){
            outArray.add("A<B<<B>A>>AA>B<");
        }
        if(charArray[i] == 'B'){
            outArray.add(">A<BB<<B<A>>A>B");
        }
    }
    String acc = "";
    for(int i = 0; i < outArray.size(); i ++){
        acc += outArray.get(i);
    }
    
    return acc;
}

char translate(char in){
    if(in == 'A')
        return '=';
    if(in == 'B')
        return '=';
    return in;
}

String shorten(char[] inArray, int i){
    int gt = 0;
    int lt = 0;
    if(inArray[i] == '=')
        return "=";
    
    while(i < inArray.length && (inArray[i] == '<' || inArray[i] == '>')){
        if(inArray[i] == '<')
            lt ++;
        else
            gt ++;
        i ++;
    }
    String acc = "";
    for(int j = lt; j < gt; j ++){
        acc += ">";
    }
    for(int j = gt; j < lt; j ++){
        acc += "<";
    }
    return acc;
}

int forward(char[] inArray, int i){
    int forward = 0;
    if(inArray[i] == '=')
        return 1;
    
    while(i < inArray.length && (inArray[i] == '<' || inArray[i] == '>')){
        forward ++;
        i ++;
    }

    return forward;
}


String translate(String in){
    char[] inArray = in.toCharArray();
    String acc = "";
    for(int i = 0; i < inArray.length; i ++){
            inArray[i] = translate(inArray[i]);
    }
    for(int i = 0; i < inArray.length - 1; i += forward(inArray, i)){
            acc += shorten(inArray,i);
    }
    return acc;
}

String FlowSnake(int n) {
    String LString = "A";
    for(int i = 0; i < n; i ++){
           LString = crank(LString);
    }

    return translate(LString);
}
