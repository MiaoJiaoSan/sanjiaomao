package xyz.sanjiaomao.shared.http;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpRequest;

import java.io.BufferedOutputStream;
import java.io.IOException;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-13 19:19
 */
public class HttpUtils {


  public static void main(String[] args) throws IOException {

    BufferedOutputStream outputStream =
        FileUtil.getOutputStream("C:\\Users\\lpfnw\\Desktop\\3.mp4");
//    for (long i = 0, j = 52254; i < 311627853 && j <= 311627853; i = j+1, j = (j + 52254)>=311627853?311627853:j + 52254) {
    byte[] bytes = HttpRequest.get("https://ev.phncdn.com/videos/201702/18/106620102/720P_1500K_106620102.mp4?validfrom=1613290691&validto=1613297891&rate=500k&burst=1400k&ip=8.210.235.39&hash=lAKHjzewT9r7FT%2Bw325Kz4zduQo%3D")
        .header("authority", "e1v-h.phncdn.com")
        .header("method", "GET")
        .header("path", "/videos/201702/18/106620102/720P_1500K_106620102.mp4?validfrom=1613290691&validto=1613297891&rate=500k&burst=1400k&ip=8.210.235.39&hash=lAKHjzewT9r7FT%2Bw325Kz4zduQo%3D")
        .header("scheme", "https")
        .header("accept", "*/*")
        .header("accept-encoding", "gzip, deflate, br")
        .header("accept-language", "zh-CN,zh;q=0.9,zh-TW;q=0.8,en-US;q=0.7,en;q=0.6")
        .header("cache-control", "no-cache")
        .header("origin", "https://ev.pornhub.com")
        .header("pragma", "no-cache")
//          .header("range", "bytes=0-130313475")
        .header("referer", "https://ev.pornhub.com/")
        .header("sec-fetch-dest", "empty")
        .header("sec-fetch-mode", "cors")
        .header("sec-fetch-site", "cross-site")
        .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.150 Safari/537.36")
//          .cookie("d_uidb=c4235d91-eab4-4ac0-8fd6-cd22e0d9c03e;cookietest=1")
        .execute().bodyBytes();
    outputStream.write(bytes);
    outputStream.close();
  }
}


