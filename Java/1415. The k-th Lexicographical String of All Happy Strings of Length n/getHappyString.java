class Solution {
    public String getHappyString(int n, int k) {
        Stack<String> st=new Stack<>();
        int count=0;
        st.push("");
        while(st.size()>0)
        {
            String curr=st.pop();
            if(curr.length()==n)
            {
                count++;
                if(count==k) return curr;
                continue;
            }
            for(char ch='c';ch>='a';ch--)
            {
                if(curr.length()==0 || curr.charAt(curr.length()-1)!=ch) st.push(curr+ch);
            }
        }
        return "";
    }
}
