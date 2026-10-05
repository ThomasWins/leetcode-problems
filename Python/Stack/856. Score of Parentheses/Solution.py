class Solution(object):
    def scoreOfParentheses(self, s):

        ret = 0
        stk = []

        for c in s:

            if c == '(':
                stk.append('(')
            else:
                tmp = 0
                while(stk[-1] != '('):
                    tmp += int(stk.pop()) # A|B = A + B
                stk.pop() # remove '('
                if (tmp == 0):
                    stk.append('1')
                else:
                    stk.append(str(tmp*2))
        
        for i in stk:
            ret += int(i)
        
        return ret


