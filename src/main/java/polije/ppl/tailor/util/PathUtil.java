package polije.ppl.tailor.util;

public class PathUtil {
    private static PathUtil pathUtil;

    static {
        pathUtil = new PathUtil();
    }

    public static String resourcePath(String name) {
         String utilPath = pathUtil.getFullPath();
         return utilPath + "../../../../" + name;
    }

    public String getFullPath() {
        return getClass().getResource("").getPath();
    }
}
