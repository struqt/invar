package test.cases;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import test.sql.SimpleRecord;

import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestInvarSQL {
    private void print(CharSequence s) {
        System.out.print("| ");
        System.out.println(s.toString().trim());
    }

    @Test
    public void test_001_() throws IOException {
        print(SimpleRecord.SQL.getBuilder().buildInsert());
        print(SimpleRecord.SQL.getBuilder().buildUpdate(null));
        print(SimpleRecord.SQL.getBuilder().buildSelect(null, 300));
        print(SimpleRecord.SQL.getBuilder().buildSelect(null, 1, 20));
    }
}