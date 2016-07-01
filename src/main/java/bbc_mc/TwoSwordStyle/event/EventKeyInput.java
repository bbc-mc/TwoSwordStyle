package bbc_mc.TwoSwordStyle.event;

import bbc_mc.TwoSwordStyle.core.ConfigsCore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHandSide;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

/**
 @author bbc_mc
 @date 2016/07/01 */
public class EventKeyInput {

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (Keyboard.isKeyDown(Keyboard.KEY_F)) {
            EntityPlayer player = FMLClientHandler.instance().getClientPlayerEntity();
            if (player != null) {
                EnumHandSide side = FMLClientHandler.instance().getClient().gameSettings.mainHand;
                if (!player.getPrimaryHand().equals(side)) {
                    player.setPrimaryHand(side);
                    if (ConfigsCore.isDebugMode) {
                        FMLLog.info("  MainHand changed to : " + FMLClientHandler.instance().getClient().gameSettings.mainHand.toString());
                    }
                }
            }
        }
    }
}
