import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/design-hashmap/description/
class MyHashMap {

    private List<List<int[]>> map;
    private int hashBucketNumber = 64;

    public MyHashMap() {
        this.map = new ArrayList<>();
        // fill in with empty buckets
        for (int i = 0; i < this.hashBucketNumber; i++) {
            this.map.add(new ArrayList<>());
        }
    }

    public void put(int key, int value) {
        int hashKey = key % this.hashBucketNumber;
        List<int[]> bucket = this.map.get(hashKey);
        if (bucket != null) {
            // overwrite if exists
            for (int i = 0; i < bucket.size(); i++) {
                if (bucket.get(i)[0] == key) {
                    bucket.get(i)[1] = value;
                    // exit fast after overwrite
                    return;
                }
            }
            bucket.add(new int[] { key, value });
        }
    }

    public int get(int key) {
        int hashKey = key % this.hashBucketNumber;
        List<int[]> bucket = this.map.get(hashKey);
        if (bucket != null) {
            for (int i = 0; i < bucket.size(); i++) {
                if (bucket.get(i)[0] == key) {
                    return bucket.get(i)[1];
                }
            }
        }

        return -1;
    }

    public void remove(int key) {
        int hashKey = key % this.hashBucketNumber;
        List<int[]> bucket = this.map.get(hashKey);
        if (bucket != null) {
            for (int i = 0; i < bucket.size(); i++) {
                if (bucket.get(i)[0] == key) {
                    bucket.remove(i);
                }
            }
        }
    }
}