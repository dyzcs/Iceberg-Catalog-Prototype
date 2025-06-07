package com.iceberg;

import com.iceberg.catalog.SnapshotArray;

public class Main {
    public static void main(String[] args) {
        SnapshotArray obj = new SnapshotArray(10);
        obj.set(1, 2);
        int param_2 = obj.snap();
        System.out.println(param_2);
        int param_3 = obj.get(1, 2);
        System.out.println(param_3);
    }
}
