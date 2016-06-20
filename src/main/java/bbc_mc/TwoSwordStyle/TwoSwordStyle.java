package bbc_mc.TwoSwordStyle;

import bbc_mc.TwoSwordStyle.core.ConfigsCore;
import bbc_mc.TwoSwordStyle.core.EventsCore;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
    @author bbc_mc
    @date 2016/06/19
 */

@Mod(
        modid = TwoSwordStyle.MODID,
        name = TwoSwordStyle.MODNAME
)
public class TwoSwordStyle {
    public static final String MODID = "twoswordstyle";
    public static final String MODNAME = "TwoSwordStyle";

    @Mod.Instance(TwoSwordStyle.MODID)
    public static TwoSwordStyle instance;

    public TwoSwordStyle(){
        instance = this;
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // 設定読込
        ConfigsCore.configure(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // Event登録
        EventsCore.configure();

    }
}
