import java.util.*;
class Solution {
    public static class Truck implements Comparable<Truck> {
        int weight;
        int enterTime;

        Truck(int weight, int enterTime) {
            this.weight = weight;
            this.enterTime = enterTime;
        }

        @Override
        public String toString() {
            return "[" + weight + ", " + enterTime + "]";
        }

        @Override
        public int compareTo(Truck o) {
            return Integer.compare(this.enterTime, o.enterTime);
        }
    }


    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> truckQ = new ArrayDeque<>();
        Queue<Truck> bridgeQ = new PriorityQueue<>();


        for (int truck : truck_weights){
            truckQ.add(truck);
        }

        int time = 0;
        bridgeQ.add(new Truck(truckQ.poll(), time++));

        int sumW = bridgeQ.peek().weight;
        while (!bridgeQ.isEmpty() || !truckQ.isEmpty()){

            if (time - bridgeQ.peek().enterTime >= bridge_length){
                Truck tr = bridgeQ.poll();
                sumW -= tr.weight;
            }

            if (!truckQ.isEmpty()) {
                if (weight >= sumW + truckQ.peek() && bridgeQ.size() <= bridge_length) {
                    int t = truckQ.poll();
                    bridgeQ.add(new Truck(t, time));
                    sumW += t;
                }
            }
            time++;
        }

        return time;
    }
}