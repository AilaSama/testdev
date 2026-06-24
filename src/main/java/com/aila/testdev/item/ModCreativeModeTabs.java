package com.aila.testdev.item;

import com.aila.testdev.Testdev;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {
    //======================================================================================
    // 栏目一：TESTDEV（你原本的第一个创造模式栏目）
    //======================================================================================
    //---从这里开始是一个创造模式栏目的创建---
    public static final ResourceKey<CreativeModeTab> TESTDEV_TAB = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(Testdev.MOD_ID, "testdev"));

    public static final CreativeModeTab TESTDEV = net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.THE_GRAVEL))
            .title(Component.translatable("itemGroup.testdev"))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.THE_GRAVEL);
                output.accept(ModItems.THE_EYE);
                output.accept(ModItems.THE_HEART);
                output.accept(ModItems.THE_TEAR);
            }).build();
    //---它在这里结束---


    //======================================================================================
    // 栏目二：TESTDEV2（举一反二：演示创建第二个栏目）
    //======================================================================================
    /* //---从这里开始是一个创造模式栏目的创建---
    // 1. 注册 Key 的变量名改为 TESTDEV2_TAB，注册路径改为 "testdev2"
    public static final ResourceKey<CreativeModeTab> TESTDEV2_TAB = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(Testdev.MOD_ID, "testdev2"));

    // 2. 栏目实例变量名改为 TESTDEV2
    public static final CreativeModeTab TESTDEV2 = net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.THE_EYE)) // 3. 图标换成你喜欢的物品（例如：眼睛）
            .title(Component.translatable("itemGroup.testdev2")) // 4. 语言文件 key 改为 itemGroup.testdev2
            .displayItems((parameters, output) -> {
                // 5. 这里放入你想在这个新栏目展示的物品
                output.accept(ModItems.THE_EYE);
            }).build();
    //---它在这里结束---
    */


    //======================================================================================
    // 栏目三：TESTDEV3（举一反二：演示创建第三个栏目）
    //======================================================================================
    /* //---从这里开始是一个创造模式栏目的创建---
    // 1. 注册 Key 的变量名改为 TESTDEV3_TAB，注册路径改为 "testdev3"
    public static final ResourceKey<CreativeModeTab> TESTDEV3_TAB = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(Testdev.MOD_ID, "testdev3"));

    // 2. 栏目实例变量名改为 TESTDEV3
    public static final CreativeModeTab TESTDEV3 = net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.THE_HEART)) // 3. 图标换成你喜欢的物品（例如：心脏）
            .title(Component.translatable("itemGroup.testdev3")) // 4. 语言文件 key 改为 itemGroup.testdev3
            .displayItems((parameters, output) -> {
                // 5. 这里放入你想在这个新栏目展示的物品
                output.accept(ModItems.THE_HEART);
                output.accept(ModItems.THE_TEAR);
            }).build();
    //---它在这里结束---
    */


    //如果你需要再创建一个新的创造模式物品栏，你可以复制其中的代码（请同步更改语言文件~）
    public static void register(){
        Testdev.LOGGER.info("Registering Custom Creative Mode Tabs for " + Testdev.MOD_ID);

        // 栏目一的注册
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TESTDEV_TAB, TESTDEV);

        // ⚠️ 以后如果启用了新栏目，别忘了在 register() 方法里把下面两行取消注释，完成对游戏的最终注册！
        // Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TESTDEV2_TAB, TESTDEV2);
        // Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TESTDEV3_TAB, TESTDEV3);
    }
}