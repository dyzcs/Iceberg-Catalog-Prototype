package com.iceberg.catalog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnapshotArray {
    private int curSnapId;
    private final Map<Integer, List<int[]>> history;

    public SnapshotArray(int length) {
        curSnapId = 0;
        history = new HashMap<>();
    }

    public void set(int index, int val) {
        history.computeIfAbsent(index, k -> new ArrayList<>()).add(new int[]{curSnapId, val});
    }

    public int snap() {
        return curSnapId++;
    }

    public int get(int index, int snap_id) {
        if (!history.containsKey(index)) {
            return 0;
        }
        List<int[]> h = history.get(index);
        int j = search(h, snap_id);
        return j < 0 ? 0 : h.get(j)[1];
    }

    // Binary search
    // Return the largest index i that satisfies h[i][0] <= x
    // If it does not exist, return -1
    private int search(List<int[]> h, int x) {
        // (left, right)
        int left = -1;
        int right = h.size();
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (h.get(mid)[0] <= x) {
                left = mid;
            } else {
                right = mid;
            }
        }

        // According to the loop invariant, at this time h[left][0] <= x and h[left+1][0] = h[right][0] > x
        // So left is the largest subscript that satisfies h[left][0] <= x
        // If it does not exist, left is its initial value -1
        return left;
    }
}
