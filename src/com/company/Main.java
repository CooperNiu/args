package com.company;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        String inputString = "White tigers live mostly in India Wild lions live mostly in Africa";
        List<String> splitedStList;
        splitedStList = toLowerCaseAndSplit(inputString);
        removeStopWords(splitedStList);
        Map<String, Integer> frequencies = getFrequencies(splitedStList);
        Map<String, Integer> sortedMap = sortMapByValue(frequencies);
        printResult(sortedMap);
    }

    private static void printResult(Map<String, Integer> sortedMap) {
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }

    private static Map<String, Integer> getFrequencies(List<String> splitedStList) {
        Map<String, Integer> result = new HashMap<>();
        for (String s : splitedStList) {
            if (result.containsKey(s)) {
                result.put(s, result.get(s) + 1);
            } else {
                result.put(s, 1);
            }
        }
        return result;
    }

    private static List<String> toLowerCaseAndSplit(String st) {
        String lowerCaseString = st.toLowerCase();
        String[] splitedSt = lowerCaseString.split(" ");
        List<String> splitedStList = new ArrayList<>();
        splitedStList.addAll(Arrays.asList(splitedSt));
        return splitedStList;
    }

    /**
     * 使用 Map按value进行排序
     */
    public static Map<String, Integer> sortMapByValue(Map<String, Integer> oriMap) {
        if (oriMap == null || oriMap.isEmpty()) {
            return null;
        }
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(
                oriMap.entrySet());
        Collections.sort(entryList, new MapValueComparator());

        Iterator<Map.Entry<String, Integer>> iter = entryList.iterator();
        Map.Entry<String, Integer> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortedMap;
    }

    /**
     * 自定义比较器
     */
    static class MapValueComparator implements Comparator<Map.Entry<String, Integer>> {

        @Override
        public int compare(Map.Entry<String, Integer> me1, Map.Entry<String, Integer> me2) {
            return me2.getValue().compareTo(me1.getValue());
        }
    }

    static void removeStopWords(List<String> splitedStList) {
        List<String> stopWords = new ArrayList<>();
        stopWords.add("in");
        for (int i = 0; i < splitedStList.size(); i++) {
            for (String s : stopWords) {
                if (splitedStList.get(i).equals(s)) {
                    splitedStList.remove(i);
                }
            }
        }
    }

}


