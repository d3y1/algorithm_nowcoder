<div>
	二叉树里面的路径被定义为:从该树的任意节点出发，经过父=&gt;子或者子=&gt;父的连接，达到任意节点的序列。
</div>
<div>
	注意:
</div>
<div>
	1.同一个节点在一条二叉树路径里中最多出现一次
</div>
<div>
	2.一条路径至少包含一个节点，且不一定经过根节点
</div>
<div>
	<br />
</div>
<div>
	给定一个二叉树的根节点root，请你计算它的最大路径和<br />
<br />
例如：<br />
给出以下的二叉树，<br />
<img alt="" src="https://uploadfiles.nowcoder.com/images/20200807/999991351_1596786349381_11531EA9352057ACF47D25928F132E96" style="height:auto;width:201.0px;" /> <br />
最优路径是:2=&gt;1=&gt;3，或者3=&gt;1=&gt;2，最大路径和=2+1+3=6
</div>
<div>
	<br />
</div>
<div>
	数据范围：节点数满足 <img src="https://www.nowcoder.com/equation?tex=1%20%5Cle%20n%20%5Cle%2010%5E5" alt="1 \le n \le 10^5" /> ，节点上的值满足 <img src="https://www.nowcoder.com/equation?tex=%7Cval%7C%20%5Cle%201000%20" /> 
</div>
<div>
	要求：空间复杂度 <img src="https://www.nowcoder.com/equation?tex=O(1)" />，时间复杂度 <img src="https://www.nowcoder.com/equation?tex=O(n)" /> 
</div><div><br></div><div><div>Related Topics</div><div><li>树</li><li>dfs</li></div></div><br>示例:<br>输入:{1,2,3}<br>输出:6<br>