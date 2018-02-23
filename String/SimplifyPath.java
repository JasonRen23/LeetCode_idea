package LeetCode_idea.String;

import java.util.Stack;

public class SimplifyPath {
    public static String simplifyPath(String path){
        Stack<String> dirs = new Stack<>();

        for(int i = 0; i < path.length();){
            ++i;

            int j = path.indexOf('/', i);
            if(j < 0) j = path.length();
            final String dir = path.substring(i, j);

            if(!dir.isEmpty() && !dir.equals(".")){
                if(dir.equals("..")){
                    if(!dirs.isEmpty())
                        dirs.pop();
                }
                else
                    dirs.push(dir);

            }

            i = j;

        }

        StringBuilder res = new StringBuilder();

        if(dirs.isEmpty()){
            res.append('/');
        }else{
            for(final String dir : dirs){
                res.append('/').append(dir);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String path1 = "/home/";
        String path2 = "/a/./b/../../c/";
        String path3 = "/../";
        String path4 = "/home//foo/";
        System.out.println(simplifyPath(path1));    // /home
        System.out.println(simplifyPath(path2));    // /c
        System.out.println(simplifyPath(path3));    // /
        System.out.println(simplifyPath(path4));    // /home/foo
    }
}
