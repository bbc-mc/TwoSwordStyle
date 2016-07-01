package bbc_mc.TwoSwordStyle.core;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.Arrays;
import java.util.List;

/**
 @author bbc_mc
 @date 2016/06/19 */
public class ConfigsCore {
    public static boolean isDebugMode;
    public static boolean enableInitMainHandKey;

    // 二刀を発動するアイテムのグループ
    public static List<String> twoSwordStyleGroup1;
    public static List<String> twoSwordStyleGroup2;
    public static List<String> twoSwordStyleGroup3;
    public static List<String> twoSwordStyleGroup4;
    public static List<String> twoSwordStyleGroup5;
    public static List<String> twoSwordStyleGroup6;

    public static void configure(FMLPreInitializationEvent event) {
        Configuration conf = new Configuration(event.getSuggestedConfigurationFile());
        try {
            // 設定読出し
            conf.load();

            isDebugMode = conf.getBoolean("debugMode", "system", false, "B:isDebugMode");
            enableInitMainHandKey = conf.getBoolean("enableInitMainHandKey", "system", true, "B");

            twoSwordStyleGroup1 = Arrays.asList((conf.getString("twoSwordStyleGroup1", "mod", "wooden_sword,stone_sword,iron_sword,golden_sword,diamond_sword", "")).split(",", 0));
            twoSwordStyleGroup2 = Arrays.asList((conf.getString("twoSwordStyleGroup2", "mod", "wooden_axe,stone_axe,iron_axe,golden_axe,diamond_axe", "")).split(",", 0));
            twoSwordStyleGroup3 = Arrays.asList((conf.getString("twoSwordStyleGroup3", "mod", "wooden_hoe,stone_hoe,iron_hoe,golden_hoe,diamond_hoe", "")).split(",", 0));
            twoSwordStyleGroup4 = Arrays.asList((conf.getString("twoSwordStyleGroup4", "mod", "stick", "")).split(",", 0));
            twoSwordStyleGroup5 = Arrays.asList((conf.getString("twoSwordStyleGroup5", "mod", "snowball", "")).split(",", 0));
            twoSwordStyleGroup6 = Arrays.asList((conf.getString("twoSwordStyleGroup6", "mod", "", "")).split(",", 0));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conf.hasChanged()) {
                conf.save();
            }
        }
    }
}
