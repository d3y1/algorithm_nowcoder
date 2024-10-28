<div>
	所有的 DNA 序列都是由 'A' , ‘C’ , 'G' , 'T' 字符串组成的，例如 'ACTGGGC' 。
</div>
<div>
	请你实现一个函数找出所有的目标子串，目标子串的定义是，长度等于 10 ，且在 DNA 序列中出现次数超过 1 次的子串（允许两个子串有重合的部分，如下面的示例2所示）。
</div>
<div>
	（注：返回的所有目标子串的顺序必须与原DNA序列的顺序一致<span>，如下面的示例1所示</span>）
</div>
<div>
	数据范围：DNA序列长度满足 <img src="https://www.nowcoder.com/equation?tex=1%20%5Cle%20n%20%5Cle%2010%5E5%20%20%5C" /> ，保证序列中只出现 'A' , 'C' , 'G' , 'T'。<br />
</div><div><br></div><div><div>Related Topics</div><div><li>字符串</li><li>哈希</li><li>双指针</li><li>位运算</li></div></div><br>示例:<br>输入:"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"<br>输出:["AAAAACCCCC","CCCCCAAAAA"]
<br>