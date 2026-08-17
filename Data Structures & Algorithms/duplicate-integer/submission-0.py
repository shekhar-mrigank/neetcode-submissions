class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        if not nums :
            return False
        seen = {}
        for n in nums :
            if n in seen:
                return True
            seen[n] = 1
        print(seen)        
        return False
        