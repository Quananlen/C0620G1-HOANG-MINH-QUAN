import java.util.TreeMap;

public class bai_2 {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        System.out.println(order(tree, 2, 0, 0));
        System.out.println(order(tree, 1, 20, 14));
        System.out.println(order(tree, 1, 30, 3));
        System.out.println(order(tree, 2, 0, 0));
        System.out.println(order(tree, 1, 10, 99));
        System.out.println(order(tree, 3, 0, 0));
        System.out.println(order(tree, 2, 0, 0));
        System.out.println(order(tree, 2, 0, 0));
        System.out.println(order(tree, 0, 0, 0));
    }

    public static String order(TreeMap<Integer, Integer> tree, int choice, int id, int order) {
        String result;
        switch (choice) {
            case 1:
                tree.put(order, id);
                result = "Guest " + id + " add to queue";
                break;
            case 2:
                if (!tree.isEmpty()) {
                    result = "Serve first guest: " + tree.firstEntry().getValue();
                    tree.remove(tree.firstKey());
                } else return "No guest in queue";
                break;
            case 3:
                if (!tree.isEmpty()) {
                    result = "Serve last guest: "+ tree.lastEntry().getValue();
                    tree.remove(tree.lastKey());
                } else return "No guest in queue";
                break;
            default:
                return "0";
        }
        return result;
    }
}
