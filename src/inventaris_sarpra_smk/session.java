package inventaris_sarpra_smk;


public class session {

    private static int id;
    private static String username;
    private static String password;
    private static String nama;
    private static int level;

    public static int get_id() {

        return id;

    }

    public static void set_id(int id) {

        session.id = id;

    }

    public static String get_username() {

        return username;

    }

    public static void set_username(String username) {

        session.username = username;
        
    }

    public static String get_password() {

        return password;

    }

    public static void set_password(String password) {

        session.password = password;

    }

    public static String get_nama() {

        return nama;

    }

    public static void set_nama(String nama) {

        session.nama = nama;
        
    }

    public static int get_level() {

        return level;

    }

    public static void set_level(int level) {

        session.level = level;

    }

}