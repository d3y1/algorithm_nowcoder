<div>
	<span>给定一个无序数组 arr , 其中元素可正、可负、可0。给定一个整数 k ，求 arr 所有连续子数组中累加和为k的最长连续子数组长度。</span>保证至少存在一个合法的连续子数组。
</div>
<div>
	[1,2,3]的连续子数组有[1,2]，[2,3]，[1,2,3] ，但是[1,3]不是
</div>
<div>
	<br />
</div>
<div>
	数据范围： <img src="https://www.nowcoder.com/equation?tex=1%20%5Cle%20n%20%5Cle%2010%5E5" alt="1 \le n \le 10^5" />，<img src="https://www.nowcoder.com/equation?tex=%7Cval%7C%20%5Cle%20100" /><span>，<img src="https://www.nowcoder.com/equation?tex=%7Ck%7C%20%5Cle%2010%5E9" /></span><br />
要求：空间复杂度 <img src="https://www.nowcoder.com/equation?tex=O(n)" /> ， 时间复杂度 <img src="https://www.nowcoder.com/equation?tex=O(n)" /><br />
</div><div><br></div><div><div>Related Topics</div><div><li>哈希</li></div></div><br>示例:<br>输入:[1,-2,1,1,1],0<br>输出:3<br>