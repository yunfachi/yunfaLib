package moe.yunfachi.yunfalib.injection.annotaml;

import net.william278.annotaml.Annotaml;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.lang.annotation.Annotation;

@Mixin(Annotaml.class)
public class MixinAnnotaml {
    @Redirect(remap=false, method = "<init>(Ljava/lang/Object;)V", at = @At(value = "INVOKE", target = "Ljava/lang/Class;isAnnotationPresent(Ljava/lang/Class;)Z"))
    private boolean injected(Class instance, Class<? extends Annotation> annotationClass) {
        return true;
    }
}
