Find maximum possible stolen value from houses
There are n houses build in a line,
 each of which contains some value in it.
  A thief is going to steal the maximal value of these houses,
   but he can’t steal in two adjacent houses because
    owner of the stolen houses will tell his two neighbour left and right side.

     What is the maximum stolen value.



While reaching house i thief has two options,
 either he robs it or leave it. Let dp[i] represents the maximum value stolen so far on reaching house i.
  We can calculate the value of dp[i] as following –

dp[i] = max (hval[i] + dp[i-2], dp[i-1])

hval[i] + dp[i-2] is the case when thief
decided to rob house i. In that situation
maximum value will be the current value of
house + maximum value stolen till last
robbery at house not adjacent to house
i which will be house i-2.

dp[i-1] is the case when thief decided not
to rob house i. So he will check adjacent
house for maximum value stolen till now.
Thief will consider both options and decide whether to rob or not and
 maximum of both values will be the maximum stolen value till reaching house i.

