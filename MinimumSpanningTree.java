//给好的connection class，两个城市名，和一个cost。
import java.util.*; //这句话极度重要
class Connection{
    String node1;
    String node2;
    int cost;
    public Connection(String a, String b, int c){
        node1 = a;
        node2 = b;
        cost = c;
    }
}
//下面进入正题
public class City_Connections {
private static int unionNum;//这里开个全局变量，不丢人。
//这个static是题目要求的，我自己一般不写，累。
public static ArrayList<Connection> getLowCost(ArrayList<Connection> connections){
    //先把空的情形挡掉
    if (connections == null || connections.size() == 0){
        return new ArrayList<>();
    }

    ArrayList<Connection> result = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    //这里把cost小的往前排。
    Collections.sort(connections, new Comparator<Connection>() {
        @Override
        public int compare(Connection o1, Connection o2) {
            return o1.cost - o2.cost;
        }
    });

    unionNum = 0;
    for (Connection c : connections){
        String a = c.node1;
        String b = c.node2;
        //看城市是不是连过了，要是可以连，那么就在result里面加上
        if (union(map, a, b)){
            result.add(c);
        }
    }
    //这里要检查一下,是不是所有的城市都属于同一个union
    String find = connections.get(0).node1;
    int union = map.get(find);
    for (String str : map.keySet()){
        // 如果我们中出了一个叛徒，返回空表
        if (map.get(str) != union){
            return new ArrayList<>();
        }
    }
    //这里最后要求按照城市的名字排序
    Collections.sort(result, new Comparator<Connection>() {
        @Override
        public int compare(Connection o1, Connection o2) {
            if(o1.node1.equals(o2.node1)){
                return o1.node2.compareTo(o2.node2);
            }
            return o1.node1.compareTo(o2.node1);
        }
    });
    return result;
}
private static boolean union(Map<String, Integer> map, String a, String b){
    if (!map.containsKey(a) && !map.containsKey(b)){
        map.put(a, unionNum);
        map.put(b, unionNum);
        //这里用了一个新的没用过的数字
        unionNum++;
        return true;
    }
    //只有一方落单,那就加入有组织的一方
    if (map.containsKey(a) && !map.containsKey(b)){
        int aU = map.get(a);
        map.put(b, aU);
        return true;
    }
    if (!map.containsKey(a) && map.containsKey(b)){
        int bU = map.get(b);
        map.put(a, bU);
        return true;
    }
    //两个人都有团伙的情况。
    int aU = map.get(a);
    int bU = map.get(b);
    //如果是自己人,那肯定要踢掉,否则成环了
    if(aU == bU) return false;
    //把所有对方的团伙都吃进来
    for (String s : map.keySet()) {
        if (map.get(s) == bU) map.put(s, aU);
    }
    return true;
}
public static void main(String[] args) {
    ArrayList<Connection> connections = new ArrayList<>();
    //下面的图是个苯环，中间加上了几根，如果想验证空表，去掉几根线就行。
    connections.add(new Connection("A","B",6));
    connections.add(new Connection("B","C",4));
    connections.add(new Connection("C","D",5));
    connections.add(new Connection("D","E",8));
    connections.add(new Connection("E","F",2));
    connections.add(new Connection("B","F",10));
    connections.add(new Connection("E","C",9));
    connections.add(new Connection("F","C",7));
    connections.add(new Connection("B","E",3));
    connections.add(new Connection("A","F",16));
    //这里就输出一下看看结果。
    ArrayList<Connection> res = getLowCost(connections);
    for (Connection c : res){
        System.out.println(c.node1 + " -> " + c.node2 + " " + c.cost);
    }
}

/*=========================================================================================================*/


public class Connection {
        String city1;
        String city2;
        int cost;
        Connection (String city1, String city2, int cost) {
                this.city1 = city1;
                this.city2 = city2;
                this.cost = cost;
        }

        public void printConnection () {
                System.out.println("{ " + this.city1 + " , " + this.city2 + "} " + this.cost);
        }
}

public class solution {
        public static void main (String[] args) {
                Connection[] citys = new Connection[10];
                citys[0] = new Connection("A","B",6);
                citys[1] = new Connection("A","D",1);
                citys[2] = new Connection("A","E",5);
                citys[3] = new Connection("B","C",3);
                citys[4] = new Connection("B","D",5);. 1point3acres.com/bbs
                citys[5] = new Connection("C","D",6);
                citys[6] = new Connection("C","F",6);
                citys[7] = new Connection("D","F",4);
                citys[8] = new Connection("D","E",5);
                citys[9] = new Connection("E","F",2);-google 1point3acres
                ArrayList<Connection> list = new ArrayList<Connection> ();
                for (Connection temp : citys) {
                        list.add(temp);
                }

                for (Connection temp : findPath(list)){
                        temp.printConnection();
                }

        }

        public static List<Connection> findPath (List<Connection> list) {
                ArrayList<Connection> result = new ArrayList<Connection> ();
                ArrayList<String> cityTree = new ArrayList<String> ();        //to Maintain the cities have been traversed.

                while (!list.isEmpty()) {
                        //find the minimum cost to the city from cityTree among the result.
                        Connection temp = findMin(list, cityTree);. visit 1point3acres.com for more.
                        if (temp == null) {// we finished
                                break;
                        }
                        list.remove(temp);        //remove the current minimum cost from grand set
                        cityTree.add(temp.city1);
                        cityTree.add(temp.city2);
                        result.add(temp);
                }
                //override compare make it alphabet order
                Comparator<Connection> cmp = new Comparator<Connection>(){
                        public int compare(Connection c1, Connection c2) {
                                if (c1.city1.equals(c2.city1)) {
                                        return c1.city2.compareTo(c2.city2);
                                }
                                return c1.city1.compareTo(c2.city1);
                        }};
                result.sort(cmp);

                return result;
        }

        //find the minimum cost between the city we traversed and we did not traverse.
        public static Connection findMin(List<Connection> list, ArrayList<String> cityTree) {
                Connection result = null;
                int minCost = Integer.MAX_VALUE;        //minimum cost

                for (Connection con : list) {
                        if (con.cost <= minCost) {
                                //if none of the city we traversed 
                                //or the connection is connected to either city from cityTree.
                                if ((cityTree.contains(con.city1) && !cityTree.contains(con.city2)) ||
                                                cityTree.contains(con.city2) && !cityTree.contains(con.city1)) {
                                        minCost = con.cost;. visit 1point3acres.com for more.
                                        result = con;
                                }
                                if (cityTree.isEmpty()) {
                                        minCost = con.cost;
                                        result = con;
                                }
                        }
                }

                return result;
        }

}
