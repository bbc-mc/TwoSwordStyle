package bbc_mc.TwoSwordStyle.event;

import bbc_mc.TwoSwordStyle.core.ConfigsCore;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

/**
 @author bbc_mc
 @date 2016/06/19
 */
public class EventTwoHand {

    @SubscribeEvent
    public void onAttackByTwoHand(AttackEntityEvent event){
        EntityPlayer player = event.getEntityPlayer();
        EntityLivingBase target = event.getEntityLiving();
        if(target == null || target.isDead){
            return;
        }
        //// 二刀流対象アイテムセットを持っている場合
        if( isPlayerEquipTargetWeapons(player) ){
            // 持っているアイテムの確認
            ItemStack itemMain = player.getHeldItemMainhand();
            ItemStack itemOff = player.getHeldItemOffhand();
            // 利き手の確認
            EnumHandSide handMain = player.getPrimaryHand();
            EnumHandSide handOff;
            if(handMain == EnumHandSide.LEFT){
                handOff = EnumHandSide.RIGHT;
            } else {
                handOff = EnumHandSide.LEFT;
            }
            //利き手を変更する
            player.setPrimaryHand(handOff);
            //アイテムを入れ替える
            player.setHeldItem(EnumHand.MAIN_HAND, itemOff);
            player.setHeldItem(EnumHand.OFF_HAND, itemMain);
        } else {
            logInfo("not target weapon [" + player.getHeldItemOffhand().getItem().getRegistryName().getResourcePath() + "]");
        }
    }

    /**
     二刀流対応のアイテムを選択しているかどうか
     @param player
     @return
     */
    private boolean isPlayerEquipTargetWeapons(EntityPlayer player){
        Item itemMain = player.getHeldItemMainhand().getItem();
        Item itemOff = player.getHeldItemOffhand().getItem();

        return isTargetWeapon(itemMain, itemOff, ConfigsCore.twoSwordStyleGroup1) ||
                isTargetWeapon(itemMain, itemOff, ConfigsCore.twoSwordStyleGroup2) ||
                isTargetWeapon(itemMain, itemOff, ConfigsCore.twoSwordStyleGroup3) ||
                isTargetWeapon(itemMain, itemOff, ConfigsCore.twoSwordStyleGroup4) ||
                isTargetWeapon(itemMain, itemOff, ConfigsCore.twoSwordStyleGroup5) ||
                isTargetWeapon(itemMain, itemOff, ConfigsCore.twoSwordStyleGroup6);
    }

    private boolean isTargetWeapon(Item item1, Item item2, List<String> list){
        if(item1==null || item2==null || list==null || list.isEmpty()){
            return false;
        } else {
            return list.contains(item1.getRegistryName().getResourcePath()) && list.contains(item2.getRegistryName().getResourcePath());
        }
    }

    private void logInfo(String str){
        if(ConfigsCore.isDebugMode){
            FMLLog.info(str);
        }
    }
}
