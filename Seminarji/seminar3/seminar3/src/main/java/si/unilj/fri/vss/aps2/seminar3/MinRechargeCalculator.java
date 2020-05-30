package si.unilj.fri.vss.aps2.seminar3;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public final class MinRechargeCalculator {
    public static int calculate(Trip trip) {
        return minChargeTimes(trip.stops, trip.time, trip.initialCharge);
    }

    public static int minChargeTimes(List<Stop> stops, int tripLength, int currentCharge) {
        PriorityQueue<Integer> heap = new PriorityQueue(Collections.reverseOrder());
        int previousStopLength = 0;
        int chargesCounter = 0;

        for (Stop stop : stops) {
            int stopCharge = stop.batteryRecharge;
            int stopLength = stop.time;

            currentCharge -= stopLength - previousStopLength;
            while (currentCharge < 0 && !heap.isEmpty()) {
                // go back
                currentCharge += heap.poll();
                chargesCounter++;
            }

            if (currentCharge < 0) {
                return -1;
            }

            previousStopLength = stopLength;
            heap.offer(stopCharge);

        }

        // take care of the last stop
        currentCharge -= tripLength - previousStopLength;
        while (currentCharge < 0 && !heap.isEmpty()) {
            chargesCounter++;
            currentCharge += heap.poll();

        }

        if (currentCharge < 0) {
            return -1;
        }


        return chargesCounter;
    }
}
