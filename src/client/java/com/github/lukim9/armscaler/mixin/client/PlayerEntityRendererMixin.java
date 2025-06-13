package com.github.lukim9.armscaler.mixin.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityRenderer.class)
public abstract class PlayerEntityRendererMixin {

    @Inject(method = "renderRightArm", at = @At("HEAD"))
    private void scaleRightArm(
            MatrixStack matrices,
            VertexConsumerProvider vertexConsumers,
            int light,
            Identifier skinTexture,
            boolean sleeveVisible,
            CallbackInfo ci) {
        matrices.push();
        matrices.scale(3F, 3F, 3F);
    }

    @Inject(method = "renderRightArm", at = @At("RETURN"))
    private void resetRightArm(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, Identifier skinTexture, boolean sleeveVisible, CallbackInfo ci) {
        matrices.pop();
    }

    @Inject(method = "renderLeftArm", at = @At("HEAD"))
    private void scaleLeftArm(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, Identifier skinTexture, boolean sleeveVisible, CallbackInfo ci) {
        matrices.push();
        matrices.scale(3F, 3F, 3F);
    }

    @Inject(method = "renderLeftArm", at = @At("RETURN"))
    private void resetLeftArm(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, Identifier skinTexture, boolean sleeveVisible, CallbackInfo ci) {
        matrices.pop();
    }
}