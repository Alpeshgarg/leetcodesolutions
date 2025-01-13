class Solution {
    public int minimumLength(String s) {        
        int[] arr=new int[26];

        //Counting the char
        for(char ch:s.toCharArray()){
            arr[ch-'a']++;
        }

        int len=0;
        //Applying the rules and counting the string length
        for(int i=0; i<26; i++){
            if(arr[i]==0) continue;
            len +=(arr[i]%2==0)?2:1;            
        }
        
        
        return len;
    }
}