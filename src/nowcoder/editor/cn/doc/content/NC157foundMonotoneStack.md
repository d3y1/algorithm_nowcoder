<div>
	给定一个长度为&nbsp;<img src="https://www.nowcoder.com/equation?tex=n" alt="n" /> 的可能含有重复值的数组 <img src="https://www.nowcoder.com/equation?tex=nums" alt="nums" />，找到每一个<span>位置&nbsp;</span><img src="https://www.nowcoder.com/equation?tex=i" alt="i" />&nbsp;左边<span>最近的</span>位置&nbsp;<img src="https://www.nowcoder.com/equation?tex=l" alt="l" />&nbsp;和右边最近的位置 <img src="https://www.nowcoder.com/equation?tex=r" alt="r" />&nbsp;，<img src="https://www.nowcoder.com/equation?tex=nums_l" alt="nums_l" /> 和 <img src="https://www.nowcoder.com/equation?tex=nums_r" alt="nums_r" />&nbsp;比&nbsp;<img src="https://www.nowcoder.com/equation?tex=nums_i" alt="nums_i" /> 小。
</div>
<div>
	<br />
</div>
<div>
	请设计算法，返回一个二维数组，表示所有位置相应的信息。位置信息包括：两个数字 <img src="https://www.nowcoder.com/equation?tex=l" alt="l" />&nbsp;和 <img src="https://www.nowcoder.com/equation?tex=r" alt="r" />。如果不存在，则值为 -1，下标从 0 开始。
</div>
<div>
	<br />
</div>
<div>
	数据范围：<img src="https://www.nowcoder.com/equation?tex=1%20%5Cle%20n%20%5Cle%2010%5E5%20" />&nbsp;，<img src="https://www.nowcoder.com/equation?tex=-10%5E9%20%5Cle%20nums_i%20%5Cle%2010%5E9" alt="-10^9 \le nums_i \le 10^9" /> 
</div>
<div>
	进阶：空间复杂度 <img src="https://www.nowcoder.com/equation?tex=O(n)" /> ，时间复杂度 <img src="https://www.nowcoder.com/equation?tex=O(n)" /><br />
</div>
<div>
	<span></span><br />
</div><div><br></div><div><div>Related Topics</div><div><li>栈</li></div></div><br>示例:<br>输入:[3,4,1,5,6,2,7]<br>输出:[[-1,2],[0,2],[-1,-1],[2,5],[3,5],[2,-1],[5,-1]]<br>