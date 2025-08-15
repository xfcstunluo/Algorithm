package HUAWEI25;

import java.util.*;
public class HUAWEI041602 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //地铁线路个数
        int n = sc.nextInt();
        sc.nextLine();
        //站点到线路的映射
        //A B C D F
        //C E G H
        //<C,<0,1>>
        Map<String,Set<Integer>> stationToLines = new HashMap<>();
        List<List<String>> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] stations = sc.nextLine().split(" ");
            List<String> lineStations=new ArrayList<>(Arrays.asList(stations));
            lines.add(lineStations);
            for(String station:lineStations){
                stationToLines.computeIfAbsent(station,k->new HashSet<>()).add(i);
            }
        }
        String[] query=sc.nextLine().split(" ");
        String start=query[0];
        String end=query[1];
        final int INF=1000000000;
        //站的最小换乘次数
        Map<String,Integer> dist=new HashMap<>();
        for(String station:stationToLines.keySet()) dist.put(station,INF);
        Map<String,String> parent=new HashMap<>();
        Deque<State> q=new ArrayDeque<>();
        dist.put(start,0);
        parent.put(start,null);
        q.offerFirst(new State(start,-1));
        boolean found=false;
        while(!q.isEmpty()){
            State cur=q.pollFirst();
            String curStation=cur.station;
            //进入当前站所处的上一条线
            int lastLine=cur.line;
            if(curStation.equals(end)){
                found=true;
                break;
            }
            for(int line:stationToLines.getOrDefault(curStation,Collections.emptySet())){
                List<String> lineStation=lines.get(line);
                int index=lineStation.indexOf(curStation);
                for(int i=index-1;i>=0;i--){
                    String nextStation=lineStation.get(i);
                    int cost=(lastLine==line||lastLine==-1)?0:1;
                    //新的换乘次数
                    int nextDist=dist.get(curStation)+cost;
                    if(nextDist<dist.get(nextStation)){
                        dist.put(nextStation,nextDist);
                        parent.put(nextStation,curStation);
                        if(cost==0) q.offerFirst(new State(nextStation,line));
                        else q.offerLast(new State(nextStation,line));
                    }
                }
                for(int i=index+1;i<lineStation.size();i++){
                    String nextStation=lineStation.get(i);
                    int cost=(lastLine==line||lastLine==-1)?0:1;
                    int nextDist=dist.get(curStation)+cost;
                    if(nextDist<dist.get(nextStation)){
                        dist.put(nextStation,nextDist);
                        parent.put(nextStation,curStation);
                        if(cost==0) q.offerFirst(new State(nextStation,line));
                        else q.offerLast(new State(nextStation,line));
                    }
                }
            }
        }

        //输出：出发站-换乘站-目的站输出字符串，输出方案票价
        //无解输出NA
        if(!found) System.out.println("NA");
        else{
            //回溯路径
            List<String> path=new ArrayList<>();
            String station=end;
            while(station!=null){
                path.add(station);
                station=parent.get(station);
            }
            Collections.reverse(path);
            System.out.println(String.join("-",path));
            System.out.println(2 + dist.get(end));
        }

    }

    static class State{
        String station;
        //当前所在线路
        int line;
        public State(String station, int line) {
            this.station = station;
            this.line = line;
        }
    }
}
