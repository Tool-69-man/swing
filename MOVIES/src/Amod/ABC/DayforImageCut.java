package Amod.ABC;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class DayforImageCut {


    public static void main(String[] args) throws  Exception{

        }

        public DayforImageCut() throws Exception{

            // 获取屏幕尺寸
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

            // 创建需要截取的矩形区域
            Rectangle rect = new Rectangle(0, 0, screenSize.width, screenSize.height);

            // 截屏操作
            BufferedImage bufImage = new Robot().createScreenCapture(rect);

            // 保存截取的图片
            ImageIO.write(bufImage, "PNG", new File("X:\\JDBCMysql\\DayForJavaSql\\jpg\\pngIcon\\imageCut12.png"));
        }

}



