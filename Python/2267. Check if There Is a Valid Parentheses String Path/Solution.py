class Solution:
    def hasValidPath(self, grid):
        rows = len(grid)
        cols = len(grid[0])

        if grid[0][0] == ')' or grid[rows - 1][cols - 1] == '(':
            return False

        if (rows + cols - 1) % 2 != 0:
            return False

        memo = {}

        def search_path(row, col, balance):
            if grid[row][col] == '(':
                balance += 1
            else:
                balance -= 1

            if balance < 0:
                return False

            if row == rows - 1 and col == cols - 1:
                return balance == 0

            state = (row, col, balance)

            if state in memo:
                return memo[state]

            valid_path = False

            if row + 1 < rows:
                valid_path = search_path(row + 1, col, balance)

            if not valid_path and col + 1 < cols:
                valid_path = search_path(row, col + 1, balance)

            memo[state] = valid_path
            return valid_path

        return search_path(0, 0, 0)
        
        
        
        
        
        """
        Time Limit Exceeded

        m = len(grid)
        n = len(grid[0])

        def dp(s, x, y, bal):

            if (grid[x][y] == '('):
                bal += 1
            else:
                bal -= 1

            if bal < 0: # Immediatly stop path if more ')' than '('
                return False

            s += grid[x][y]

            if (x == m-1 and y == n-1 and bal == 0):
                return True

            if (x < m-1):
                if (dp(s, x+1, y, bal)):
                    return True
            if (y < n-1):
                if (dp(s, x, y+1, bal)):
                    return True
            
            return False


        return dp("", 0, 0, 0)

        """
