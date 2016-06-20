package bbc_mc.TwoSwordStyle.core;

import bbc_mc.TwoSwordStyle.event.EventTwoHand;
import net.minecraftforge.common.MinecraftForge;

/**
 @author bbc_mc
 @date 2016/06/19
 */
public class EventsCore {
    public static void configure() {
        //FMLCommonHandler.instance().bus().register(new EventKeyInput());
        MinecraftForge.EVENT_BUS.register(new EventTwoHand());
    }
}
