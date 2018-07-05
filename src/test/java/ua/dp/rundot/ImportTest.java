package ua.dp.rundot;

import org.junit.Test;
import org.slf4j.Logger;
import ua.dp.rundot.model.Record;
import ua.dp.rundot.util.ImportUtils;

import java.nio.file.Paths;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class ImportTest {

    private static final Logger log = getLogger(ImportTest.class);

    @Test
    public void importFromDirectory() {
        List<Record> result = ImportUtils.fromDirectory(Paths.get("C:\\Users\\evgma\\Desktop\\folder"), ImportUtils.DEFAULT_CHARSET);
    }
}
