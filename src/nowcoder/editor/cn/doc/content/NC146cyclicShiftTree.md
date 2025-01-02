<div>  现有一棵<img src="https://www.nowcoder.com/equation?tex=n&preview=true">个节点构成的二叉树，请你将每一层的节点向右循环位移<img src="https://www.nowcoder.com/equation?tex=k&preview=true">位。某层向右位移一位(即<img alt="" src="https://www.nowcoder.com/equation?tex=k%3D1">)的含义为： </div> <div>  1.若当前节点为左孩子节点，会变成当前节点的双亲节点的右孩子节点。 </div> <div>  2.若当前节点为右儿子，会变成当前节点的<span>双亲</span>节点的右边相邻兄弟节点的左孩子节点。(如果当前节点的<span>双亲</span>节点已经是最右边的节点了，则会变成<span>双亲</span>节点同级的最左边的节点的左孩子节点) </div> <div>  3.该层的每一个节点同时进行一次位移。 </div> <div>  4.是从最下面的层开始位移，位移完每一层之后，再向上，直到根节点，位移完毕。 </div> <div>  <br> </div> <p>  如果从最后一层开始对该二叉树的每一层循环位移<img src="https://www.nowcoder.com/equation?tex=k&preview=true">位。以下方二叉树为例，<img alt="" src="https://www.nowcoder.com/equation?tex=k%3D1">： </p> <pre class="prettyprint">      1
     / \
    2   3
       / \
      4   5</pre> <div>  位移最后一层，5变成2的左孩子节点，4变成3的右孩子节点，如下图: </div> <div> <pre class="prettyprint">      1
     / \
    2   3
   /     \
  5       4</pre> </div> <div>  再位移倒数第二层，3变成1的左孩子节点，2变成1的右孩子的节点，它们的孩子节点随着一起位移，如下图： </div> <pre class="prettyprint">      1
     / \
    3   2
    \   /
     4 5</pre> <div>  根节点没有<span>双亲</span>节点，不用位移，位移完毕 </div> <div>  <br> </div> <div>  现在给你这棵二叉树，请你返回循环右移<img src="https://www.nowcoder.com/equation?tex=k&preview=true">位后的二叉树。 </div><div><br></div><div><div>Related Topics</div><div><li>树</li></div></div><br>示例:<br>输入:{1,2,3,#,#,4,5},1<br>输出:{1,3,2,#,4,5}
<br>