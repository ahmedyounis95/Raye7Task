package raye7.ayounis.com.raye7task.utils;


/**
 * Created by Ahmed Younis on 11/26/2018.
 */
public final class AppConstants {

    public static final String STATUS_CODE_SUCCESS = "success";
    public static final String STATUS_CODE_FAILED = "failed";

    public static final int API_STATUS_CODE_LOCAL_ERROR = 0;

    public final static String BASE_URLS = "https://newsapi.org/" ;

    public static final String DB_NAME = "raye7.db";
    public static final String ARTICLES_TABLE_NAME = "article";

    public static final String PREF_NAME = "raye7_pref";

    public static final long NULL_INDEX = -1L;

    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";

    private AppConstants() {
        // This utility class is not publicly instantiable
    }
}
