package test.cases;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import test.sql.NumbersRecord;

import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestInvarSQL {
    private void print(CharSequence s) {
        System.out.print("| ");
        System.out.println(s.toString().trim());
    }

    @Test
    public void test_001_() throws IOException {
        print(NumbersRecord.SQL.getBuilder().buildInsert());
        print(NumbersRecord.SQL.getBuilder().buildUpdate(null));
        print(NumbersRecord.SQL.getBuilder().buildSelect(null, 300));
        print(NumbersRecord.SQL.getBuilder().buildSelect(null, 1, 20));
    }
}