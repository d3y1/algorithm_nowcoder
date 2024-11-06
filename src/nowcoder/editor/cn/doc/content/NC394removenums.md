<div>  给定一个长度为 n 的有序数组 nums， 请你原地删除重复出现超过三次的元素，使每个元素出现最多两次，返回删除后新数组的长度 m ，你必须原地修改nums数组才能通过本题。 </div> <div>  <div>   系统会如下来测试你的代码:  </div>  <div> <pre class="prettyprint lang-c">int[] rightNums = [...]; // 长度正确的答案
int m = removenums(nums); // 调用

assert m == rightNums.length;
for (int i = 0; i &lt; m; i++) {
    assert nums[i] == rightNums[i];
}</pre>  </div>  <div>   如果所有断言都能通过，那么你的程序会被视为正确  </div> <br> </div> <div>  <br> </div> <div>  数据范围： <img src="https://www.nowcoder.com/equation?tex=1%20%5Cle%20n%20%5Cle%2010%5E5%20%5C"> ，数组中的元素满足 <img src="https://www.nowcoder.com/equation?tex=1%20%5Cle%20nums_i%20%5Cle%2010%5E5%20%5C"><br> </div><div><br></div><div><div>Related Topics</div><div><li>双指针</li></div></div><br>示例:<br>输入:[1,1,2,2,3]<br>输出:5
[1,1,2,2,3]
<br>