#  Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
# For example:
# Given the below binary tree and sum = 22,

#               5
#              / \
#             4   8
#            /   / \
#           11  13  4
#          /  \      \
#         7    2      1

# return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        if root==None:
            return False
        if root.left==None and root.right==None:
            return sum==root.val
        
        sum-=root.val
        
        if root.left!=None and root.right==None:
            return self.hasPathSum(root.left,sum)
        
        if root.right!=None and root.left==None:
            return self.hasPathSum(root.right,sum)
         
        if root.left!=None and root.right!=None:
            return self.hasPathSum(root.left,sum) if self.hasPathSum(root.left,sum) == True else self.hasPathSum(root.right,sum)
        
        
        