package com.sonichollow.forum.util;

import org.springframework.util.Base64Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Captcha {

    public static Map<String, String> product() {
        int width = 160;
        int height = 60;
        int lines = 10;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = img.getGraphics();
        // 设置背景色
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        // 设置字体
        g.setFont(new Font("cmr10", Font.BOLD, (int) (height / 1.2)));
        // 随机数字
        Random r = new Random(System.currentTimeMillis());
        String code = "";
        for (int i = 0; i < 4; i++) {
            int a = r.nextInt(10);
            Color c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
            g.setColor(c);
            g.drawString("" + a, 5 + i * width / 4, (int) (height / 1.3) + r.nextInt(height / 8));
            code = code + a;
        }
        // 干扰线
        for (int i = 0; i < lines; i++) {
            Color c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
            g.setColor(c);
            g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
        }
        g.dispose();// 类似于流中的close()带动flush()---把数据刷到img对象当中
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Map<String, String> map = new HashMap<>(2);
        try {
            ImageIO.write(img, "jpg", outputStream);
            byte[] base64Img = Base64Utils.encode(outputStream.toByteArray());
            map.put("code", code);
            map.put("base64Str", "data:image/jpeg;base64," + new String(base64Img).replaceAll("\n", ""));
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
