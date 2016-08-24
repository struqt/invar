package invar;

import java.util.List;
import java.util.Map;

public abstract class InvarSQL {

    static public InvarSQL Create(
        String tableName, List<String> writable, Map<String, String> fieldMap) {
        return new InvarMySQL(tableName, writable, fieldMap);
    }

    final String tableName;
    public final List<String> writable;
    final Map<String, String> fieldMap;

    public InvarSQL(
        String tableName,
        List<String> writable,
        Map<String, String> fieldMap) {

        this.tableName = tableName;
        this.writable = writable;
        this.fieldMap = fieldMap;
    }

    public abstract StringBuilder buildInsert();

    public abstract StringBuilder buildSelect(String where, String... fields);

    public abstract StringBuilder buildUpdate(String where, String... fields);
}