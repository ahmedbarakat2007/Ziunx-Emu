package org.yuzu.yuzu_emu.features.settings.model.view;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.yuzu.yuzu_emu.features.input.NativeInput;
import org.yuzu.yuzu_emu.features.input.model.AnalogDirection;
import org.yuzu.yuzu_emu.features.input.model.InputType;
import org.yuzu.yuzu_emu.features.input.model.NativeAnalog;
import org.yuzu.yuzu_emu.utils.ParamPackage;

/* loaded from: classes.dex */
public final class AnalogInputSetting extends InputSetting {
    private final AnalogDirection analogDirection;
    private final InputType inputType;
    private final NativeAnalog nativeAnalog;
    private final int playerIndex;
    private final int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalogInputSetting(int i, NativeAnalog nativeAnalog, AnalogDirection analogDirection, int i2, String titleString) {
        super(i2, titleString, null);
        Intrinsics.checkNotNullParameter(nativeAnalog, "nativeAnalog");
        Intrinsics.checkNotNullParameter(analogDirection, "analogDirection");
        Intrinsics.checkNotNullParameter(titleString, "titleString");
        this.playerIndex = i;
        this.nativeAnalog = nativeAnalog;
        this.analogDirection = analogDirection;
        this.type = 8;
        this.inputType = InputType.Stick;
    }

    public /* synthetic */ AnalogInputSetting(int i, NativeAnalog nativeAnalog, AnalogDirection analogDirection, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, nativeAnalog, analogDirection, (i3 & 8) != 0 ? 0 : i2, (i3 & 16) != 0 ? "" : str);
    }

    public final AnalogDirection getAnalogDirection() {
        return this.analogDirection;
    }

    @Override // org.yuzu.yuzu_emu.features.settings.model.view.InputSetting
    public InputType getInputType() {
        return this.inputType;
    }

    public final NativeAnalog getNativeAnalog() {
        return this.nativeAnalog;
    }

    @Override // org.yuzu.yuzu_emu.features.settings.model.view.InputSetting
    public int getPlayerIndex() {
        return this.playerIndex;
    }

    @Override // org.yuzu.yuzu_emu.features.settings.model.view.InputSetting
    public String getSelectedValue() {
        ParamPackage stickParam = NativeInput.INSTANCE.getStickParam(getPlayerIndex(), this.nativeAnalog);
        return getDisplayString(stickParam, analogToText(stickParam, this.analogDirection.getParam()));
    }

    @Override // org.yuzu.yuzu_emu.features.settings.model.view.InputSetting, org.yuzu.yuzu_emu.features.settings.model.view.SettingsItem
    public int getType() {
        return this.type;
    }

    @Override // org.yuzu.yuzu_emu.features.settings.model.view.InputSetting
    public void setSelectedValue(ParamPackage param) {
        Intrinsics.checkNotNullParameter(param, "param");
        NativeInput.INSTANCE.setStickParam(getPlayerIndex(), this.nativeAnalog, param);
    }
}
