package kz.kakimzhanova.composite.util;

public class IdGenerator {
    private static long leafId = 0;
    private static long compositeId = 0;
    private static long parserId = 0;

    public static long generateLeafId(){
        return leafId++;
    }
    public static long generateCompositeId(){
        return compositeId++;
    }
    public static long generateParserId(){
        return parserId++;
    }
}
