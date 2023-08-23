package square_trade;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


class Solution {

    private static final int ID = 0;
    private static final int NAME = 1;
    private static final int KEY_WORD = 2;
    private static final int PARENT = 3;

    public static void main( String args[] ) {
        Solution solution = new Solution();
        String[] answer = solution.solution(3);
        for (String ans : answer) {
            System.out.println(ans);
        }   
    }
    
    public String[] solution(int categoryId) {

        // Could be Statics
        CategoryFactory categoryFactory = new CategoryFactory();
        CategoryRepository categoryRepository = new CategoryRepository();

        // convert the object matrix to hashmap to increase the performance
        Map<Integer, Category> categoryMap = categoryFactory.toMap(categoryRepository.getAllCategories());
        Category category = categoryMap.get(categoryId);
        String[] keyWords = getKeyWords(categoryId, categoryMap);
        List<String> solution = new ArrayList<>();
        solution.add(category.getParentIdAsString());
        solution.addAll(Arrays.asList(keyWords));
        return solution.toArray(new String[0]);
    }

    public String[] getKeyWords(int categoryId, Map<Integer, Category> categoryMap) {
        int parentCategoryId = categoryMap.get(categoryId).getParentId();
        
        String keyWords = categoryMap.get(categoryId).getKeyWords();
        // in case there is no keywords then recursive approach was chosen
        if(Objects.isNull(keyWords) || keyWords.isBlank()) {
            return getKeyWords(parentCategoryId, categoryMap);
        }

        return keyWords.split(", ");
    }

    // Inner Class
    public class Category {
        private int id;
        private String name;
        private String keyWords;
        private int parentId;

        public Category(int id, String name, String keyWords, int parentId) {
            this.id = id;
            this.name = name;
            this.keyWords = keyWords;
            this.parentId = parentId;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public String getKeyWords() { return keyWords; }
        public int getParentId() { return parentId == -1 ? 0 : parentId; }
        public String getParentIdAsString() { return String.valueOf(getParentId()); }
    }

    // Inner Class
    public class CategoryFactory {

        public Map<Integer, Category> toMap(Object[][] data) {
            Map<Integer, Category> categoryMap = new HashMap<>();
            Arrays.stream(data)
                .forEach(row -> {
                    int id = (int) row[ID];
                    String name = (String) row[NAME];
                    String keyWords = (String) row[KEY_WORD];
                    int parent = (int) row[PARENT];
                    Category category = new Category(id, name, keyWords, parent);
                    categoryMap.put(id, category);
                });
            return categoryMap;
        }
    }

    // Inner Class
    public class CategoryRepository {

        public Object[][] getAllCategories() {
            // data structure O(nˆ2)
            Object[][] data = {
                {1, "Root", "Products", -1},
                {2, "Furniture", "Furniture", 1},
                {3, "Electronics", "Electronics, Gadgets", 1},
                {4, "Home Appliances", "Home, Appliances", 1},
                {5, "Major Appliances", "", 4},
                {6, "Minor Appliances", "", 4},
                {7, "Lawn & Garden", "Lawn, Garden", 4},
                {8, "Kitchen Appliances", "", 5},
                {9, "General Appliances", "", 5}
            };
            return data;
        }
    }
}







