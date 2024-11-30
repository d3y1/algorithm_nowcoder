<div>  给定一个字符串数组，再给定整数 k ，请返回出现次数前k名的字符串和对应的次数。 </div> <div>  返回的答案应该按字符串出现频率由高到低排序。如果不同的字符串有相同出现频率，按字典序排序。 </div> <div>  对于两个字符串，大小关系取决于两个字符串从左到右第一个不同字符的 ASCII 值的大小关系。 </div> <div>  比如&quot;ah1x&quot;小于&quot;ahb&quot;，&quot;231&quot;&lt;”32“<br> </div> <div>  字符仅包含数字和字母 </div> <div>  <br> </div> <div>  数据范围：字符串数满足 <img src="https://www.nowcoder.com/equation?tex=0%20%5Cle%20n%20%5Cle%20100000">，每个字符串长度 <img src="https://www.nowcoder.com/equation?tex=0%20%5Cle%20n%20%5Cle%2010">，<img src="https://www.nowcoder.com/equation?tex=0%20%5Cle%20k%20%5Cle%202500"><br>  <div>   要求：空间复杂度 <img src="https://www.nowcoder.com/equation?tex=O(n)">，时间复杂度<img src="https://www.nowcoder.com/equation?tex=O(n%20%5Clog%20k)">   </div> <br> </div> <div> </div><div><br></div><div><div>Related Topics</div><div><li>哈希</li></div></div><br>示例:<br>输入:["a","b","c","b"],2<br>输出:[["b","2"],["a","1"]]
<br>