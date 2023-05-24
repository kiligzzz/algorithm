package support;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 提取工具类
 *
 * @author Ivan
 * @since 2023/5/19
 */
public class ExtractExecution {
    /**
     * Class助手类
     */
    private static final ClassHelper CLASS_HELPER = ClassHelper.getInstance();

    public static void main(String[] args) throws Exception {
        extractByQuestion();
        extractByType();
    }

    /**
     * 依据题目提取
     */
    private static void extractByQuestion() throws IOException {
        // 题目 -> 注释
        Map<String, String> questionToCommentMap = FileUtil.listFiles(
                "src/main/java/easy", "src/main/java/medium")
                .stream()
                .collect(Collectors.toMap(
                        file -> file.getName().replace(".java", ""),
                        file -> {
                            try {
                                List<String> lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
                                return lines.get(lines.indexOf("/**") + 1).substring(3);
                            } catch (Exception ignore) {
                            }
                            return "";
                        }
                ));

        List<String> byQuestion = CLASS_HELPER.loadClasses("easy", "medium")
                .stream()
                .filter(clazz -> !clazz.getName().contains("$"))
                .map(clazz -> {
                    // 题目
                    String question = clazz.getSimpleName();
                    // 类型集
                    String types = Arrays.stream(clazz.getInterfaces())
                            .map(Class::getName)
                            .map(typeName -> typeName.replace("type.", ""))
                            .collect(Collectors.joining(", ", "[", "]"))
                            .replace("$", ".");
                    return question + " (" + questionToCommentMap.get(question) + ") -> " + types;
                })
                .sorted()
                .collect(Collectors.toList());

        Files.write(Paths.get("extract/byQuestion.txt"), byQuestion);
    }

    /**
     * 依据类型提取
     */
    private static void extractByType() throws Exception {
        List<String> byType = CLASS_HELPER.loadClasses("type")
                .stream()
                .map(clazz -> {
                    // 类型
                    String type = clazz.getName().replace("type.", "");
                    // 题目
                    String question = CLASS_HELPER.getImplClasses(clazz)
                            .stream()
                            .map(Class::getSimpleName)
                            .sorted()
                            .collect(Collectors.joining(",", "[", "]"));
                    return type + " -> " + question;
                })
                .sorted()
                .map(line -> !line.contains("$") ? "\n" + line : line)
                .map(line -> line.replace("$", "."))
                .collect(Collectors.toList());
        // 去除首个换行
        byType.set(0, byType.get(0).substring(1));
        Files.write(Paths.get("extract/byType.txt"), byType);
    }
}
