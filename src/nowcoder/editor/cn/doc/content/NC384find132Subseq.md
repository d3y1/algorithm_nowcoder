<div>
	给定一个长度为 n 的整数数组 nums ，请问其中是否存在满足 132 排列的子序列。
</div>
<div>
	132排列<span>的子序列</span>指数组中存在 <img src="https://www.nowcoder.com/equation?tex=i%20%2C%20j%20%2Ck%20%20%5C" /> 满足 <img src="https://www.nowcoder.com/equation?tex=1%20%5Cle%20i%20%5Clt%20j%20%5Clt%20k%20%5Cle%20len(nums)%20%5C" alt="1 \le i \lt j \lt k \le len(nums) \" /> ，且 <img src="https://www.nowcoder.com/equation?tex=nums_k%20%5Clt%20nums_j%20%2C%20nums_i%20%5Clt%20nums_k%5C" alt="nums_k \lt nums_j , nums_i \lt nums_k\" /><br />
</div>
<div>
	<br />
</div>
<div>
	数据范围： <img src="https://www.nowcoder.com/equation?tex=1%20%5Cle%20n%20%5Cle%2010%5E5%20%5C" /> ，数组中的数满足 <img src="https://www.nowcoder.com/equation?tex=1%20%5Cle%20nums_i%20%5Cle%2010%5E9%20%5C" /> 
</div><div><br></div><div><div>Related Topics</div><div><li>二分</li><li>栈</li><li>单调栈</li></div></div><br>示例:<br>输入:[1,2,3,2,1]<br>输出:true
<br>