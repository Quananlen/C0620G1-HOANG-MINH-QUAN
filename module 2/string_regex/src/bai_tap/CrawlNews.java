package bai_tap;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlNews {
    public static final String TITLE_REGEX = "<h3 class=\"title-news\"><a href=\"(.*?)\" title=\"(\\w.*?)\"";

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://vnexpress.net/");
        Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
        scanner.useDelimiter("\\Z");
        String content = scanner.next();
        scanner.close();
        content = content.replaceAll("\\n+", "");
        Pattern pattern = Pattern.compile(TITLE_REGEX);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(2));
        }
    }
}
