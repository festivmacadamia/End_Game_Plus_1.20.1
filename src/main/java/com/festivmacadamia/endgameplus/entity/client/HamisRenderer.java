package com.festivmacadamia.endgameplus.entity.client;

import com.festivmacadamia.endgameplus.EndGamePlus;
import com.festivmacadamia.endgameplus.entity.custom.HamisEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class HamisRenderer extends GeoEntityRenderer<HamisEntity> {
    public HamisRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new HamisModel());
    }

    @Override
    public ResourceLocation getTextureLocation(HamisEntity animatable) {
        return new ResourceLocation(EndGamePlus.MOD_ID, "textures/entity/hamis.png");
    }

    @Override
    public void render(HamisEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}