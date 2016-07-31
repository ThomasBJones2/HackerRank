public class Solution {
    public String simplifyPath(String path) {
        String[] steps = path.split("/");
        ArrayList<String> cleanSteps = new ArrayList<String>();
        for(int i = 0; i < steps.length; i ++){
            if(steps[i].equals("."));
            else if (steps[i].length() == 0);
            else if(steps[i].equals("..")){
                if(cleanSteps.size() > 0)
                    cleanSteps.remove(cleanSteps.size() - 1);
            }
            else {
                cleanSteps.add(steps[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cleanSteps.size(); i ++){
            sb.append("/");
            sb.append(cleanSteps.get(i));
        }
        if(sb.toString().length() == 0){
            sb.append("/");
        }
        return sb.toString();
    }
}
