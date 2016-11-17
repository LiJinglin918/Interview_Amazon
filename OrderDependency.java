/*    https://segmentfault.com/a/1190000007064872
必须要说即使是费了九牛二虎之力，题目的描述也不是像leetcode那样的清晰。但是这题和MST一样，都是价值108K+18K的大生意。
题目大概内容是这样的，比如赵兄托你帮我办点事，那么这个顺序就是赵兄先托你，然后你再帮我办事，事情讲究个先来后到。
输入的是一群OrderDependency的object，输出是Order的List。
类似于这样[(A, B), (A, C), (B, C)]，意思每一对里，A的生产依赖于B，B就必须得先造出来，最后让你返回顺序[C, B ,A]。
Order就是顾名思义，命令，里面就一个String类型的内容，而且这题据说test case一共就4个。
地里有人说，其实就是Leetcode 210题，只不过lc上的数据是数字，oa上的是string而已，思路做法是一样的，不过要多做一点预处理。
*/
/*
首先用脚后跟想想，这题必须是topological sorting。我个人非常偏向使用BFS，剥洋葱法。
那么就按照这个思路来想，每个order都用map记录入度，还有个map记录这个order指向多少个order。
另外再用一个set来记录出现过的order，用来判断最后是否有环。
至于map之外的数据结构，没想出来，因为order这个object不像数字可以用个数组啥的，这种也只能用map了吧。
*/

import java.util.*;
//Order和OrderDependency都是照着面经猜测，应该是给好的class。
class Order{
    String order = "";
    public Order(String string){
        this.order = string;
    }
}
class OrderDependency{
    Order cur;
    Order pre;
    public OrderDependency(Order o1, Order o2){
        cur = o1;
        pre = o2;
    }
}
public class Order_Dependency {
    //这个参数可能是数组，这里先摆个容器，反正一个意思。
    public static List<Order> getOrderList(List<OrderDependency> orderDependencies){
        List<Order> result = new ArrayList<>();
        //建两个map,第一个是当前的order指向多少个order,就是先决条件
        Map<Order, ArrayList<Order>> map = new HashMap<>();
        //第二个是当前order被多少个order指,即为入度
        Map<Order, Integer> inMap = new HashMap<>();
        //把出现过的都记录下来
        Set<Order> set = new HashSet<>();
        for (OrderDependency od : orderDependencies){
            Order cur = od.cur;
            Order pre = od.pre;
            set.add(cur);
            set.add(pre);
            //有则加一,无则设1
            if (inMap.containsKey(cur)){
                int indegree = inMap.get(cur);
                inMap.put(cur, indegree+1);
            }
            else {
                inMap.put(cur, 1);
            }
            //这里入度也要把pre加上,因为最后要找线头,就是入度为0的点。
            if (!inMap.containsKey(pre)){
                inMap.put(pre, 0);
            }

            if (map.containsKey(pre)){
                map.get(pre).add(cur);
            }
            else {
                map.put(pre, new ArrayList<>());
                map.get(pre).add(cur);
            }
            //注意这里存的时候,map可以看成出度,出度为0也要存,或者在下面判断跳过null
            if (!map.containsKey(cur)){
                map.put(cur, new ArrayList<Order>());
            }
        }

        Queue<Order> queue = new LinkedList<>();
        int total = set.size();

        for (Order od : inMap.keySet()){
            if (inMap.get(od) == 0){
                queue.offer(od);
            }
        }
        //这里使用了BFS
        while (!queue.isEmpty()){
            Order order = queue.poll();
            result.add(order);
            for (Order odr : map.get(order)){
                //这里查入度,类比剥洋葱,如果剥到了0,说明是最外层。
                inMap.put(odr, inMap.get(odr) - 1);
                if (inMap.get(odr) == 0){
                    queue.offer(odr);
                }
            }
        }
        //这里如果有环的话,肯定是剥不出来的,那么set里面的个数和result里面的个数不一致。
        if (result.size() != total) return new ArrayList<Order>();
        return result;
    }
    //测试用例
    public static void main(String[] args) {
        Order o1 = new Order("A");
        Order o2 = new Order("B");
        Order o3 = new Order("C");
        Order o4 = new Order("D");
        OrderDependency od1 = new OrderDependency(o1, o2);
        OrderDependency od2 = new OrderDependency(o2, o3);
        //成环的情况就是把o4，改成o2，看看输出。
        OrderDependency od3 = new OrderDependency(o3, o4);
        List<OrderDependency> list = new ArrayList<>();
        list.add(od1);
        list.add(od2);
        list.add(od3);

        for (Order o : getOrderList(list)){
            System.out.println(o.order);
        }
    }
}
