package com.aila.testdev.item;

import com.aila.testdev.Testdev;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.impl.client.itemgroup.FabricCreativeGuiComponents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Function;

public class ModItems {
    //这是一些新物品the_gravel(碎石)，the_tear(泪水),the_heart(心脏),the_eye(眼球)
    //"material/the_gravel"是一个分类项目，他的路径会有所不同（仅用作测试，请忽略materials前置）
    public static final Item THE_GRAVEL = registerItem("material/the_gravel", Item::new);
    public static final Item THE_TEAR = registerItem("the_tear", Item::new);
    public static final Item THE_HEART = registerItem("the_heart", Item::new);
    public static final Item THE_EYE = registerItem("the_eye", Item::new);

    public static Item registerItem(String name, Function<Item.Properties, Item> function, Item.Properties properties) {
        ResourceKey<Item> key =ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Testdev.MOD_ID, name));
        Item item = function.apply(properties.setId(key));
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, item);
        }

        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }
    // 这是一个快捷重载方法，方便以后注册没有特殊属性的普通物品
    public static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return registerItem(name, function, new Item.Properties());
    }

    public static void register() {
        // 1. 打印你自己的模组日志提示
        Testdev.LOGGER.info("Registering Mod Items for " + Testdev.MOD_ID);

        // 2. 现代 Fabric 1.21.1 专属的正宗物品栏事件监听
        net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents.modifyEntriesEvent(net.minecraft.world.item.CreativeModeTabs.INGREDIENTS)
                .register(entries -> {
                    // 3. 把你刚才做的四个宝贝物品全部塞进“原材料”货架
                    entries.accept(THE_GRAVEL);
                    entries.accept(THE_TEAR);
                    entries.accept(THE_HEART);
                    entries.accept(THE_EYE);
                });
    }

    }
