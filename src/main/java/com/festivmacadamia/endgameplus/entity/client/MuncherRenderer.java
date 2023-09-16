package com.festivmacadamia.endgameplus.entity.client;

import com.festivmacadamia.endgameplus.EndGamePlus;
import com.festivmacadamia.endgameplus.entity.custom.MuncherEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MuncherRenderer extends GeoEntityRenderer<MuncherEntity> {
    public MuncherRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MuncherModel());
    }

    @Override
    public ResourceLocation getTextureLocation(MuncherEntity animatable) {
        return new ResourceLocation(EndGamePlus.MOD_ID, "textures/entity/muncher.png");
    }

    @Override
    public void render(MuncherEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}