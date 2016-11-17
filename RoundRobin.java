/*
一个处理器要处理一堆request，一次只能处理一条，每次执行一个任务最多执行时间q，接着执行等待着的下一个任务。
若前一个任务没执行完则放到队尾，等待下一次执行。

假设只要有任务开始以后cpu是不会空闲的，也就是说cpu开始后如果空闲了就说明没有任务了，另外Robin Round最后返回值是float。

OA 示例：
例子： 【0，1，4】 【5，2，3】 q=3. 输出的是average wait time 2.3333333
第0秒，任务1进队列。我们peek目前队列中有的任务是任务1，我们发现任务1开始时间第0秒，目前也是第0秒，所以任务1等待时间是0。
然后任务1执行3秒，它自身还有2秒钟。
这时候我们查看3秒的时候哪些任务达到了，发现任务2在第1秒到达。于是任务2进队列。
这时候我们查看任务1有没有执行完，发现没有执行完，于是我们poll任务1，再把任务1 add到队列末尾。
这时候队列的顺序是任务2，任务1.

现在我们再次peek队列，于是找到任务2.我们发现任务2在第1秒到达了，目前我们在第3秒。所以等待时间是3-1=2.
我们重复刚刚的步骤，发现任务2执行时间只要2秒，于是我们到第5秒。这时候我们查找第5秒哪些任务到达了。我们发现任务3也到达了。于是任务3进队列。
所以目前队列顺序是任务2，任务1，任务3.
我们又发现任务2已经执行完了，于是我们把任务2 poll出队列，不再把它放进队列里了。
所以现在队列里面剩余的任务是任务1，任务3.

于是我们再peek队列。请注意，这时候的q被重新设置过了，不是3－2=1秒，而是又是3秒。
我们再次peek队列，找到任务1，目前是在第5秒，我们刚刚执行过任务1，他暂停在第3秒，所以任务1又等了2秒。目前秒数是2+2=4秒。
目前任务1还有2秒。我们执行完任务1以后，到达第5+2 ＝ 7把他扔出队列。目前队列里只有任务3了。

然后我们再peek，现在只有任务3了，目前我们在第7秒。任务3进来的时候在第4秒。所以任务3等了7-4 ＝ 3秒。所以等待时间又加3秒。
所以最终等待时间是2+2+3 ＝ 7秒。平均等待时间是7/3 ＝ 2.3333秒。
*/


import java.util.LinkedList;
import java.util.Queue;

class process {
    int arrTime;
    int exeTime;
    process(int arr, int exe) {
        arrTime = arr;
        exeTime = exe;
    }
}

public class RoundRobinScheduling {
    public float Solution(int[] Atime, int[] Etime, int q) {
        // Corner case
        if (Atime == null || Etime == null || Atime.length != Etime.length)
            return 0;
        int length = Atime.length;
        Queue<process> queue = new LinkedList<process>();
        int curTime = 0, waitTime = 0;
        int index = 0;
        while (!queue.isEmpty() || index < length) {
            if (!queue.isEmpty()) {
                process cur = queue.poll();
                waitTime += curTime - cur.arrTime;
                curTime += Math.min(cur.exeTime, q);
                for (; index < length && Atime[index] <= curTime; index++)
                    queue.offer(new process(Atime[index], Etime[index]));
                if (cur.exeTime > q)
                    queue.offer(new process(curTime, cur.exeTime - q));
            }
            else {
                queue.offer(new process(Atime[index], Etime[index]));
                curTime = Atime[index++];
            }
        }
        return (float) waitTime / length;
    }
}

/*-------------------另一版本------------------------------------------------------------------------------*/

public classRoundRobinScheduling {
         public static float Solution(int[] Atime, int[] Etime, int q) {
              if(Atime == null || Etime ==null ||Atime.length <= 1 ||Etime.length <= 1 ||Atime.length != Etime.length) return 0;
              int len =Atime.length;
              // usequeue data structure to store every process
              Queue<Process> processList =newLinkedList<Process>();  
              // crtTimeis total time from 0 till now, waitTime is total waiting time
              int crtTime =Atime[0], waitTime= 0;   
              // addfirst process into the list
              processList.add(newProcess(Atime[0], Etime[0]));
              // indexof all original process              
              int index = 1;   
              while(!processList.isEmpty()){
                     Process crtProcess =processList.poll();
                     waitTime += crtTime -crtProcess.aTime;   
                     crtTime += crtProcess.eTime< q ? crtProcess.eTime : q;     
                     for(; index< len && Atime[index] <= crtTime; ++index)   
                            processList.add(newProcess(Atime[index], Etime[index]));
                     if(crtProcess.eTime> q)   
                            processList.add(newProcess(crtTime, crtProcess.eTime - q));
              }
              return (float)waitTime /len;
         }
}

/*==================另一种理解======================================================================================*/
/*
示例输入：
request time: [0,1,3,9]
duration: [2,1,7,5]
q=3
average waiting time : 0.5

request time: [0,2,4,5]
duration: [7,4,1,4]
q=3
average waiting time : 7

即在剩下的request里选择duration小的，这样就不能用queue做了。
*/

private static double roundRobin(int[] arrivetime, int[] executiontime, int q) {  
        // TODO Auto-generated method stub  
        LinkedList<process> que = new LinkedList<process>();  
        if(arrivetime.length < 1 || executiontime.length < 1)  
            return 0;  

        int currentTime = 0;  
        int waitTime = 0;  

        int nextP = 0;  

        while(true)  
        {  
            if(!que.isEmpty())  
            {  
                process curP = que.poll();  
                waitTime += currentTime - arrivetime[nextP];  
                if(curP.excuteTime <= q)  
                {  
                    currentTime += curP.excuteTime;  
                    executiontime[nextP] = executiontime[nextP]- curP.excuteTime;  

                }  
                else  
                {  

                    currentTime+= q;  
                    arrivetime[nextP] = currentTime;  

                    executiontime[nextP] = executiontime[nextP]-q;  
                    //System.out.println(currentTime +"\t"+arrivetime[nextP]+"\t"+executiontime[nextP]);  

                }  

                que.peek();  

                int min = 1000000;  
                int count = 0;  
                //找下一个最小  
                for(int i=0; i < arrivetime.length; i++)  
                {  
                    if(arrivetime[i] <= currentTime)  
                    {  
                        if(min > executiontime[i]&& executiontime[i]>0)  
                        {  
                            min = executiontime[i];  
                            nextP = i;  
                        }  
                        if(executiontime[i]<1)  
                        {  
                            count++;  
//                          System.out.println("i:\t"+i+" :"+executiontime[i]+"\tnow count:\t"+count);  
                        }  
                    }  
                }  
                if(count==arrivetime.length)  
                {  
                    break;  
                }  

            }else  
            {  
                que.offer(new process(arrivetime[nextP],executiontime[nextP]));  
            }  
        }  

        return ((double)waitTime/arrivetime.length);  
    }
