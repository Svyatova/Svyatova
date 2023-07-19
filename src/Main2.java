import java.util.*;


public class Main2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] masOfProducts = new String[5];
        Integer[] masOfCosts = new Integer[5];
        Integer[] masOfCounts = new Integer[5];

        int count = 0;
        TreeMap<String, TreeMap<String, Integer>> clients = null;
        while (sc.hasNext() && count < 5) {
            String s = sc.nextLine();
            if (s.equals("exit")) {
                break;
            }
            count++;

            String[] parts = s.split(" ");

            if (parts.length != 3) {
                System.out.println("Wrong number of arguments! Retry!");
                continue;
            }

            String productName = parts[0];
            Integer productCost = Integer.parseInt(parts[1]);
            Integer productCount = Integer.parseInt(parts[2]);

            try {
                productCost = Integer.parseInt(parts[1]);
                productCount = Integer.parseInt(parts[2]);
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Retry!");
                continue;
            }


            boolean productAlreadyExists = false;
            for (int i = 0; i < 5; i++) {
                if (productName.equals(masOfProducts[i])) {
                    masOfCosts[i] = productCost;
                    masOfCounts[i] += productCount;
                    productAlreadyExists = true;
                }
            }
            if (!productAlreadyExists) {
                for (int i = 0; i < 5; i++) {
                    if (masOfProducts[i] == null) {
                        masOfProducts[i] = productName;
                        masOfCosts[i] = productCost;
                        masOfCounts[i] = productCount;
                    }
                }
            }

            clients = new
                    TreeMap<String, TreeMap<String, Integer>>();

            if (!clients.containsKey(productName))
                clients.put(productName, new TreeMap<String, Integer>());

            TreeMap<String, Integer> temp = clients.get(productName);

            if (!temp.containsKey(productName))
                temp.put(productName, 0);

            Integer oldCount = temp.get(productName);
            temp.put(productName, oldCount + count);
        }

        TreeMap<String, Integer> value = null;
        for (Map.Entry<String, TreeMap<String, Integer>> entry :
                clients.entrySet()) {
            String key = entry.getKey();
            value = entry.getValue();
            System.out.println(key + ":");
        }

        for (Map.Entry<String, Integer> product : value.entrySet()) {
            String keyProduct = product.getKey();
            Integer valueProduct = product.getValue();
            System.out.println(keyProduct + " " + valueProduct);
        }

        String[] sortedProducts = new String[5];
        System.arraycopy(masOfProducts, 0, sortedProducts, 0, 5);

        Arrays.sort(sortedProducts, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int res = String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
                if (res == 0) {
                    res = o1.compareTo(o2);
                }
                return res;
            }
        });

        System.out.println(Arrays.toString(sortedProducts));

        long sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += masOfCosts[i] * masOfCounts[i];
        }
        System.out.println(sum);

        int indexOfMostPopularProduct = 0;
        for (int i = 0; i < 5; i++) {
            if (masOfCounts[i] > masOfCounts[indexOfMostPopularProduct]) {
                indexOfMostPopularProduct = i;
            }
        }

        System.out.println("Most popular product is " + masOfProducts[indexOfMostPopularProduct]);
        masOfProducts[indexOfMostPopularProduct] = null;
        masOfCounts[indexOfMostPopularProduct] = 0;
        masOfCosts[indexOfMostPopularProduct] = 0;


        for (int j = 0; j < 3; j++) {
            indexOfMostPopularProduct = 0;
            for (int i = 0; i < 5; i++) {
                if (masOfCounts[i] >
                        masOfCounts[indexOfMostPopularProduct]) {
                    indexOfMostPopularProduct = i;
                }
            }
            System.out.println("Most popular product is " +
                    masOfProducts[indexOfMostPopularProduct]);
            masOfProducts[indexOfMostPopularProduct] = null;
            masOfCounts[indexOfMostPopularProduct] = 0;
            masOfCosts[indexOfMostPopularProduct] = 0;
        }
    }
}

