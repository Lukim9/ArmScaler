package com.github.lukim9.armscaler.mixin.client;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.entity.LivingEntity;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityModel.class)
public abstract class PlayerEntityModelMixin<T extends LivingEntity> {
    @Unique public ModelPart leftArm;
    @Unique public ModelPart rightArm;

    @Inject(
            method = "setAngles(Lnet/minecraft/client/render/entity/state/PlayerEntityRenderState;)V",
            at = @At("TAIL")
    )
    private void scaleArms(
            PlayerEntityRenderState playerEntityRenderState, CallbackInfo ci
    ) {
        PlayerEntityModel self = (PlayerEntityModel)(Object)this;
        self.getParts().get(3).translate(new Vector3f(-3F, 3F, 0));
        self.getParts().get(7).translate(new Vector3f(3F, 3F, 0));
        self.getParts().get(1).scale(new Vector3f(-0.5F, -0.5F, -0.5F));
        self.getParts().get(3).scale(new Vector3f(3F, 1F, 3F));
        self.getParts().get(7).scale(new Vector3f(3F, 1F, 3F));
    }
}