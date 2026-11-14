class Solution:
    def isSolvable(self, words: List[str], result: str) -> bool:
        words.append(result)
        rows, cols = len(words), max(map(len, words))
        if cols == 1:
            return True

        letterToDigit = {}
        digitToLetter = [None]*10

        def search(column, row, bal):
        	if column >= cols:
        		return bal==0

        	if row == rows:	
        		return bal%10==0 and search(column + 1, 0, bal//10)

        	word = words[row]
        	if column >= len(word):
        		return search(column, row+1, bal)

        	letter = word[~column] #column = n-column
        	sign = 1 if row < (rows-1) else -1 #sign will be -1 if it is result row

        	#digit assigned already exists
        	if letter in letterToDigit and (letterToDigit[letter] or column != len(word)-1):
        		return search(column, row+1, bal + sign*letterToDigit[letter])
        	else:
        		#find an assignment that works, using backtracking
        		for d,c in 	enumerate(digitToLetter):
        			if c is None and (d or column != len(word)-1): #second condition is to prevent leading zeroes
        				digitToLetter[d] = letter
        				letterToDigit[letter] = d

        				if search(column, row + 1, bal + sign*d):
        					return True

        				digitToLetter[d] = None
        				if letter in letterToDigit:
        					del letterToDigit[letter]
        	return False

        return search(0,0,0)

