<div>
	给定一个以字符串表示的数字 num 和一个数字 k ，从 num 中移除 k 位数字，使得剩下的数字最小。如果可以删除全部数字，则结果为 0。
</div>
<div>
	1.num仅有数字组成
</div>
<div>
	2.num是合法的数字，不含前导0
</div>
<div>
	3.删除之后的num，请去掉前导0（不算在移除次数中）
</div>
<div>
	<br />
</div>
<div>
	数据范围：num的长度满足 <img src="https://www.nowcoder.com/equation?tex=1%20%5Cle%20k%20%5Cle%20n%20%5Cle%2010%5E5%20%5C" /> ，保证 num 中仅包含 0~9 的十进制数<br />
</div><div><br></div><div><div>Related Topics</div><div><li>贪心</li><li>字符串</li><li>栈</li><li>单调栈</li></div></div><br>示例:<br>输入:"1432219",3<br>输出:"1219"
<br>