package ua.dp.rundot.util;

import com.sun.istack.internal.NotNull;
import org.slf4j.Logger;
import ua.dp.rundot.model.CallDirection;
import ua.dp.rundot.model.Record;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

public final class ImportUtils {

    private static final Logger log = getLogger(ImportUtils.class);

    private final static DateTimeFormatter CALL_START_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private final static DateTimeFormatter CALL_DURATION_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    public final static Charset DEFAULT_CHARSET = Charset.forName("CP1251");

    private ImportUtils() {}

    private static int parseInt(@NotNull String str) {
        return str.isEmpty() ? 0 : Integer.parseInt(str);
    }

    private static boolean parseBool(@NotNull  String str) {
        return "0".equals(str) ? false : true;
    }

    private static Record fromString(@NotNull  String string) {
        try {
            String[] values = string.split(",");
            return new Record(
                    LocalDateTime.parse(values[0], CALL_START_FORMATTER),
                    LocalTime.parse(values[1], CALL_DURATION_FORMATTER),
                    Integer.valueOf(values[2]),
                    values[3],
                    CallDirection.valueOf(values[4]),
                    values[5],
                    values[6],
                    parseInt(values[7]),
                    parseBool(values[8]),
                    Integer.parseInt(values[9]),
                    parseBool(values[10]),
                    values[11],
                    values[12],
                    values[13],
                    values[14],
                    Integer.parseInt(values[15]),
                    Integer.parseInt(values[16])
            );
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public static List<Record> fromLogFile(Path filename, Charset charset) {
        try {
            return Files
                    .lines(filename, charset)
                    .map(ImportUtils::fromString)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    public static List<Record> fromDirectory(Path pathToDirectory, Charset charset) {
        List<Record> result = new ArrayList<>();
        try {
            Files
                    .newDirectoryStream(pathToDirectory)
                    .forEach(p -> result.addAll(fromLogFile(p, charset)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
