<div>  给定一个长度为 n 的正整数数组 nums ，返回所有距离对中第 k 小的距离。 </div> <div>  距离对定位为：两个数组下标 i , j 的差值的绝对值称为距离 <img src="https://www.nowcoder.com/equation?tex=%7Cnums_i-nums-j%7C%20%5C">  </div> <div>  <br> </div> <div>  数据范围： <img src="https://www.nowcoder.com/equation?tex=2%20%5Cle%20n%20%5Cle%2010%5E4%20%5C"> ， <img src="https://www.nowcoder.com/equation?tex=1%20%5Cle%20nums_i%20%5Cle%2010%5E6%20%5C"> ， <img src="https://www.nowcoder.com/equation?tex=1%20%5Cle%20k%20%5Cle%20n%5Ctimes(n-1)%2F2%20%5C">  </div><div><br></div><div><div>Related Topics</div><div><li>二分</li><li>排序</li><li>双指针</li></div></div><br>示例:<br>输入:[1,3,1,5],1<br>输出:0
<br>