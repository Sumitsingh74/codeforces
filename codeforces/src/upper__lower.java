import java.util.*;

class upper__lower {
    public static void findLowerBound(
            List<Map.Entry<Integer, Integer>> list,
            Map.Entry<Integer, Integer> p)
    {
        Comparator<Map.Entry<Integer, Integer>> comp = new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                return e1.getKey().compareTo(e2.getKey());
            }
        };

        int low = Collections.binarySearch(list, p, comp);
        if (low < 0) {
            low = -(low + 1);
        }

        System.out.println("lower_bound() for {2, 5}"
                + " is at index: {"
                + list.get(low).getKey() + ", "
                + list.get(low).getValue() + " }");
    }

    public static void findUpperBound(
            List<Map.Entry<Integer, Integer>> list,
            Map.Entry<Integer, Integer> p)
    {
        Comparator<Map.Entry<Integer, Integer>> comp = new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                return e1.getKey().compareTo(e2.getKey());
            }
        };

        int up = Collections.binarySearch(list, p, comp);
        if (up < 0) {
            up = -(up + 1);
        } else {
            up++;
        }

        System.out.println("upper_bound() for {2, 5}"
                + " is at index: {"
                + list.get(up).getKey() + ", "
                + list.get(up).getValue() + " }");
    }

    public static void main(String[] args) {

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        list.add(new AbstractMap.SimpleEntry<>(1, 3));
        list.add(new AbstractMap.SimpleEntry<>(1, 7));
        list.add(new AbstractMap.SimpleEntry<>(2, 4));
        list.add(new AbstractMap.SimpleEntry<>(2, 5));
        list.add(new AbstractMap.SimpleEntry<>(3, 8));
        list.add(new AbstractMap.SimpleEntry<>(8, 6));

        Map.Entry<Integer, Integer> p = new AbstractMap.SimpleEntry<>(2, 5);

        findLowerBound(list, p);


        findUpperBound(list, p);
        System.out.println();
    }
    private static int bs_upper_bound(List<Integer> arr, int n, int x) {
        int l = 0;
        int h = n;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (x >= arr.get(mid)) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }
    private static int bs_lower_bound(List<Integer> arr, int n, int x) {
        int l = 0;
        int h = n;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (x <= arr.get(mid)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }



}
