package ua.dp.rundot;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.dp.rundot.model.Record;
import ua.dp.rundot.service.RecordService;
import ua.dp.rundot.to.DailyStatistics;
import ua.dp.rundot.to.MonthlyStatistics;
import ua.dp.rundot.util.ConversionUtils;
import ua.dp.rundot.util.ImportUtils;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class SpringCtxTest {

    private static final Logger log = getLogger(SpringCtxTest.class);
    private static ApplicationContext ctx;
    private static RecordService service;



    @BeforeClass
    public static void initCtx() {
       ctx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml");
       service = ctx.getBean(RecordService.class);
    }

    @Test
    public void singleFileImportSaveAll() {
        service.saveAll(ImportUtils
                .fromLogFile(Paths.get("C:\\Users\\evgma\\Desktop\\folder\\SMDR.log"), ImportUtils.DEFAULT_CHARSET));
    }

    @Test
    public void singleFileImportSave() {
        ImportUtils
                .fromLogFile(Paths.get("C:\\Users\\evgma\\Desktop\\folder\\SMDR.log"), ImportUtils.DEFAULT_CHARSET)
                .forEach(service::save);
    }

    @Test
    public void folderImportSaveAll() {
        long startTime = System.currentTimeMillis();
        List<Record> records = ImportUtils.fromDirectory(Paths.get("C:\\Users\\evgma\\Desktop\\folder"), ImportUtils.DEFAULT_CHARSET);
        log.debug("Parsing time: {} ms", (System.currentTimeMillis() - startTime));
        log.debug("Records parsed: {}", records.size());
        startTime = System.currentTimeMillis();
        service.saveAll(records);
        log.debug("Storing time: {} ms", (System.currentTimeMillis() - startTime));
    }

    @Test
    public void testFilter() {
        long startTime = System.currentTimeMillis();
        List<Record> filteredRecords = service.findByCallStartBetweenAndParty1DeviceIn(
                LocalDateTime.of(2018, 07, 04, 00, 00, 00),
                LocalDateTime.of(2018, 07, 04, 23, 59, 59),
                Arrays.asList("E7560", "E7580", "E7585", "E7571",  "E7572", "E7573", "E7528", "E7582", "E7583","E7584")
        );
        log.debug("Query time for daily result: {} ms", System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
        DailyStatistics dailyStatistics = ConversionUtils.fromRecordListDaily(filteredRecords);
        log.debug("Daily statistics generating: {} ms", System.currentTimeMillis() - startTime);
        log.debug(dailyStatistics.toString());
        startTime = System.currentTimeMillis();
        filteredRecords = service.findByCallStartBetweenAndParty1DeviceIn(
                LocalDateTime.of(2018, 06, 01, 00, 00, 00),
                LocalDateTime.of(2018, 07, 30, 23, 59, 59),
                Arrays.asList("E7560", "E7580", "E7585", "E7571",  "E7572", "E7573", "E7528", "E7582", "E7583","E7584")
        );
        log.debug("Query time for monthly result: {} ms", System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
        MonthlyStatistics monthlyStatistics = ConversionUtils.fromRecordListMonthly(filteredRecords);
        log.debug("Monthly statistics generating: {} ms", System.currentTimeMillis() - startTime);
        log.debug(monthlyStatistics.toString());
    }



}
