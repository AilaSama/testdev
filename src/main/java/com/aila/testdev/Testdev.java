package com.aila.testdev;

import com.aila.testdev.item.ModCreativeModeTabs;
import com.aila.testdev.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Testdev implements ModInitializer {
	public static final String MOD_ID = "testdev";

	//该记录器用于向控制台和日志文件写入文本。
	//使用你的模组ID作为日志员的名字被认为是最佳实践。
	//这样一来，就能清楚知道是哪个版主写了信息、警告和错误。
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModItems.register();
		ModCreativeModeTabs.register();
		LOGGER.info("Hello Fabric world!");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
