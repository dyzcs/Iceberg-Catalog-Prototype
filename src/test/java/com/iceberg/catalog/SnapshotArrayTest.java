package com.iceberg.catalog;

import org.junit.jupiter.api.Test;

public class SnapshotArrayTest {
    @Test
    public void test1() {
        SnapshotArray obj = new SnapshotArray(10);
        obj.set(1, 2);
        int param_2 = obj.snap();
        System.out.println(param_2);
        int param_3 = obj.get(1, 0);
        System.out.println(param_3);
        obj.set(1, 10);
        obj.snap();
        int param_4 = obj.get(1, 1);
        System.out.println(param_4);
    }
}
