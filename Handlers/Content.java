package Handlers;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Content {
    public static BufferedImage[][] EnergyParticle = load("/Sprites/Player/EnergyParticle.gif", 5, 5);
    //public static BufferedImage[][] EnergyParticleSet2 = load("/Sprites/Player/EnergyParticle2.gif", 5, 5);
    public static BufferedImage[][] Explosion = load("/Sprites/Enemies/Explosion.gif", 30, 30);
    //public static BufferedImage[][] ExplosionSet2 = load("/Sprites/Enemies/Explosion2.gif", 30, 30);
    public static BufferedImage[][] Gazer = load("/Sprites/Enemies/Gazer.gif", 39, 20);
    //public static BufferedImage[][] GazerSet2 = load("/Sprites/Enemies/Gazer2.gif", 39, 20);
    public static BufferedImage[][] Tengu = load("/Sprites/Enemies/Tengu.gif", 30, 30);
    //public static BufferedImage[][] TenguSet2 = load("/Sprites/Enemies/Tengu2.gif", 30, 30);
    public static BufferedImage[][] GelPop1 = load("/Sprites/Enemies/GelPop.gif", 25, 25);
    public static BufferedImage[][] GelPop2 = load("/Sprites/Enemies/GelPop2.gif", 25, 25);
    public static BufferedImage[][] DarkEnergy = load("/Sprites/Enemies/DarkEnergy.gif", 20, 20);
    //public static BufferedImage[][] DarkEnergySet2 = load("/Sprites/Enemies/DarkEnergy2.gif", 20, 20);

    public static BufferedImage[][] load(String s, int w, int h) {
        BufferedImage[][] ret;
        try {
            BufferedImage spritesheet = ImageIO.read(Content.class.getResourceAsStream(s));
            int width = spritesheet.getWidth() / w;
            int height = spritesheet.getHeight() / h;
            ret = new BufferedImage[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    ret[i][j] = spritesheet.getSubimage(j * w, i * h, w, h);
                }
            }
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading graphics.");
            System.exit(0);
        }
        return null;
    }
}
