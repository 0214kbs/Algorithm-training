class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        prev, cur, res = 0,1,0
        for i in range(1,len(s)):
            if s[i]!=s[i-1]:
                res += min(cur, prev)
                prev = cur
                cur =1
            else:
                cur+=1
        return res+min(prev,cur)