class Solution(object):
    def isValid(self, s):

        if len(s) % 2 == 1:
            return False

        stack = []

        for c in s:
            if (c == '(' or c == '[' or c == '{'):
                stack.append(c)
            else:

                if not stack:
                    return False
                    
                if   (c == ')' and stack.pop() != '('):
                    return False
                elif (c == ']' and stack.pop() != '['):
                    return False
                elif (c == '}' and stack.pop() != '{'):
                    return False
        
        if not stack:
            return True
        return False
